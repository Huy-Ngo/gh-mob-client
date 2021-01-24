package vn.edu.usth.minigh.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.edu.usth.minigh.R;

public class CommitPreviewFragment extends Fragment {
    private static final String ARG_PARAM1 = "commits";
    private static final String ARG_PARAM2 = "authors";
    private static final String ARG_PARAM3 = "branches";

    private String mCommits;
    private String mAuthors;
    private String mBranches;

    public CommitPreviewFragment() {}

    public static CommitPreviewFragment newInstance(String param1, String param2){
        CommitPreviewFragment fragment = new CommitPreviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "commits");
        args.putString(ARG_PARAM2, "authors");
        args.putString(ARG_PARAM3, "branches");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCommits = getArguments().getString(ARG_PARAM1);
            mAuthors = getArguments().getString(ARG_PARAM2);
            mBranches = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commit_preview, container, false);
        TextView log = view.findViewById(R.id.commitlog);
        log.setText(mCommits);
        TextView ath = view.findViewById(R.id.commitauthor);
        ath.setText(mAuthors);
        return view;
    }
}
