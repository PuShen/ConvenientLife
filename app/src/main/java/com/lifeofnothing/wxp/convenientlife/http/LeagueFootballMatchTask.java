package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.prasor.leagueFootballMacthParser;
import com.lifeofnothing.wxp.convenientlife.entity.LeagueFootballMatch;
import com.loopj.android.http.AsyncHttpClient;
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
 * Created by hang on 2016/11/30.
 */

public class LeagueFootballMatchTask implements Runnable{
    private String mUrl = "http://op.juhe.cn/onebox/football/league?key=054f6720b0fb04e65f1afd424aa460f3&league=";
    private String mParam;      //联赛名称
    private String url;
    private Handler mHandler;

    public LeagueFootballMatchTask(String league,Handler handler){
        this.mParam = league;
        this.mHandler = handler;
    }


    @Override
    public void run() {
        url = mUrl+mParam;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL u = new URL(url);
            connection = (HttpURLConnection)u.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer("");
            String line = null;
            while (null!=(line = reader.readLine())){
                buffer.append(line);
            }
            Message message = new Message();
            message.what = 0;
            message.obj = leagueFootballMacthParser.getGson(buffer);
            mHandler.sendMessage(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!=reader){
                try {
                    reader.close();
                    connection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (null != connection){
                connection.disconnect();
            }
        }
    }
}
