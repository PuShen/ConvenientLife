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
    private TextView mTvWeek1;
    private TextView mTvWeek2;
    private TextView mTvWeek3;
    private TextView mTvWeek4;
    private TextView mTvTemperature1;
    private TextView mTvTemperature2;
    private TextView mTvTemperature3;
    private TextView mTvTemperature4;
    private TextView mTvWeather1;
    private TextView mTvWeather2;
    private TextView mTvWeather3;
    private TextView mTvWeather4;
    private TextView mTvWeather0;
    private TextView mTvTemperature0;
    private TextView mTvHumidity;
    private TextView mTvDirect;
    private TextView mTvPower;
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
        mTvWeek1= (TextView) findViewById(R.id.TvWeatherWeek1);
        mTvWeek2= (TextView) findViewById(R.id.TvWeatherWeek2);
        mTvWeek3= (TextView) findViewById(R.id.TvWeatherWeek3);
        mTvWeek4= (TextView) findViewById(R.id.TvWeatherWeek4);
        mTvTemperature1= (TextView) findViewById(R.id.TvWeatherTemperature1);
        mTvTemperature2= (TextView) findViewById(R.id.TvWeatherTemperature2);
        mTvTemperature3= (TextView) findViewById(R.id.TvWeatherTemperature3);
        mTvTemperature4= (TextView) findViewById(R.id.TvWeatherTemperature4);
        mTvWeather1= (TextView) findViewById(R.id.TvWeatherWeather1);
        mTvWeather2= (TextView) findViewById(R.id.TvWeatherWeather2);
        mTvWeather3= (TextView) findViewById(R.id.TvWeatherWeather3);
        mTvWeather4= (TextView) findViewById(R.id.TvWeatherWeather4);
        mTvWeather0= (TextView) findViewById(R.id.TvWeatherWeather0);
        mTvTemperature0= (TextView) findViewById(R.id.TvWeatherTemperature0);
        mTvHumidity= (TextView) findViewById(R.id.TvWeatherHumidity);
        mTvDirect= (TextView) findViewById(R.id.TvWeatherDirect);
        mTvPower= (TextView) findViewById(R.id.TvWeatherPower);
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
        mTvWeek1.setText(mList.get(1).getWeek());
        mTvWeek2.setText(mList.get(2).getWeek());
        mTvWeek3.setText(mList.get(3).getWeek());
        mTvWeek4.setText(mList.get(4).getWeek());
        mTvTemperature1.setText(mList.get(1).getTemperature());
        mTvTemperature2.setText(mList.get(2).getTemperature());
        mTvTemperature3.setText(mList.get(3).getTemperature());
        mTvTemperature4.setText(mList.get(4).getTemperature());
        mTvWeather1.setText(mList.get(1).getInfo());
        mTvWeather2.setText(mList.get(2).getInfo());
        mTvWeather3.setText(mList.get(3).getInfo());
        mTvWeather4.setText(mList.get(4).getInfo());
        mTvWeather0.setText(mList.get(0).getInfo());
        mTvTemperature0.setText(mList.get(0).getTemperature());
        mTvHumidity.setText(mList.get(0).getHumidity());
        mTvDirect.setText(mList.get(0).getDirect());
        mTvPower.setText(mList.get(0).getPower());
    }
}
