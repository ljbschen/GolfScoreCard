package com.example.yinnan.golfscorecard;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String PREF_FILE = "com.example.yinnan.golfscorecard.preferences";
    private Hole[] mHoles;
    private RecyclerView mRecyclerView;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);

        mHoles = new Hole[18];
        for (int i=0;i<18;i++) {
            mHoles[i] = new Hole();
            mHoles[i].setNumber(i+1);
            mHoles[i].setScore(0);
        }

        mRecyclerView.setAdapter(new HoleAdapter(this, mHoles));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //store data
        mSharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        //mEditor
    }
}
