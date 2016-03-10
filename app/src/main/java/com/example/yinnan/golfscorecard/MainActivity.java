package com.example.yinnan.golfscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Hole[] mHoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHoles = new Hole[18];
        for (int i=0;i<18;i++) {
            mHoles[i].setNumber(i+1);
            mHoles[i].setScore(0);
        }


    }
}
