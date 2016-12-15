package com.lifeofnothing.wxp.convenientlife.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.entity.PerpetualCalendar;
import com.lifeofnothing.wxp.convenientlife.http.NbaTask;
import com.lifeofnothing.wxp.convenientlife.http.WeChatsTask;
import com.lifeofnothing.wxp.convenientlife.http.WeatherTask;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {
    private TextView mTvNews;
    private TextView mTvWechat;
    private TextView mTvWeather;
    private TextView mTvJoke;
    private TextView mTvBusLine;
    private TextView mTvExplainDream;
    private TextView mTvPerpetualCalendar;
    private TextView mTvQQNumber;
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
                case R.id.TvMainWeather:
                    Intent intent2 = new Intent(MainActivity.this,WeatherActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.TvMainJoke:
                    Intent intent3=new Intent(MainActivity.this,JokeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.TvMainBusLine:
                    Intent intent4=new Intent(MainActivity.this, BusLineActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.TvMainExplainDream:
                    Intent intent5=new Intent(MainActivity.this, ExplainDreamActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.TvMainPerpetualCalendar:
                    Intent intent6=new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.TvMainQQNumber:
                    Intent intent7=new Intent(MainActivity.this,QQNumberActivity.class);
                    startActivity(intent7);
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
        mTvNews= (TextView) findViewById(R.id.TvMainNews);
        mTvWechat =(TextView)findViewById(R.id.TvMainWechat);
        mTvWeather =(TextView)findViewById(R.id.TvMainWeather);
        mTvJoke= (TextView) findViewById(R.id.TvMainJoke);
        mTvBusLine= (TextView) findViewById(R.id.TvMainBusLine);
        mTvExplainDream= (TextView) findViewById(R.id.TvMainExplainDream);
        mTvPerpetualCalendar= (TextView) findViewById(R.id.TvMainPerpetualCalendar);
        mTvQQNumber=(TextView)findViewById(R.id.TvMainQQNumber);
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

    }

}
