package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Activity.RESULT_OK==resultCode){
            String result=data.getStringExtra("type");
            if (null!=result){
                Log.e("result:",result);
            }
        }
    }
}
