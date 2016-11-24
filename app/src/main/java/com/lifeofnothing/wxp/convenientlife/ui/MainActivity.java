package com.lifeofnothing.wxp.convenientlife.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.http.Nba;

public class MainActivity extends AppCompatActivity {
    private ListView mLvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试代码
        //new Nba().Nba_run();
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
