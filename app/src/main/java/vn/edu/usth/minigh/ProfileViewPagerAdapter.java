package vn.edu.usth.minigh;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProfileViewPagerAdapter extends FragmentPagerAdapter {
    Context context;

    public ProfileViewPagerAdapter(Context _context, @NonNull FragmentManager fm) {
        super(fm);
        this.context = _context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new RepoListFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Pinned";
            default: return super.getPageTitle(position);
        }
    }
}
