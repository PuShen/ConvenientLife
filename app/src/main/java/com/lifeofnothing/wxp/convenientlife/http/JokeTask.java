package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;

import com.lifeofnothing.wxp.convenientlife.prasor.JokeParser;
import com.lifeofnothing.wxp.convenientlife.prasor.TodayInHisoryParser;
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

/**
 * Created by hang on 2016/11/29.
 */

public class JokeTask implements Runnable{

    private String mUrl;
    private Handler mHandler;
    private Button mBtn;

    public JokeTask(Handler mHandler, String mUrl) {
        this.mHandler = mHandler;
        this.mUrl = mUrl;
    }

    public JokeTask(Handler mHandler, Button mBtn,String mUrl) {
        this.mHandler = mHandler;
        this.mBtn = mBtn;
        this.mUrl = mUrl;
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(mUrl);
            connection = (HttpURLConnection)url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer("");
            String line = null;
            while (null != (line = reader.readLine())){
                buffer.append(line);
            }
            Message message = new Message();
            message.what = 0;
            message.obj = JokeParser.getGson(buffer);
            mHandler.sendMessage(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
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
