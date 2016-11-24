package com.lifeofnothing.wxp.convenientlife.http;

import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.ui.MainActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hang on 2016/11/24.
 */
public class News {
    private String url = "http://v.juhe.cn/toutiao/index?type=top&key=APPKEY";
    public void News_run(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                List<com.lifeofnothing.wxp.convenientlife.entity.News> newsList = new ArrayList<com.lifeofnothing.wxp.convenientlife.entity.News>();
                try {
                    JSONObject obj = response.getJSONObject("result");
                    Log.e("1",obj.getString("stat"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
