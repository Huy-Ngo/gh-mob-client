package vn.edu.usth.minigh.fragments

import kotlinx.coroutines.launch

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.LinearLayout.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import android.widget.TextView

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope

import info.androidhive.fontawesome.FontCache
import info.androidhive.fontawesome.FontTextView

import vn.edu.usth.minigh.R
import vn.edu.usth.minigh.api.github

class TreeNodeFragment : Fragment(R.layout.fragment_tree_node) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = requireArguments()
        view.findViewById<TextView>(R.id.content_name).text =
            args.getString("name")

        val contentType = view.findViewById<FontTextView>(R.id.content_type)
        // TODO: handle symlinks and git submodules
        val type = if (args.getString("type") == "dir") {
            contentType.text = getString(R.string.fa_folder)
            contentType.setTypeface(FontCache.get(
                contentType.context, "fa-solid-900.ttf"))
        } else {
            contentType.text = getString(R.string.fa_file)
        }
    }
}

class TreeFragment : Fragment(R.layout.fragment_tree) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = requireArguments()
        lifecycleScope.launch {
            childFragmentManager.commit {
                github.contents(
                    args.getString("repo name")!!,
                    args.getString("branch")!!
                ).sortedBy { it.type }.map {
                    add<TreeNodeFragment>(
                        R.id.node_list,
                        args = bundleOf("name" to it.name, "type" to it.type))
                }
                // FIXME: this interferes with the one on summary tab
                (view as LinearLayout).layoutParams =
                    LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            }
        }
    }
}