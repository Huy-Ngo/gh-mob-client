package vn.edu.usth.minigh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;

public class IssuesFragment extends Fragment {
//    private TabLayout tabLayout;
//    private ViewPager pager;
//    private int[] tabIcons = {
//            R.drawable.error,
//            R.drawable.done
//    };

    public IssuesFragment() {
        super(R.layout.fragment_issues);
    }

    public static IssuesFragment newInstance() {
        IssuesFragment fragment = new IssuesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_issues, container, false);

        PagerAdapter adapter = new HomePagerAdapter(getFragmentManager());
        ViewPager pager = (ViewPager) view.findViewById(R.id.pagerIssue);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabIssue);
        tabLayout.setupWithViewPager(pager);
        return view;
    }

    public class HomePagerAdapter extends FragmentPagerAdapter {
        private String titles[] = new String[] {"Open", "Closed"};
        public HomePagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int page) {
            Fragment fragment = null;
            switch (page) {
                case 0: return new OpenTabFragment();
                case 1: return new ClosedTabFragment();
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
