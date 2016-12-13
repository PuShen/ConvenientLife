package com.lifeofnothing.wxp.convenientlife.http;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.prasor.ExplainDreamParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by Administrator on 2016/12/13.
 */

public class ExplainDreamTask{
    private String mUrl;
    private String mParm;//梦境关键字
    private String keyword;
    private Handler mHander;

    public ExplainDreamTask(String mParm, Handler mHander)throws UnsupportedEncodingException{
        this.mParm=mParm;
        this.mHander=mHander;
    }


     public void run()throws UnsupportedEncodingException{
         keyword=URLEncoder.encode(mParm,"UTF-8");
         mUrl="http://v.juhe.cn/dream/query?q="+keyword+"&cid=&full=1&key=21ab81b5edf982ac86e9b82f98ad923c";
         AsyncHttpClient client=new AsyncHttpClient();
         client.get(mUrl,new JsonHttpResponseHandler(){
             @Override
             public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                 super.onSuccess(statusCode, headers, response);
                 Log.e("ss",response.toString());

                 Message message=new Message();
                 message.obj=response;
                 mHander.sendMessage(message);

             }

             @Override
             public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                 super.onFailure(statusCode, headers, throwable, errorResponse);
                 mHander.sendEmptyMessage(1);
             }
         });
     }


}
