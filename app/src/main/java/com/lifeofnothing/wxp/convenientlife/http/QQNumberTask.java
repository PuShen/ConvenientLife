package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.QQNumber;
import com.lifeofnothing.wxp.convenientlife.prasor.QQNumberParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hang on 2016/11/28.
 */

public class QQNumberTask{

    private final String mUrl = "http://japi.juhe.cn/qqevaluate/qq?";
    private String mParam;
    private final String mParam1 = "key=63c4f5aeed6f5d25132135ea228807ca&qq=";

    public QQNumberTask(String qq){
        this.mParam = qq;
    }

    private String url = mUrl+mParam1+mParam;

    private List<QQNumber> QQList = new ArrayList<>();
    public void QQNum_run(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                String str = QQList.toString();
                QQNumberParser qp = new QQNumberParser(str);
                super.onSuccess(statusCode, headers, response);
            }
        });
    }
}
