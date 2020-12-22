/* Fragment for previewing repo
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

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.androidhive.fontawesome.FontTextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RepoPreviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RepoPreviewFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "owner";
    private static final String ARG_PARAM2 = "name";
    private static final String ARG_PARAM3 = "description";
    private static final String ARG_PARAM4 = "stars";
    private static final String ARG_PARAM5 = "forks";
    private static final String ARG_PARAM6 = "mainLanguage";
    private static final String ARG_PARAM7 = "license";

    private String mOwner;
    private String mName;
    private String mDescription;
    private int mStars;
    private int mForks;
    private String mMainLanguage;
    private String mLicense;

    public RepoPreviewFragment() {
        // Required empty public constructor
    }

    /**
     * Create a fragment for repo preview
     *
     * @param owner Owner of the repository.
     * @param name Name of the repository.
     * @param description Description of the repository.
     * @param stars The number of people who starred this repository.
     * @param forks The number of people who forked this repository.
     * @param mainLanguage The main language used in this repository.
     * @param license The license used for this repository.
     * @return A new instance of fragment RepoPreviewFragment.
     */
    public static RepoPreviewFragment newInstance(String owner, String name, String description,
                                                  int stars, int forks, String mainLanguage, String license) {
        RepoPreviewFragment fragment = new RepoPreviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, owner);
        args.putString(ARG_PARAM2, name);
        args.putString(ARG_PARAM3, description);
        args.putInt(ARG_PARAM4, stars);
        args.putInt(ARG_PARAM5, forks);
        args.putString(ARG_PARAM6, mainLanguage);
        args.putString(ARG_PARAM7, license);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mOwner = getArguments().getString(ARG_PARAM1);
            mName = getArguments().getString(ARG_PARAM2);
            mDescription = getArguments().getString(ARG_PARAM3);
            mStars = getArguments().getInt(ARG_PARAM4);
            mForks = getArguments().getInt(ARG_PARAM5);
            mMainLanguage = getArguments().getString(ARG_PARAM6);
            mLicense = getArguments().getString(ARG_PARAM7);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_repo_preview, container, false);
        TextView repoName = view.findViewById(R.id.repo_name_text);
        repoName.setTypeface(null, Typeface.BOLD);
        repoName.setTextSize(18);
        repoName.setText(String.format("%s/%s", mOwner, mName));
        TextView description = view.findViewById(R.id.description_text);
        description.setText(mDescription);

        // TODO: For following fields, if any is unavailable, hide the whole LinearLayout
        FontTextView languageIcon = view.findViewById(R.id.language_icon);
        TextView languageText = view.findViewById(R.id.language_text);
        languageIcon.setTextColor(this.getMainLanguageColor());
        languageText.setText(mMainLanguage);

        TextView starCount = view.findViewById(R.id.stars_text);
        starCount.setText(String.valueOf(mStars));

        TextView forkCount = view.findViewById(R.id.forks_text);
        forkCount.setText(String.valueOf(mForks));

        TextView licenseText = view.findViewById(R.id.license_text);
        licenseText.setText(mLicense);
        return view;
    }

    /**
     * Return the color for the main language
     * */
    private int getMainLanguageColor() {
        // TODO: get color from https://github.com/ozh/github-colors/blob/master/colors.json
        switch(this.mMainLanguage) {
            case "C":
                return Color.parseColor("#555555");
            case "C#":
                return Color.parseColor("#178600");
            case "C++":
                return Color.parseColor("#F34B7D");
            case "Java":
                return Color.parseColor("#b07219");
            case "JavaScript":
                return Color.parseColor("#f1e05a");
            case "Python":
                return Color.parseColor("#3572A5");
            case "PHP":
                return Color.parseColor("#4F5D95");
            default:
                return Color.BLACK;
        }
    }
}
