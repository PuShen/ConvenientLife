package com.lifeofnothing.wxp.convenientlife.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.lifeofnothing.wxp.convenientlife.R;

public class MainActivity extends AppCompatActivity {
    private ListView mLvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLvList= (ListView) findViewById(R.id.LvMainList);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
