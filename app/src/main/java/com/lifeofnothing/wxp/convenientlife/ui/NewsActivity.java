package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.NewsAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.News;
import com.lifeofnothing.wxp.convenientlife.http.NewsTask;

import java.util.List;

/**
 * Created by a on 2016/11/25.
 */

public class NewsActivity extends Activity {
    private ListView mLvList;
    private TextView mTvSearch;
    private ImageView mIvBack;
    private String mType;//新闻的类型

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
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    final List<News> list=(List<News>) msg.obj;
                    NewsAdapter adapter=new NewsAdapter(NewsActivity.this,list);
                    mLvList.setAdapter(adapter);
                    mLvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(NewsActivity.this,NewscontentActivity.class);
                            intent.putExtra("url",list.get(position).getmUrl());
                            startActivity(intent);
                        }
                    });
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType="";
        setContentView(R.layout.activity_news);

        //测试代码
        //new NbaTask().Nba_run();

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
        new Thread(new NewsTask(mType,handler)).start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Activity.RESULT_OK==resultCode){
            String result=data.getStringExtra("type");
            if (null!=result){
                mType=data.getStringExtra("type");
            }
        }
    }
}
