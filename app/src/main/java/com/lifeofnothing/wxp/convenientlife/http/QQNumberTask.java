package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;

import com.lifeofnothing.wxp.convenientlife.entity.QQNumber;
import com.lifeofnothing.wxp.convenientlife.parser.QQNumberParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hang on 2016/11/28.
 */

public class QQNumberTask{

    private final String mUrl = "http://japi.juhe.cn/qqevaluate/qq?";
    private String mParam;      //qq号码
    private final String mParam1 = "key=63c4f5aeed6f5d25132135ea228807ca&qq=";
    private String url;
    private Handler mHandler;

    public QQNumberTask(String qq,Handler handler){
        this.mParam = qq;
        this.mHandler = handler;
    }



    private List<QQNumber> QQList = new ArrayList<>();
    public void QQNum_run(){
        url = mUrl+mParam1+mParam;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Message msg = new Message();
                QQNumberParser qq = new QQNumberParser(response.toString());
                QQNumber q1 = qq.parse();
                msg.obj = q1;
                msg.what = 0;
                mHandler.sendMessage(msg);
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                mHandler.sendEmptyMessage(1);
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
