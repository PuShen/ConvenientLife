package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.Weather;
import com.lifeofnothing.wxp.convenientlife.http.WeatherTask;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by dell on 2016/12/1.
 */

public class WeatherActivity extends Activity {
    private List<Weather> mList;
    private SwipeRefreshLayout mSrlRefresh;
    private ImageView mIvBack;
    private ImageView mIvAdd;
    private TextView mTvTemperature;
    private TextView mTvWeather;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvWeatherBack:
                    finish();
                    break;
            }
        }
    };
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    mList=(List<Weather>) msg.obj;
                    init();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSrlRefresh= (SwipeRefreshLayout) findViewById(R.id.SrlWeatherRefresh);
        mIvBack= (ImageView) findViewById(R.id.IvWeatherBack);
        mIvAdd= (ImageView) findViewById(R.id.IvWeatherAdd);
        mTvTemperature= (TextView) findViewById(R.id.TvWeatherTemperature);
        mTvWeather= (TextView) findViewById(R.id.TvWeatherWeather);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
        mSrlRefresh.setColorSchemeResources(android.R.color.holo_green_light,android.R.color.holo_orange_light,android.R.color.holo_blue_bright,android.R.color.holo_red_light);
        mSrlRefresh.setProgressBackgroundColorSchemeResource(R.color.colorLightBlue);
        try {
            WeatherTask task=new WeatherTask("石家庄",mHandler);
            task.Weather_run();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void init(){
        mTvTemperature.setText(mList.get(0).getTemperature());
        mTvWeather.setText(mList.get(0).getInfo());
    }
}
