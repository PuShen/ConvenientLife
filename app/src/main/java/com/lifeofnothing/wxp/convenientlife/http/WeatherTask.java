package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.Weather;
import com.lifeofnothing.wxp.convenientlife.parser.WeatherParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by 我需要一枚好辅助丶 on 2016/11/28.
 */

public class WeatherTask {
    private String mParam;        //用户需要输入的城市名称
    private String mCityName;
    private String mUrl;
    private Handler mHandler;

    public WeatherTask(String mParam,Handler mHandler) throws UnsupportedEncodingException {
        this.mParam = mParam;
        this.mHandler=mHandler;
    }


    public void Weather_run() throws UnsupportedEncodingException {
        //传的参数中城市名称需要utf-8 urlencode
        mCityName = URLEncoder.encode(mParam,"UTF-8");
        mUrl = "http://op.juhe.cn/onebox/weather/query?cityname="+mCityName+"&key=440d0e0e41e24f869d09ed9696856c45";
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(mUrl,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    String str = response.getString("reason");
                    String mSource = response.toString();
                    WeatherParser parser=new WeatherParser(mSource);
                    List<Weather> list=parser.parse();
                    if (null!=list){
                        Log.e("Weather",list.toString());
                        Message message=new Message();
                        message.what=0;
                        message.obj=list;
                        mHandler.sendMessage(message);
                    }else {
                        mHandler.sendEmptyMessage(1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                mHandler.sendEmptyMessage(2);
            }
        });
    }
}
