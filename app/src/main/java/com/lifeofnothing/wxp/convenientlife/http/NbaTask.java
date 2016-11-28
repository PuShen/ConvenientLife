package com.lifeofnothing.wxp.convenientlife.http;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 我需要一枚好辅助丶 on 2016/11/24.
 */

public class NbaTask {

    public NbaTask() {
    }

    private String mUrl = "http://op.juhe.cn/onebox/basketball/nba?key=6647ff1ad4f8b21cb866c21623874a24";

    private List<com.lifeofnothing.wxp.convenientlife.entity.Nba> nbaList = new ArrayList<>();
    public void Nba_run(){
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(mUrl,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    String str = response.getString("reason");
                    Log.e("结果",response.toString());
                    if(str.equals("查询成功")){
                        Log.e("测试","请求成功");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                super.onSuccess(statusCode, headers, response);
            }
        });
    }
}
