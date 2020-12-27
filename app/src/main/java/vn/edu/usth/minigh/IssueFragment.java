package vn.edu.usth.minigh;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private String nStatus;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IssueFragment() {
        // Required empty public constructor
    }
    public IssueFragment(String status) {
        // Required empty public constructor
        this.nStatus = status;
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
        View view = inflater.inflate(R.layout.fragment_issue, container, false);

        String[] ghname = new String[] {"GHname/GHREPOname #1", "GHname/GHREPOname #2",
                "GHname/GHREPOname #3", "GHname/GHREPOname #4", "GHname/GHREPOname #5"};
        String[] issuelist = new String[] {"Better name", "Initial design", "Make all function, activities, fragments",
        "Find bugs/ errors", "Finish project"};
        LinearLayout check = (LinearLayout) view.findViewById(R.id.issueTest);
        for(int i = 0; i< 5; i++){
            LinearLayout ll = new LinearLayout(this.getActivity());
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            param.setMargins(16, 9, 9, 16);
            param.gravity = Gravity.CENTER_HORIZONTAL;
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setClickable(true);
            ll.setPadding(0, 10, 0, 10);
            ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), IssueDiscussionActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
            ll.setBackground(getResources().getDrawable(R.drawable.styling_commit));
            ll.setLayoutParams(param);

            ImageView img = new ImageView(this.getContext());
            LinearLayout.LayoutParams imgParam = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if(nStatus == "Close"){
                img.setBackground(getResources().getDrawable(R.drawable.done));
            } else {
                img.setBackground(getResources().getDrawable(R.drawable.error));
            }
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            img.setPadding(0, 24, 0, 24);
            imgParam.setMargins(16, 9, 0, 9);
            img.setLayoutParams(imgParam);
            ll.addView(img);

            LinearLayout llchild = new LinearLayout(this.getContext());
            LinearLayout.LayoutParams paramChild = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            paramChild.setMargins(9, 9, 9, 9);
            llchild.setLayoutParams(paramChild);
            llchild.setOrientation(LinearLayout.VERTICAL);

            TextView reponame = new TextView(this.getContext());
            LinearLayout.LayoutParams paramTxt = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            reponame.setLayoutParams(paramTxt);
            reponame.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            reponame.setText(ghname[i]);
            llchild.addView(reponame);

            TextView issueTxt = new TextView(this.getContext());
            issueTxt.setLayoutParams(paramTxt);
            issueTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            issueTxt.setText(issuelist[i] +" "+ nStatus);
            issueTxt.setTextColor(getResources().getColor(R.color.secondaryTextColor));
            llchild.addView(issueTxt);

            ll.addView(llchild);
            check.addView(ll);
        }

        return view;
    }
}