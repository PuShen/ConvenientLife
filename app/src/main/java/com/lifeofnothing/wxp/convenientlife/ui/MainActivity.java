package com.lifeofnothing.wxp.convenientlife.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.http.Nba;

public class MainActivity extends AppCompatActivity {
    private ListView mLvList;
    private TextView mTvSearch;

    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,NewstypeActivity.class);
            startActivityForResult(intent,0);
        }
    };
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
        mTvSearch= (TextView) findViewById(R.id.TvItemnewsSearch);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTvSearch.setOnClickListener(listener);
    }
}
