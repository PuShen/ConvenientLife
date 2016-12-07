package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView mTvCity;
    private ImageView mIvAdd;
    private TextView mTvTemperature;
    private ImageView mIvImage;
    private TextView mTvWeather;
    private TextView mTvWeek1;
    private TextView mTvWeek2;
    private TextView mTvWeek3;
    private TextView mTvWeek4;
    private ImageView mIvImage1;
    private ImageView mIvImage2;
    private ImageView mIvImage3;
    private ImageView mIvImage4;
    private TextView mTvTemperature1;
    private TextView mTvTemperature2;
    private TextView mTvTemperature3;
    private TextView mTvTemperature4;
    private TextView mTvWeather1;
    private TextView mTvWeather2;
    private TextView mTvWeather3;
    private TextView mTvWeather4;
    private ImageView mIvImagebig;
    private TextView mTvWeather0;
    private TextView mTvTemperature0;
    private TextView mTvHumidity;
    private TextView mTvDirect;
    private TextView mTvPower;
    private TextView mTvQuality;
    private TextView mTvPm25;
    private TextView mTvPm10;
    private TextView mTvDes;
    private TextView mTvCloth;
    private TextView mTvClothdes;
    private TextView mTvCold;
    private TextView mTvColddes;
    private TextView mTvAirconditioner;
    private TextView mTvAirconditionerdes;
    private TextView mTvWashcars;
    private TextView mTvWashcarsdes;
    private TextView mTvSports;
    private TextView mTvSportsdes;
    private TextView mTvUltravioletrays;
    private TextView mTvUltravioletraysdes;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvWeatherBack:
                    finish();
                    break;
                case R.id.IvWeatherAdd:
                    Intent intent=new Intent(WeatherActivity.this,WeathercityActivity.class);
                    startActivity(intent);
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
                case 2:
                    Toast.makeText(WeatherActivity.this,R.string.tip_error_net,Toast.LENGTH_SHORT).show();
                    break;
            }
            mSrlRefresh.setRefreshing(false);
        }
    };
    private SwipeRefreshLayout.OnRefreshListener refreshListener=new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            try {
                WeatherTask task=new WeatherTask(mTvCity.getText().toString(),mHandler);
                task.Weather_run();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
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
        mTvCity= (TextView) findViewById(R.id.TvWeatherCity);
        mIvAdd= (ImageView) findViewById(R.id.IvWeatherAdd);
        mTvTemperature= (TextView) findViewById(R.id.TvWeatherTemperature);
        mIvImage= (ImageView) findViewById(R.id.IvWeatherImage);
        mTvWeather= (TextView) findViewById(R.id.TvWeatherWeather);
        mTvWeek1= (TextView) findViewById(R.id.TvWeatherWeek1);
        mTvWeek2= (TextView) findViewById(R.id.TvWeatherWeek2);
        mTvWeek3= (TextView) findViewById(R.id.TvWeatherWeek3);
        mTvWeek4= (TextView) findViewById(R.id.TvWeatherWeek4);
        mIvImage1= (ImageView) findViewById(R.id.IvWeatherImage1);
        mIvImage2= (ImageView) findViewById(R.id.IvWeatherImage2);
        mIvImage3= (ImageView) findViewById(R.id.IvWeatherImage3);
        mIvImage4= (ImageView) findViewById(R.id.IvWeatherImage4);
        mTvTemperature1= (TextView) findViewById(R.id.TvWeatherTemperature1);
        mTvTemperature2= (TextView) findViewById(R.id.TvWeatherTemperature2);
        mTvTemperature3= (TextView) findViewById(R.id.TvWeatherTemperature3);
        mTvTemperature4= (TextView) findViewById(R.id.TvWeatherTemperature4);
        mTvWeather1= (TextView) findViewById(R.id.TvWeatherWeather1);
        mTvWeather2= (TextView) findViewById(R.id.TvWeatherWeather2);
        mTvWeather3= (TextView) findViewById(R.id.TvWeatherWeather3);
        mTvWeather4= (TextView) findViewById(R.id.TvWeatherWeather4);
        mIvImagebig= (ImageView) findViewById(R.id.IvWeatherImagebig);
        mTvWeather0= (TextView) findViewById(R.id.TvWeatherWeather0);
        mTvTemperature0= (TextView) findViewById(R.id.TvWeatherTemperature0);
        mTvHumidity= (TextView) findViewById(R.id.TvWeatherHumidity);
        mTvDirect= (TextView) findViewById(R.id.TvWeatherDirect);
        mTvPower= (TextView) findViewById(R.id.TvWeatherPower);
        mTvQuality= (TextView) findViewById(R.id.TvWeatherQuality);
        mTvPm25= (TextView) findViewById(R.id.TvWeatherPm25);
        mTvPm10= (TextView) findViewById(R.id.TvWeatherPm10);
        mTvDes= (TextView) findViewById(R.id.TvWeatherDes);
        mTvCloth= (TextView) findViewById(R.id.TvWeatherCloth);
        mTvClothdes= (TextView) findViewById(R.id.TvWeatherClothdes);
        mTvCold= (TextView) findViewById(R.id.TvWeatherCold);
        mTvColddes= (TextView) findViewById(R.id.TvWeatherColddes);
        mTvAirconditioner= (TextView) findViewById(R.id.TvWeatherAirconditioner);
        mTvAirconditionerdes= (TextView) findViewById(R.id.TvWeatherAirconditionerdes);
        mTvWashcars= (TextView) findViewById(R.id.TvWeatherWashcars);
        mTvWashcarsdes= (TextView) findViewById(R.id.TvWeatherWashcarsdes);
        mTvSports= (TextView) findViewById(R.id.TvWeatherSports);
        mTvSportsdes= (TextView) findViewById(R.id.TvWeatherSportsdes);
        mTvUltravioletrays= (TextView) findViewById(R.id.TvWeatherUltravioletrays);
        mTvUltravioletraysdes= (TextView) findViewById(R.id.TvWeatherUltravioletraysdes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
        SharedPreferences sharedPreferences=getSharedPreferences("ConvenientLife", Context.MODE_PRIVATE);
        String city=sharedPreferences.getString("city","北京");
        mTvCity.setText(city);
        mIvAdd.setOnClickListener(listener);
        mSrlRefresh.setColorSchemeResources(android.R.color.holo_green_light,android.R.color.holo_orange_light,android.R.color.holo_blue_bright,android.R.color.holo_red_light);
        mSrlRefresh.setProgressBackgroundColorSchemeResource(R.color.colorLightBlue);
        mSrlRefresh.setOnRefreshListener(refreshListener);
        try {
            WeatherTask task=new WeatherTask(mTvCity.getText().toString(),mHandler);
            task.Weather_run();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void init(){
        mTvTemperature.setText(mList.get(0).getTemperature());
        mIvImage.setImageResource(mList.get(0).getImg());
        mTvWeather.setText(mList.get(0).getInfo());
        mTvWeek1.setText(mList.get(1).getWeek());
        mTvWeek2.setText(mList.get(2).getWeek());
        mTvWeek3.setText(mList.get(3).getWeek());
        mTvWeek4.setText(mList.get(4).getWeek());
        mIvImage1.setImageResource(mList.get(1).getImg());
        mIvImage2.setImageResource(mList.get(2).getImg());
        mIvImage3.setImageResource(mList.get(3).getImg());
        mIvImage4.setImageResource(mList.get(4).getImg());
        mTvTemperature1.setText(mList.get(1).getTemperature());
        mTvTemperature2.setText(mList.get(2).getTemperature());
        mTvTemperature3.setText(mList.get(3).getTemperature());
        mTvTemperature4.setText(mList.get(4).getTemperature());
        mTvWeather1.setText(mList.get(1).getInfo());
        mTvWeather2.setText(mList.get(2).getInfo());
        mTvWeather3.setText(mList.get(3).getInfo());
        mTvWeather4.setText(mList.get(4).getInfo());
        mIvImagebig.setImageResource(mList.get(0).getImg());
        mTvWeather0.setText(mList.get(0).getInfo());
        mTvTemperature0.setText(mList.get(0).getTemperature());
        mTvHumidity.setText(mList.get(0).getHumidity());
        mTvDirect.setText(mList.get(0).getDirect());
        mTvPower.setText(mList.get(0).getPower());
        mTvQuality.setText(mList.get(0).getQuality());
        mTvPm25.setText(mList.get(0).getPm25());
        mTvPm10.setText(mList.get(0).getPm10());
        mTvDes.setText(mList.get(0).getDes());
        mTvCloth.setText(mList.get(0).getChuanyi());
        mTvClothdes.setText(mList.get(0).getChuanyides());
        mTvCold.setText(mList.get(0).getGanmao());
        mTvColddes.setText(mList.get(0).getGanmaodes());
        mTvAirconditioner.setText(mList.get(0).getKongtiao());
        mTvAirconditionerdes.setText(mList.get(0).getKongtiaodes());
        mTvWashcars.setText(mList.get(0).getXiche());
        mTvWashcarsdes.setText(mList.get(0).getXichedes());
        mTvSports.setText(mList.get(0).getYundong());
        mTvSportsdes.setText(mList.get(0).getYundongdes());
        mTvUltravioletrays.setText(mList.get(0).getZiwaixian());
        mTvUltravioletraysdes.setText(mList.get(0).getZiwaixiandes());
    }
}
