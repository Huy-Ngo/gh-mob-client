/* Activity for user profile
 * Copyright (C) 2020  Ngô Ngọc Đức Huy
 * This file is part of MiniGH.
 *
 * MiniGH is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MiniGH is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with MiniGH.  If not, see <https://www.gnu.org/licenses/>.
**/
package vn.edu.usth.minigh;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ProfileActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TextView txt_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        drawerLayout = findViewById(R.id.drawer_layout);
        TextView follower = (TextView) findViewById(R.id.follower_total);
        follower.setText(Html.fromHtml("<b>"+5+"</b> Follower"));
        TextView following = (TextView) findViewById(R.id.following_total);
        following.setText((Html.fromHtml("<b>"+5+"</b> Following")));

        txt_toolbar = (TextView) findViewById(R.id.main_text_bar);
        txt_toolbar.setText(this.getApplicationContext().getText(R.string.profile));
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickProfile(View view){
        recreate();
    }

    public void ClickRepo(View view){
        redirectActivity(this, RepoActivity.class);
    }

    public void Logout(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log out");
        builder.setMessage("Are you sure you want to log out?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SessionManagement sessionManagement = new SessionManagement(getApplicationContext());
                sessionManagement.removeSession();
                redirectActivity(ProfileActivity.this, AuthActivity.class);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aclass) {
        Intent intent = new Intent(activity, aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }
}