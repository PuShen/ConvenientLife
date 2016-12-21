package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lifeofnothing.wxp.convenientlife.R;


public class MainActivity extends Activity {
    private View mTvNews;
    private View mTvWechat;
    private View mTvWeather;
    private View mTvJoke;
    private View mTvBusLine;
    private View mTvExplainDream;
    private View mTvPerpetualCalendar;
    private View mTvQQNumber;
    private View mLlayMain;
    private int[] mBackgroungArrays={R.drawable.bg2,R.drawable.bg3,R.drawable.bg5,R.drawable.bg6,R.drawable.bg7,R.drawable.bg8,R.drawable.bg9};

    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.LlayMainNews:
                    Intent intent1=new Intent(MainActivity.this,NewsActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.LlayMainWechat:
                    Intent intent2 = new Intent(MainActivity.this,WechatActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.LlayMainWeather:
                    Intent intent3 = new Intent(MainActivity.this,WeatherActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.LlayMainJoke:
                    Intent intent4=new Intent(MainActivity.this,JokeActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.LlayMainBus:
                    Intent intent5=new Intent(MainActivity.this, BusLineActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.LlayMainDream:
                    Intent intent6=new Intent(MainActivity.this, ExplainDreamActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.LlayMainCalendar:
                    Intent intent7=new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intent7);
                    break;
                case R.id.LlayMainQQ:
                    Intent intent8=new Intent(MainActivity.this,QQNumberActivity.class);
                    startActivity(intent8);
            }
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
        mTvNews= findViewById(R.id.LlayMainNews);
        mTvWechat = findViewById(R.id.LlayMainWechat);
        mTvWeather = findViewById(R.id.LlayMainWeather);
        mTvJoke=  findViewById(R.id.LlayMainJoke);
        mTvBusLine= findViewById(R.id.LlayMainBus);
        mTvExplainDream= findViewById(R.id.LlayMainDream);
        mTvPerpetualCalendar= findViewById(R.id.LlayMainCalendar);
        mTvQQNumber=findViewById(R.id.LlayMainQQ);
        mLlayMain=findViewById(R.id.LlayMainMain);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTvNews.setOnClickListener(listener);
        mTvWechat.setOnClickListener(listener);
        mTvWeather.setOnClickListener(listener);
        mTvJoke.setOnClickListener(listener);
        mTvBusLine.setOnClickListener(listener);
        mTvExplainDream.setOnClickListener(listener);
        mTvPerpetualCalendar.setOnClickListener(listener);
        mTvQQNumber.setOnClickListener(listener);
        mLlayMain.setBackgroundResource(mBackgroungArrays[(int) (Math.random()*mBackgroungArrays.length)]);
    }

}
