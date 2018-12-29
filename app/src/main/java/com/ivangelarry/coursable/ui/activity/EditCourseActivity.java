package com.ivangelarry.coursable.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.ivangelarry.coursable.R;
import com.ivangelarry.coursable.ui.adapter.CourseListAdapter;

public class EditCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);

        Intent intent = getIntent();
        String courseCode = intent.getStringExtra(CourseListAdapter.COURSE_CODE_EXTRA_MESSAGE);
        String courseTitle = intent.getStringExtra(CourseListAdapter.COURSE_TITLE_EXTRA_MESSAGE);
        String courseInstructor = intent.getStringExtra(CourseListAdapter.COURSE_INSTRUCTOR_EXTRA_MESSAGE);

        EditText courseCodeEditText = findViewById(R.id.et_course_code);
        courseCodeEditText.setText(courseCode);

        EditText courseTitleEditText = findViewById(R.id.et_course_title);
        courseTitleEditText.setText(courseTitle);

        EditText courseInstructorEditText = findViewById(R.id.et_course_instructor);
        courseInstructorEditText.setText(courseInstructor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_course_cancel:
                finish();
                return true;
            case R.id.edit_course_save:
                // TODO: (3) save changes
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
