package com.ivangelarry.coursable.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ivangelarry.coursable.R;
import com.ivangelarry.coursable.model.Course;
import com.ivangelarry.coursable.ui.activity.CourseDetailActivity;


import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseListViewHolder> {

    private String TAG = CourseListAdapter.class.getSimpleName();

    private List<Course> courses;

    public static final String COURSE_CODE_EXTRA_MESSAGE = "COURSE_CODE";
    public static final String COURSE_TITLE_EXTRA_MESSAGE = "COURSE_TITLE";
    public static final String COURSE_INSTRUCTOR_EXTRA_MESSAGE = "COURSE_INSTRUCTOR";

    public CourseListAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public CourseListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course_list, parent, false);
        return new CourseListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CourseListViewHolder courseListViewHolder, int i) {
        Log.i(TAG, "Course[" + courses.get(i).getCode() +
                ", " + courses.get(i).getTitle() + ", " + courses.get(i).getInstructor() + "]");
        courseListViewHolder.bind(i);

        final Course course = courses.get(i);


        courseListViewHolder.courseListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CourseDetailActivity.class);
                intent.putExtra(COURSE_CODE_EXTRA_MESSAGE, course.getCode());
                intent.putExtra(COURSE_TITLE_EXTRA_MESSAGE, course.getTitle());
                intent.putExtra(COURSE_INSTRUCTOR_EXTRA_MESSAGE, course.getInstructor());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class CourseListViewHolder extends RecyclerView.ViewHolder {

        private TextView courseCodeTextView;
        private TextView courseTitleTextView;
        private LinearLayout courseListItem;

        public CourseListViewHolder(View itemView) {
            super(itemView);

            courseCodeTextView = itemView.findViewById(R.id.tv_course_code);
            courseTitleTextView = itemView.findViewById(R.id.tv_course_title);

            courseListItem = itemView.findViewById(R.id.ll_course_list_item);
        }

        void bind(int index) {
            Course course = courses.get(index);
            courseCodeTextView.setText(course.getCode());
            courseTitleTextView.setText(course.getTitle());
        }
    }
}
