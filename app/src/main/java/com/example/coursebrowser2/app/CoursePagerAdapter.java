package com.example.coursebrowser2.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by mamanzan on 5/20/2014.
 */
public class CoursePagerAdapter extends FragmentPagerAdapter {  //FragmentStatePagerAdapter, for real times updates

    String[] mCourseTitles;
    String[] mCourseTitlesShort;
    String[] mCourseDescriptions;

    @Override
    public CharSequence getPageTitle(int position) {
        return mCourseTitlesShort[position];
    }

    public CoursePagerAdapter(FragmentManager fm, Context context){
        super(fm);

        Resources resources = context.getResources();
        mCourseTitles = resources.getStringArray(R.array.course_titles);
        mCourseTitlesShort = resources.getStringArray(R.array.course_title_short);
        mCourseDescriptions = resources.getStringArray(R.array.course_descriptions);
    }

    @Override //Terllme what to display per page
    public Fragment getItem(int position) {
        Bundle arguments = new Bundle();
        arguments.putString(CourseInfoFragment.COURSE_TITLE, mCourseTitles[position]);
        arguments.putString(CourseInfoFragment.COURSE_DESCRIPTIONS, mCourseDescriptions[position]);
        arguments.putInt(CourseInfoFragment.TOP_CARD, translateTopCardIndex(position));
        arguments.putInt(CourseInfoFragment.COURSE_TYPE_LOGO, R.drawable.ic_launcher);

        CourseInfoFragment courseInfoFragment = new CourseInfoFragment();
        courseInfoFragment.setArguments(arguments);
        return courseInfoFragment;
    }

    private int translateTopCardIndex(int position) {
        int resourceId=0;

        switch(position)
        {
            case 0:
                resourceId = R.drawable.ic_action_01;
                break;
            case 1:
                resourceId = R.drawable.ic_action_02;
                break;
            case 2:
                resourceId = R.drawable.ic_action_03;
                break;
            case 3:
                resourceId = R.drawable.ic_action_04;
                break;
            case 4:
                resourceId = R.drawable.ic_action_05;
                break;
            case 5:
                resourceId = R.drawable.ic_action_06;
                break;
            case 6:
                resourceId = R.drawable.ic_action_07;
                break;
            case 7:
                resourceId = R.drawable.ic_action_08;
                break;
        }

        return resourceId;
    }

    @Override
    public int getCount() {
        return mCourseTitles.length;
    }
}
