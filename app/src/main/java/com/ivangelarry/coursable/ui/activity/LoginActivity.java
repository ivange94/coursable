package com.ivangelarry.coursable.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.ivangelarry.coursable.R;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("LoginActivity", "Running handler code");
                rellay1.setVisibility(View.VISIBLE);
                rellay2.setVisibility(View.VISIBLE);
            }
        }, 2000);

    }

    public void login(View view) {
        // TODO Authenticate USER and show main activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
