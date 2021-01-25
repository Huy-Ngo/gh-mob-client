package vn.edu.usth.minigh.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import vn.edu.usth.minigh.R
import vn.edu.usth.minigh.api.github
import java.util.*

class RepoLogFragment : Fragment(R.layout.fragment_repo_log) {
    var frag: Fragment? = null
    private lateinit var repo_name: String
    private lateinit var branches: List<String>
//    private lateinit var sha_array: List<String>
//    private lateinit var numoffrags: Array<Int>
//    var num_of_view: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_repo_log, container, false)
        repo_name = requireArguments().getString("repo name")!!
        lifecycleScope.launch {
            val spinner = view.findViewById<View>(R.id.branchSpinner) as Spinner
//            val branches: MutableList<String> = ArrayList()
//            branches.add("main")
//            branches.add("fix")
            branches = github.branches(repo_name).map { it.name }
//            for(i in branches) {
//                sha_array = github.numofcommits(repo_name, branches[i]).map { it.sha }
//                numoffrags[i] = sha_array.size
//            }
            val adapter = ArrayAdapter(context!!,
                    android.R.layout.simple_spinner_item, branches)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                    if (position == 0) {
//                    CommitBranch1Fragment mainCommit = new CommitBranch1Fragment();
//                    getChildFragmentManager().beginTransaction().replace(R.id.commitContent, mainCommit).commit();
                        addFrag("main", 4)
                    } else if (position == 1) {
//                    CommitBranch1Fragment branch1Commit = new CommitBranch1Fragment();
//                    getChildFragmentManager().beginTransaction().replace(R.id.commitContent, branch1Commit).commit();
                        addFrag("notmain", 5)
                    }
//                    addFrag(branches[position], num_of_view[position])

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
        return view
    }

    fun addFrag(branch: String?, number: Int) {
        val fm = childFragmentManager
        frag = fm.findFragmentById(R.id.commitContent)
        val ft = fm.beginTransaction()
        frag = CommitListFragment(branch, number)
        ft.replace(R.id.commitContent, frag as CommitListFragment)
        ft.commit()
    }
}