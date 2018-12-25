package com.ivangelarry.coursable.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ivangelarry.coursable.R;
import com.ivangelarry.coursable.model.Course;
import com.ivangelarry.coursable.ui.adapter.CourseListAdapter;

import java.util.Arrays;
import java.util.List;

public class CourseListActivity extends AppCompatActivity {

    private String TAG = CourseListActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Creating Course List...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.rv_course_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CourseListAdapter(courseList());

        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private List<Course> courseList() {
        return Arrays.asList(
                new Course("CEF 307", "Computer Networks", "Oben"),
                new Course("CEF 315", "Accounting", "Musibe"),
                new Course("CEF 405", "Microcontrollers", "Tchapga"),
                new Course("EEF 409", "Feedback Systems", "Tanyi"),
                new Course("EEF 414", "Economics", "Musibe"),
                new Course("CEF 420", "Quality of Service", "Random"),
                new Course("CEF 201", "Random course", "Random lecturer"),
                new Course("CEF 501", "Another random course", "test lecturer"),
                new Course("CEF 301", "Random Course", "lectuerer"),
                new Course("CEF 400", "This is getting boring", ""),
                new Course("CEF 500", "This shit is really getting boring", ""),
                new Course("EEF 414", "Economics", "Musibe"),
                new Course("CEF 420", "Quality of Service", "Random"),
                new Course("CEF 201", "Random course", "Random lecturer"),
                new Course("CEF 501", "Another random course", "test lecturer"),
                new Course("CEF 301", "Random Course", "lectuerer"),
                new Course("CEF 400", "This is getting boring", ""),
                new Course("CEF 500", "This shit is really getting boring", "")
        );
    }
}
