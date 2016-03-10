package com.example.yinnan.golfscorecard;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        mSharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mHoles = new Hole[18];
        for (int i=0;i<18;i++) {
            mHoles[i] = new Hole();
            mHoles[i].setNumber(i + 1);
            mHoles[i].setScore(mSharedPreferences.getInt(i + "", 0));
        }

        mRecyclerView.setAdapter(new HoleAdapter(this, mHoles));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //store data
        for (int i=0;i<18;i++) {
            mEditor.putInt(i+"", mHoles[i].getScore());
        }
        mEditor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear) {
            Toast.makeText(MainActivity.this, "All scores have been cleared!", Toast.LENGTH_LONG).show();
            //clean up the data
            for (int i=0;i<18;i++) {
                mHoles[i].setScore(0);
            }
            //update current UI
            for (int i=0; i<mRecyclerView.getChildCount();i++) {
                TextView textView = (TextView) mRecyclerView.getChildAt(i)
                        .findViewById(R.id.scoreLabel);
                textView.setText("0");
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
