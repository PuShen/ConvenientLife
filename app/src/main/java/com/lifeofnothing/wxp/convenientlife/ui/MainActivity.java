package com.lifeofnothing.wxp.convenientlife.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.http.NbaTask;
import com.lifeofnothing.wxp.convenientlife.http.WeChatsTask;
import com.lifeofnothing.wxp.convenientlife.http.WeatherTask;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {
    private TextView mTvNews;
    private TextView mTvWechat;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.TvMainNews:
                    Intent intent=new Intent(MainActivity.this,NewsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.TvMainWechat:
                    Intent intent1 = new Intent(MainActivity.this,WechatActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        测试代码
//        new NbaTask().Nba_run();
//        try {
//            new WeatherTask("北京").Weather_run();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        WeChatsTask a = new WeChatsTask();
//        a.WeChats_run();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mTvNews= (TextView) findViewById(R.id.TvMainNews);
        mTvWechat =(TextView)findViewById(R.id.TvMainWechat);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTvNews.setOnClickListener(listener);
        mTvWechat.setOnClickListener(listener);
    }

}
