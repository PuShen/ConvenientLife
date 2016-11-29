package com.lifeofnothing.wxp.convenientlife.http;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hang on 2016/11/29.
 */

public class JokeTask {

    private String mUrl = "http://japi.juhe.cn/joke/content/list.from?key=您申请的KEY&sort=";
    private String mTime;   //时间戳
    private String mSort;   //asc指定时间之后和desc指定时间之前

    public JokeTask(String sort,String time){
        this.mSort = sort;
        this.mTime = time;
    }

    private String url = mUrl+mSort+"&time="+mTime;

    public void Joke_run(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                String str = response.toString();
                try {
                    String s = response.getString("error_code");
                    Log.e("error_code",response.toString());
                    if (s.equals(0)){
                        Log.e("succeed","1");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                super.onSuccess(statusCode, headers, response);
            }
        });
    }

}
