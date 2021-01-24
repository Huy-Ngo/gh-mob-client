package vn.edu.usth.minigh.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.minigh.R;

public class CommitMainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String nBranch;
    private int nNumber;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CommitMainFragment() {}

    public CommitMainFragment(String branch, int number){
        this.nBranch = branch;
        this.nNumber = number;
    }

    private CommitBranch1Fragment generateForm(int i){
        CommitBranch1Fragment fragment = new CommitBranch1Fragment();
        String[] logs = new String[] {"Commit 5","Commit 4","Commit 3","Commit 2","Commit 1"};
        String[] ats = new String[] {"Phong-Nguyen","Huy-Ngo","Minh-Ngo", "Phuong-Trinh", "Long-Pham"};
        Bundle args = new Bundle();
        args.putString("commits", logs[i]);
        args.putString("authors", ats[i]);
        args.putString("branches", nBranch);
        fragment.setArguments(args);
        return fragment;
    }

    public static CommitMainFragment newInstance(String param1, String param2){
        CommitMainFragment fragment = new CommitMainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commit_main, container, false);
        for (int i=0; i<nNumber; i++){
            Fragment commititem = this.generateForm(i);
            getChildFragmentManager().beginTransaction().add(R.id.commitcontainer,commititem).commit();
        }
        return view;
    }
}
