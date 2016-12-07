package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.http.WeatherTask;

import java.io.UnsupportedEncodingException;

/**
 * Created by a on 2016/12/6.
 */

public class WeathercityActivity extends Activity {
    private EditText mEtCity;
    private TextView mTvCancle;
    private TextView mTvConfirm;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.TvWeathercityCancle:
                    finish();
                    break;
                case R.id.TvWeathercityConfirm:
                    if (0!=mEtCity.getText().length()){
                        try {
                            WeatherTask task=new WeatherTask(mEtCity.getText().toString(),mHandler);
                            task.Weather_run();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
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
                    SharedPreferences sharedPreferences=getSharedPreferences("ConvenientLife",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("city",mEtCity.getText().toString());
                    editor.commit();
                    finish();
                    break;
                case 1:
                    Toast.makeText(WeathercityActivity.this,R.string.tip_error_input,Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(WeathercityActivity.this,R.string.tip_error_net,Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weathercity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mEtCity= (EditText) findViewById(R.id.EtWeathercityCity);
        mTvCancle= (TextView) findViewById(R.id.TvWeathercityCancle);
        mTvConfirm= (TextView) findViewById(R.id.TvWeathercityConfirm);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTvCancle.setOnClickListener(listener);
        mTvConfirm.setOnClickListener(listener);
    }
}
