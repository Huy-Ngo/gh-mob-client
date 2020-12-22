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

public class CommitFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager pager;
    private int[] tabIcons = {
            R.drawable.error,
            R.drawable.done
    };

    public CommitFragment() {
        super(R.layout.fragment_commit);
    }

    public static CommitFragment newInstance() {
        CommitFragment fragment = new CommitFragment();
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
        View view = inflater.inflate(R.layout.fragment_commit, container, false);
        PagerAdapter adapter = new HomePagerAdapter(getFragmentManager());
        ViewPager pager = (ViewPager) view.findViewById(R.id.pagerCommit);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabCommit);
//        tabLayout.addTab(tabLayout.newTab().setText("Open").setIcon(R.drawable.error));
//        tabLayout.addTab(tabLayout.newTab().setText("Closed").setIcon(R.drawable.done));
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);
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
                case 0: return OpenTabFragment.newInstance();
                case 1: return ClosedTabFragment.newInstance();
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            Drawable image = ContextCompat.getDrawable(getContext(), tabIcons[position]);
//            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//            SpannableString sb = new SpannableString(" " + titles[position]);
//            ImageSpan imageSpan = new ImageSpan(image);
//            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            return sb;
            return titles[position];
        }
    }
}
