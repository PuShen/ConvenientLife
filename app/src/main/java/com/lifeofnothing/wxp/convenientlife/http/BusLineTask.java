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
    private String mParam2;
    private String mParam3;

    public BusLineTask(String city,String bus){
        this.mParam2 = city;
        this.mParam3 = bus;
    }

    private String url = mUrl+mParam1+mParam2+"bus="+mParam3;
    private List<BusLine> Buslist = new ArrayList<>();
    public void Bus_run(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                String str = Buslist.toString();
                BusLineParser bp = new BusLineParser(str);
                super.onSuccess(statusCode, headers, response);
            }
        });
    }

}
