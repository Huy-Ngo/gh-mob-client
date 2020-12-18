package vn.edu.usth.minigh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class RepoActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);

        TextView follower = (TextView) findViewById(R.id.follower_total);
        follower.setText(Html.fromHtml("<b>"+5+"</b> Follower"));
        TextView following = (TextView) findViewById(R.id.following_total);
        following.setText((Html.fromHtml("<b>"+5+"</b> Following")));

        TextView txt_toolbar = (TextView) findViewById(R.id.main_text_bar);
        txt_toolbar.setText("Repository");
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu (View view){
        ProfileActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        ProfileActivity.closeDrawer(drawerLayout);
    }
    public void ClickProfile(View view){
        ProfileActivity.redirectActivity(this, ProfileActivity.class);
    }
    public void ClickRepo(View view){
        recreate();
    }

    @Override
    protected void onPause(){
        super.onPause();
        ProfileActivity.closeDrawer(drawerLayout);
    }
}