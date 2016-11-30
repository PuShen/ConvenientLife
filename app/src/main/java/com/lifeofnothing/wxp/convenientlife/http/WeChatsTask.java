package com.lifeofnothing.wxp.convenientlife.http;

import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.WeChat;
import com.lifeofnothing.wxp.convenientlife.prasor.WeChatsParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 我需要一枚好辅助丶 on 2016/11/29.
 */

public class WeChatsTask {
    private String mUrl = "http://v.juhe.cn/weixin/query?key=a71d60ef37a1e31bad971987ad97565c";
    private String mSource;

    //构造方法
    public WeChatsTask() {
    }

    public String WeChats_run(){
        //进行网络请求
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(mUrl,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //测试请求是否成功
//                try {
//                    String mStr = response.getString("reason");
//                    if (mStr.equals("success")){
//                        Log.e("测试","请求成功");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                mSource = response.toString();
                super.onSuccess(statusCode, headers, response);
            }
        });
        return mSource;
    }

}
