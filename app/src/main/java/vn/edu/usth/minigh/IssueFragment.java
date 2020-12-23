package vn.edu.usth.minigh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IssueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IssueFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IssueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IssueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IssueFragment newInstance(String param1, String param2) {
        IssueFragment fragment = new IssueFragment();
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
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_issue, container, false);
        FrameLayout fl = (FrameLayout)view.findViewById(R.id.issuesFragment);
        for (int i = 0; i< 5; i++) {
            LinearLayout ll = new LinearLayout(this.getActivity());
            LinearLayout.LayoutParams paramll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            paramll.setMargins(0, 10, 0, 10);
            ll.setLayoutParams(paramll);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setPadding(10,10,10,10);
            ll.setBackground(getResources().getDrawable(R.drawable.styling_commit));
            ll.setHorizontalGravity(View.TEXT_ALIGNMENT_CENTER);

            ImageView iv = new ImageView(this.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(12, 12, 12, 12);
            iv.setLayoutParams(params);
            iv.setScaleType(ImageView.ScaleType.FIT_START);
            iv.setPadding(12, 12, 12, 12);
            iv.setBackground(getResources().getDrawable(R.drawable.pricon));
            ll.addView(iv);

            LinearLayout llinner = new LinearLayout(this.getContext());
            LinearLayout.LayoutParams paramllInner = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            paramllInner.setMargins(10, 10, 10, 10);
            llinner.setLayoutParams(paramllInner);
            llinner.setOrientation(LinearLayout.VERTICAL);
            ll.addView(llinner);

            TextView reponame = new TextView(this.getContext());
            LinearLayout.LayoutParams txtparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            reponame.setTextSize(18);
            reponame.setLayoutParams(txtparam);
            reponame.setText("GHname/GHREPOname #8"+i);
            llinner.addView(reponame);

            TextView issues = new TextView(this.getContext());
            issues.setTextSize(18);
            issues.setLayoutParams(txtparam);
            issues.setText("Ex PR #8");
            issues.setTextColor(getResources().getColor(R.color.secondaryTextColor));
            llinner.addView(issues);
            fl.addView(ll);
        }
        return view;
    }
}