package com.gralliams.servepro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class LauncherActivity extends Activity {

    private static  int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(getApplicationContext(), OnboardingActivity.class));

        }else{

            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        finish();


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
    }
}