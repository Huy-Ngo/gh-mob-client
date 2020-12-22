package vn.edu.usth.minigh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class prActivity extends BaseActivity {

    public prActivity() {
        super(R.layout.activity_pr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr);
        TextView txt_toolbar = (TextView) findViewById(R.id.main_text_bar);
        txt_toolbar.setText("Pull Requests");
        LinearLayout layout = this.findViewById(R.id.prs);
        layout.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.secondaryColor));
    }
}