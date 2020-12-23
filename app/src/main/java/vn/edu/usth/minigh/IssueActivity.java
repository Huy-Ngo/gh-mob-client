package vn.edu.usth.minigh;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IssueActivity extends BaseActivity {

    public IssueActivity() {
        super(R.layout.activity_issue);
    }
    TextView txt_check;
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
        txt_check = (TextView)findViewById(R.id.textCheck);
        sg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    default:
                        Bundle bundle = new Bundle();
                        bundle.putString("issueStatus", "Open");
                        IssueFragment frag = new IssueFragment();
                        frag.setArguments(bundle);
                        addFrag("Open");
                        break;
                    case R.id.button22:
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("issueStatus", "Close");
                        IssueFragment frag2 = new IssueFragment();
                        frag2.setArguments(bundle2);
                        txt_check.setText("Close");
                        addFrag("Close");
                        break;
                }
            }
        });

    }
    public void addFrag(String txt){
        txt_check.setText(txt);
    }
}