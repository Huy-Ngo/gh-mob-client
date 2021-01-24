package vn.edu.usth.minigh.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.minigh.R;

public class RepoLogFragment extends Fragment {
    Fragment frag;

    public RepoLogFragment() {
        super(R.layout.fragment_repo_log);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_repo_log, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.branchSpinner);
        List<String> branches = new ArrayList<String>();
        branches.add("main");
        branches.add("fix");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, branches);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
//                    CommitBranch1Fragment mainCommit = new CommitBranch1Fragment();
//                    getChildFragmentManager().beginTransaction().replace(R.id.commitContent, mainCommit).commit();
                    addFrag("main", 4);
                }
                else if(position == 1) {
//                    CommitBranch1Fragment branch1Commit = new CommitBranch1Fragment();
//                    getChildFragmentManager().beginTransaction().replace(R.id.commitContent, branch1Commit).commit();
                    addFrag("notmain", 5);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return view;
    }

    public void addFrag(String branch, int number){
        FragmentManager fm = getChildFragmentManager();
        frag = fm.findFragmentById(R.id.commitContent);
        FragmentTransaction ft = fm.beginTransaction();
        frag = new CommitListFragment(branch, number);
        ft.replace(R.id.commitContent, frag);
        ft.commit();
    }
}
