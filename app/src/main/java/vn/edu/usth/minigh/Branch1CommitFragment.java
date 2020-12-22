package vn.edu.usth.minigh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Branch1CommitFragment extends Fragment {

    public Branch1CommitFragment() {
        super(R.layout.fragment_branch1_commit);
    }

    public static Branch1CommitFragment newInstance() {
        Branch1CommitFragment fragment = new Branch1CommitFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_branch1_commit, container, false);
    }
}