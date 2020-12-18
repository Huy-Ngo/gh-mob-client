package vn.edu.usth.minigh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class codeFragment extends Fragment {

    public codeFragment() {
        // Required empty public constructor
        super(R.layout.fragment_code);
    }

    public static codeFragment newInstance() {
        codeFragment fragment = new codeFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
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

        View view = inflater.inflate(R.layout.fragment_code, container, false);
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
                    mainlistFragment mainCode = new mainlistFragment();
                    getFragmentManager().beginTransaction().replace(R.id.codeContent, mainCode).commit();
                }
                else if(position == 1) {
                    branch1Fragment branchCode = new branch1Fragment();
                    getFragmentManager().beginTransaction().replace(R.id.codeContent, branchCode).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        return view;
    }

}