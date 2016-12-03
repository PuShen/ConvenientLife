package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by dell on 2016/12/1.
 */

public class WeatherActivity extends Activity {
    private SwipeRefreshLayout mSrlRefresh;
    private ImageView mIvBack;
    private ImageView mIvAdd;
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
        mSrlRefresh.setColorSchemeResources(android.R.color.holo_green_light,android.R.color.holo_orange_light,android.R.color.holo_blue_bright,android.R.color.holo_red_light);
        mSrlRefresh.setProgressBackgroundColorSchemeResource(R.color.colorLightBlue);
    }
}
