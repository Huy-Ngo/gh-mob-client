package vn.edu.usth.minigh.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vn.edu.usth.minigh.R

class CommitListFragment : Fragment {
    private var nBranch: String? = null
    private var nNumber = 0

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    constructor() {}
    constructor(branch: String?, number: Int) {
        nBranch = branch
        nNumber = number
    }

    private fun generateForm(i: Int): CommitPreviewFragment {
        val fragment = CommitPreviewFragment()
        val logs = arrayOf("Commit 5", "Commit 4", "Commit 3", "Commit 2", "Commit 1")
        val ats = arrayOf("Phong-Nguyen", "Huy-Ngo", "Minh-Ngo", "Phuong-Trinh", "Long-Pham")
        val args = Bundle()
        args.putString("commits", logs[i])
        args.putString("authors", ats[i])
        args.putString("branches", nBranch)
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
            mParam2 = requireArguments().getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_commit_list, container, false)
        for (i in 0 until nNumber) {
            val commititem: Fragment = generateForm(i)
            childFragmentManager.beginTransaction().add(R.id.commitcontainer, commititem).commit()
        }
        return view
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        fun newInstance(param1: String?, param2: String?): CommitListFragment {
            val fragment = CommitListFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}