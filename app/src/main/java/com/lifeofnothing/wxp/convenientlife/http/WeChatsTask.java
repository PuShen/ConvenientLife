package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.parser.WeChatsParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

/**
 * Created by 我需要一枚好辅助丶 on 2016/11/29.
 */

public class WeChatsTask {
    private final String mUrl = "http://v.juhe.cn/weixin/query?pno=";
    private final String param="&ps=&dtype=&key=d951919b8102f48eddd8f51b6cae6244";
    private Handler mHandler;


    //构造方法


    public WeChatsTask(Handler mHandler) {
        this.mHandler = mHandler;
    }

    public void WeChats_run(){
        //进行网络请求
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(mUrl+(int)(Math.random()*25)+param,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                //测试请求是否成功
                Log.e("result",response.toString());
                WeChatsParser parser=new WeChatsParser(response.toString());
                Log.e("img",parser.parse().get(0).getFirstImg());
                Message message = new Message();
                message.what=0;
                message.obj = parser.parse();
                mHandler.sendMessage(message);
            }
        });
    }

}
