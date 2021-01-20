package vn.edu.usth.minigh.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import vn.edu.usth.minigh.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IssuePrFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IssuePrFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "ghname";
    private static final String ARG_PARAM2 = "listIP";
    private  static  final String ARG_PARAM3 = "status";

    // TODO: Rename and change types of parameters
    private String mGHName ;
    private String mContent ;
    private String mStatus ;

    public IssuePrFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IssuePrFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IssuePrFragment newInstance(String param1, String param2) {
        IssuePrFragment fragment = new IssuePrFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "ghname");
        args.putString(ARG_PARAM2, "listIP");
        args.putString(ARG_PARAM3, "status");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mGHName = getArguments().getString(ARG_PARAM1);
            mContent = getArguments().getString(ARG_PARAM2);
            mStatus = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_issue_pr, container, false);
        ImageView image = view.findViewById(R.id.imageIP);
        if(mStatus == "Close"){
            image.setBackgroundResource(R.drawable.done);
        }else if (mStatus == "pr"){
            image.setBackgroundResource(R.drawable.pricon);
        }
        else{
            image.setBackgroundResource(R.drawable.error);
        }
        TextView name = view.findViewById(R.id.ghnameIP);
        name.setText(mGHName);
        TextView ipContent = view.findViewById(R.id.contentIP);
        ipContent.setText(mContent);

        LinearLayout ll = view.findViewById(R.id.clickIP);
        ll.setTag(mGHName);

//        String value = (String) v.getTag();
//        Intent intent = new Intent(getActivity().getBaseContext(), DiscussionActivity.class);
//        intent.putExtra("ghname", value);
//        getActivity().startActivity(intent);
        return view;
    }
}