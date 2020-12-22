package vn.edu.usth.minigh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CommitFragment extends Fragment {

    public CommitFragment() {
        super(R.layout.fragment_commit);
    }

    public static CommitFragment newInstance() {
        CommitFragment fragment = new CommitFragment();
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

        View view = inflater.inflate(R.layout.fragment_commit, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.branchSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.branchDropdown, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Switched to branch '" + parent.getItemAtPosition(position).toString() + "'";
                Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
                if(position == 0) {
                    MainCommitFragment mainCommit = new MainCommitFragment();
                    getFragmentManager().beginTransaction().replace(R.id.codeContent, mainCommit).commit();
                }
                else if(position == 1) {
                    Branch1CommitFragment branch1Commit = new Branch1CommitFragment();
                    getFragmentManager().beginTransaction().replace(R.id.codeContent, branch1Commit).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                MainCommitFragment mainCommit = new MainCommitFragment();
                getFragmentManager().beginTransaction().replace(R.id.codeContent, mainCommit).commit();
            }
        });
        return view;
    }
}