package com.lifeofnothing.wxp.convenientlife.http;

import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.prasor.BusLineParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hang on 2016/11/28.
 */

public class BusLineTask {


    private String mUrl = "http://op.juhe.cn/189/bus/busline?";
    private String mParam1 = "key=580f5ec11f82f6f5c19fb9321c0ca157&city=";
    private String mParam2;     //城市代码或城市名称
    private String mParam3;     //公交车号
    private String url;
    public BusLineTask(String city,String bus){
        this.mParam2 = city;
        this.mParam3 = bus;
    }


    private List<BusLine> Buslist = new ArrayList<>();
    public void Bus_run(){
        url= mUrl+mParam1+mParam2+"&%20bus="+mParam3;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                String str = Buslist.toString();
                BusLineParser bp = new BusLineParser(str);

                try {
                    String s = response.getString("reason");
                    Log.e("reason",response.toString());
                    if (s.equals("success")){
                        Log.e("reason","1");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                super.onSuccess(statusCode, headers, response);
            }
        });
    }

}
