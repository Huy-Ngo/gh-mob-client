package vn.edu.usth.minigh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class opentabFragment extends Fragment {

    public opentabFragment() {
        // Required empty public constructor
        super(R.layout.fragment_opentab);
    }

    public static opentabFragment newInstance() {
        opentabFragment fragment = new opentabFragment();
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
        return inflater.inflate(R.layout.fragment_opentab, container, false);
    }
}