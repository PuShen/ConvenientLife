package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by a on 2016/11/25.
 */

public class NewsActivity extends Activity {
    private ListView mLvList;
    private TextView mTvSearch;
    private ImageView mIvBack;

    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvNewsBack:
                    finish();
                    break;
                case R.id.TvNewsSearch:
                    Intent intent=new Intent(NewsActivity.this,NewstypeActivity.class);
                    startActivityForResult(intent,0);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //测试代码
        //new Nba().Nba_run();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mLvList= (ListView) findViewById(R.id.LvNewsList);
        mTvSearch= (TextView) findViewById(R.id.TvNewsSearch);
        mIvBack= (ImageView) findViewById(R.id.IvNewsBack);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTvSearch.setOnClickListener(listener);
        mIvBack.setOnClickListener(listener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Activity.RESULT_OK==resultCode){
            String result=data.getStringExtra("type");
            if (null!=result){

            }
        }
    }
}
