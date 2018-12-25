package com.ivangelarry.coursable.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ivangelarry.coursable.R;
import com.ivangelarry.coursable.model.Course;

import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseListViewHolder> {

    private String TAG = CourseListAdapter.class.getSimpleName();

    private List<Course> courses;

    public CourseListAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public CourseListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_list_item, parent, false);
        return new CourseListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseListViewHolder courseListViewHolder, int i) {
        Log.i(TAG, "Course[" + courses.get(i).getCode() +
                ", " + courses.get(i).getTitle() + ", " + courses.get(i).getInstructor() + "]");
        courseListViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class CourseListViewHolder extends RecyclerView.ViewHolder {

        private TextView courseCodeTextView;
        private TextView courseTitleTextView;

        public CourseListViewHolder(View itemView) {
            super(itemView);

            courseCodeTextView = itemView.findViewById(R.id.tv_course_code);
            courseTitleTextView = itemView.findViewById(R.id.tv_course_title);
        }

        void bind(int index) {
            Course course = courses.get(index);
            courseCodeTextView.setText(course.getCode());
            courseTitleTextView.setText(course.getTitle());
        }
    }
}
