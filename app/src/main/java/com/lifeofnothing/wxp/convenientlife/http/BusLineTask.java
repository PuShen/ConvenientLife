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
    private final int mTimeout=5000;//设置超时时长

    private String mUrl = "http://op.juhe.cn/189/bus/busline?";
    private String mParam1 = "key=580f5ec11f82f6f5c19fb9321c0ca157&city=";
    private String mParam2;     //城市代码或城市名称
    private String mParam3;     //公交车号
    private String url;
    private Handler mHandler;
    private Boolean mFlag1;

    private String mUrl2 = "http://op.juhe.cn/189/bus/station?key=580f5ec11f82f6f5c19fb9321c0ca157&city=";
    private String mParam4;     //城市代码或城市名称
    private String mParam5 = "";//站名
    private String url2;
    private List<BusLine> b;
    private Boolean mFlag2;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    if (true==mFlag1&&true==mFlag2){
                        Log.e("list",b.toString());
                        mHandler.sendEmptyMessage(0);
                    }
                    break;
            }
        }
    };

    public BusLineTask(String city,String busOrStation,Handler handler,List<BusLine> list){
        this.mParam4=this.mParam2 = city;
        this.mParam5=this.mParam3 = busOrStation;
        this.mHandler=handler;
        b=list;
        mFlag1=mFlag2=false;
    }

    private JSONArray result;
    List<BusLine> Buslist1 ;
    List<BusLine> Buslist2 ;
    public void Bus_run(){
        b.clear();
        url= mUrl+mParam1+mParam2+"&%20bus="+mParam3;
        url2 = mUrl2+mParam4+"&%20station="+mParam5;
        AsyncHttpClient client = new AsyncHttpClient();
        AsyncHttpClient client1 = new AsyncHttpClient();
        client.setTimeout(mTimeout);
        client1.setTimeout(mTimeout);
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                BusLineParser parser = new BusLineParser(response.toString());
                Buslist1 = parser.parse("线路");
                if (null!=Buslist1){
                    for (int i = 0;i<Buslist1.size();i++){
                        b.add(Buslist1.get(i));
                    }
                }
                mFlag1=true;
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                mFlag1=false;
                mHandler.sendEmptyMessage(2);
            }
        });

        client1.get(url2,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.e("list2",response.toString());
                BusLineParser parser = new BusLineParser(response.toString());
                Buslist2 = parser.parse("站点");
                Log.e("buslist2 is null",String.valueOf(null==Buslist2));
                if (null!=Buslist2){
                    for (int i = 0;i<Buslist2.size();i++){
                        b.add(Buslist2.get(i));
                    }
                }
                mFlag2=true;
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                mFlag2=false;
                mHandler.sendEmptyMessage(2);
            }
        });
    }

}
