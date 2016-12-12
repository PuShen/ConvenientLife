package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.prasor.BusLineParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
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
    private Handler mHandler;

    private String mUrl2 = "http://op.juhe.cn/189/bus/station?key=580f5ec11f82f6f5c19fb9321c0ca157&city=";
    private String mParam4;     //城市代码或城市名称
    private String mParam5 = "";//站名
    private String url2;
    private Handler mHandler2;

    public BusLineTask(String city,String bus,Handler handler){
        this.mParam2 = city;
        this.mParam3 = bus;
        this.mHandler=handler;
    }

    public BusLineTask(String city,Handler handler ,String station){
        this.mParam4 = city;
        this.mParam5 = station;
        this.mHandler2 = handler;
    }

    private JSONArray result;
    List<BusLine> Buslist1 = new ArrayList<>();
    List<BusLine> Buslist2 = new ArrayList<>();
    List<BusLine> b = new ArrayList<>();
    public void Bus_run(){
        url= mUrl+mParam1+mParam2+"&%20bus="+mParam3;
        url2 = mUrl2+mParam4+"&%20station="+mParam5;
        AsyncHttpClient client = new AsyncHttpClient();
        AsyncHttpClient client1 = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    String s = response.getString("reason");
                    Log.e("reason",response.toString());
                    if (s.equals("success")){
                        Log.e("reason","1");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Message msg = new Message();
                msg.obj = response;
                mHandler.sendMessage(msg);
                ;

                BusLineParser b = new BusLineParser(msg.toString());
                Buslist1 = b.parse();


                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                mHandler.sendEmptyMessage(2);
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

        client1.get(url2,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    String s = response.getString("reason");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.obj = response;
                mHandler2.sendMessage(msg);


                BusLineParser b = new BusLineParser(msg.toString());
                Buslist2 = b.parse();


                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                mHandler2.sendEmptyMessage(2);
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
        for (int i = 0;i<Buslist1.size();i++){
            b.add(Buslist1.get(i));
        }
        for (int i = 0;i<Buslist2.size();i++){
            b.add(Buslist2.get(i));
        }
        Message m = new Message();
        m.obj = b;
        Handler h = new Handler();
        h.sendMessage(m);
    }

}
