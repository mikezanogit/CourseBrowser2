package com.example.coursebrowser2.app;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CourseInfoFragment extends Fragment {

    public final static String COURSE_TITLE = "course title";
    public final static String COURSE_DESCRIPTIONS = "course descriptions";
    public final static String TOP_CARD = "top card";
    public final static String COURSE_TYPE_LOGO = "course type logo";


    public CourseInfoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View theView = inflater.inflate(R.layout.fragment_course_info, container, false);//inflate but don't attach

        Bundle arguments = getArguments();
        if (arguments != null) {
            String courseTitle = arguments.getString(COURSE_TITLE);
            String courseDescription = arguments.getString(COURSE_DESCRIPTIONS);
            int topCardResourceId = arguments.getInt(TOP_CARD);
            int courseTypeLogoResourceId = arguments.getInt(COURSE_TYPE_LOGO);

            displayValues(theView, courseTitle, courseDescription, topCardResourceId, courseTypeLogoResourceId);
        }
        return theView;
    }

    private void displayValues(View theView, String courseTitle, String courseDescription, int topCardResourceId, int courseTypeLogoResourceId) {
        TextView courseTitleTextView = (TextView) theView.findViewById(R.id.textViewTitle);
        TextView courseDescriptionTextView = (TextView) theView.findViewById(R.id.textViewDescription);
        ImageView topCardImageView = (ImageView) theView.findViewById(R.id.imageViewTopIcon);
        ImageView bottomCardImageView = (ImageView) theView.findViewById(R.id.imageViewBottomIcon);

        courseTitleTextView.setText(courseTitle);
        courseDescriptionTextView.setText(courseDescription);
        topCardImageView.setImageResource(topCardResourceId);
        bottomCardImageView.setImageResource(courseTypeLogoResourceId);

    }


}
