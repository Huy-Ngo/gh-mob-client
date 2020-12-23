package vn.edu.usth.minigh;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class IssueActivity extends BaseActivity {
    Fragment frag;

    public IssueActivity() {
        super(R.layout.activity_issue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);

        TextView txt_toolbar = (TextView) findViewById(R.id.main_text_bar);
        txt_toolbar.setText("Issues");
        LinearLayout layout = this.findViewById(R.id.issues);
        layout.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.secondaryColor));

        RadioGroup sg = (RadioGroup)findViewById(R.id.segmented2);
        sg.check(R.id.button21);
        addFrag("Open");
        sg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    default:
                        addFrag("Open");
                        break;
                    case R.id.button22:
                        addFrag("Close");
                        break;
                }
            }
        });

    }
    public void addFrag(String txt){
        if (txt=="Open"){
            FragmentManager fm = getSupportFragmentManager();
            frag = fm.findFragmentById(R.id.issuesFragment);
            FragmentTransaction ft = fm.beginTransaction();
            frag = new IssueFragment();
            Bundle bundle = new Bundle();
            bundle.putString("IssueStatus",  txt);
            frag.setArguments(bundle);
            ft.replace(R.id.issuesFragment, frag);
            ft.commit();

        }
        if(txt == "Close"){
            FragmentManager fm = getSupportFragmentManager();
            frag = fm.findFragmentById(R.id.issuesFragment);
            FragmentTransaction ft = fm.beginTransaction();
            frag = new IssuesClosedFragment();
            ft.replace(R.id.issuesFragment, frag);
            ft.commit();
//            FrameLayout fl = (FrameLayout)findViewById(R.id.issuesFragment);
//            for (int i = 0; i< 3; i++) {
//                LinearLayout ll = new LinearLayout(this);
//                LinearLayout.LayoutParams paramll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                paramll.setMargins(0, 10, 0, 10);
//                ll.setLayoutParams(paramll);
//                ll.setOrientation(LinearLayout.HORIZONTAL);
//                ll.setBackground(getResources().getDrawable(R.drawable.styling_commit));
//                ll.setHorizontalGravity(View.TEXT_ALIGNMENT_CENTER);
//
//
//                ImageView iv = new ImageView(this);
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                params.setMargins(12, 12, 12, 12);
//                iv.setLayoutParams(params);
//                iv.setScaleType(ImageView.ScaleType.FIT_START);
//                iv.setPadding(12, 12, 12, 12);
//                iv.setBackground(getResources().getDrawable(R.drawable.done));
//                ll.addView(iv);
//
//                LinearLayout llinner = new LinearLayout(this);
//                LinearLayout.LayoutParams paramllInner = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                paramllInner.setMargins(10, 10, 10, 10);
//                llinner.setLayoutParams(paramllInner);
//                llinner.setOrientation(LinearLayout.VERTICAL);
//                ll.addView(llinner);
//
//                TextView reponame = new TextView(this);
//                LinearLayout.LayoutParams txtparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                reponame.setTextSize(18);
//                reponame.setLayoutParams(txtparam);
//                reponame.setText("GHname/GHREPOname #8"+i);
//                llinner.addView(reponame);
//
//                TextView issues = new TextView(this);
//                issues.setTextSize(18);
//                issues.setLayoutParams(txtparam);
//                issues.setText("Ex PR #8");
//                issues.setTextColor(getResources().getColor(R.color.secondaryTextColor));
//                llinner.addView(issues);
//                fl.addView(ll);
//            }
        }
    }
}