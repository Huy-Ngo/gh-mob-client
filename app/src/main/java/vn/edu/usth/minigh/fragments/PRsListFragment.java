package vn.edu.usth.minigh.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import vn.edu.usth.minigh.PRDiscussionActivity;
import vn.edu.usth.minigh.R;

public class PRsListFragment extends Fragment {
    Fragment frag;

    public PRsListFragment() {
        super(R.layout.fragment_pr);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pr, container, false);
        RadioGroup sg = (RadioGroup) view.findViewById(R.id.segmented2);
        sg.check(R.id.button31);
        addFrag("pr", 5);
        sg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    default:
                        addFrag("pr", 5);
                        break;
                    case R.id.button32:
                        addFrag("Close", 3);
                        break;
                }
            }
        });
        return view;
    }
    public void addFrag(String txt, int number){
        FragmentManager fm = getFragmentManager();
        frag = fm.findFragmentById(R.id.prsFragment);
        FragmentTransaction ft = fm.beginTransaction();
        frag = new PullRequestFragment(txt, number);
        ft.replace(R.id.prsFragment, frag);
        ft.commit();
    }

    public void goToPR(View view) {
        Intent intent = new Intent(getContext(), PRDiscussionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
