package com.ivangelarry.coursable.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ivangelarry.coursable.R;
import com.ivangelarry.coursable.ui.adapter.CourseListAdapter;

public class CourseDetailActivity extends AppCompatActivity {

    private final Context context = this;
    private String courseCode;
    private String courseTitle;
    private String courseInstructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent intent = getIntent();
        TextView courseCodeTextView = findViewById(R.id.tv_course_detail_code);
        TextView courseTitleTextView = findViewById(R.id.tv_course_detail_title);
        TextView courseInstructorTextView = findViewById(R.id.tv_course_instructor);

        courseCode = intent.getStringExtra(CourseListAdapter.COURSE_CODE_EXTRA_MESSAGE);
        courseTitle = intent.getStringExtra(CourseListAdapter.COURSE_TITLE_EXTRA_MESSAGE);
        courseInstructor = intent.getStringExtra(CourseListAdapter.COURSE_INSTRUCTOR_EXTRA_MESSAGE);

        courseCodeTextView.setText(courseCode);
        courseTitleTextView.setText(courseTitle);
        courseInstructorTextView.setText(courseInstructor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_course_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_course:
                editCourse();
                return true;
            case R.id.delete_course:
                deleteCourse();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deleteCourse() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.delete_course_warning_title) // TODO Figure out why this title is not showing up
                .setTitle(R.string.delete_course_warning_message)
                .setPositiveButton(R.string.delete_course, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Delete course from database
                        ((AppCompatActivity)context).finish();
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    private void editCourse() {
        Intent intent = new Intent(context, EditCourseActivity.class);
        intent.putExtra(CourseListAdapter.COURSE_CODE_EXTRA_MESSAGE, courseCode);
        intent.putExtra(CourseListAdapter.COURSE_TITLE_EXTRA_MESSAGE, courseTitle);
        intent.putExtra(CourseListAdapter.COURSE_INSTRUCTOR_EXTRA_MESSAGE, courseInstructor);
        context.startActivity(intent);
    }
}
