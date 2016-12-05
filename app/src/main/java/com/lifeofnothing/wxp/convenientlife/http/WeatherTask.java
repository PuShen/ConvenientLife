package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.prasor.WeatherParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

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
                    Log.e("Weather",parser.parse().toString());
                    Log.e("resultCode",String.valueOf(statusCode));
                    Message message=new Message();
                    message.what=0;
                    message.obj=parser.parse();
                    mHandler.sendMessage(message);
//                    JSONObject a = response.getJSONObject("result");
//                    JSONObject b = a.getJSONObject("data");
//                    JSONObject c = b.getJSONObject("realtime");
//                    String name = c.getString("city_name");
                    if(str.equals("successed!")){
                        Log.e("测试","请求成功");
//                        Log.e("城市",name);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                super.onSuccess(statusCode, headers, response);
            }
        });
    }
}
