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
 * but WITHOUT ANY WARRANTY without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with MiniGH.  If not, see <https://www.gnu.org/licenses/>.
 */
package vn.edu.usth.minigh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

import vn.edu.usth.minigh.fragments.RepoListFragment

class ProfileActivity : BaseActivity(R.layout.activity_profile) {
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val drawerTab = findViewById<LinearLayout>(R.id.profile)
        drawerTab.setBackgroundColor(getColor(R.color.secondaryColor))

        val txtToolbar = findViewById<TextView>(R.id.main_text_bar)
        txtToolbar.setText(R.string.username)

        viewPager = findViewById(R.id.profile_view_pager)
        viewPager.setAdapter(object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 2
            override fun createFragment(position: Int): Fragment =
                RepoListFragment(if (position == 0) 6 else 69)
        })

        val tabLayout = findViewById<TabLayout>(R.id.profile_tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = if (position == 0) "Pinned" else "All Repositories"
        }.attach()
    }

    override fun onBackPressed() {
        if (viewPager.getCurrentItem() == 0)
            super.onBackPressed()
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1)
    }

    fun goToRepo(view: View) {
        val intent = Intent(this, RepoActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
