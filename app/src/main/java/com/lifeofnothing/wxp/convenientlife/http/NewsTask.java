package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;

import com.lifeofnothing.wxp.convenientlife.parser.NewsParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by a on 2016/11/25.
 */

public class NewsTask implements Runnable {
    private final int mTimeout=5000;
    private final String mUrl="http://v.juhe.cn/toutiao/index?type=";
    private String mParam1;
    private final String mParam2="&key=ac7e3f244befd24187ea3b16a41f394d";
    private Handler mHandler;

    public NewsTask(String mParam, Handler mHandler) {
        this.mParam1 = mParam;
        this.mHandler = mHandler;
    }

    @Override
    public void run() {
        HttpURLConnection connection=null;
        BufferedReader reader=null;
        try {
            URL url=new URL(mUrl+mParam1+mParam2);
            connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(mTimeout);
            reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer=new StringBuffer("");
            String line=null;
            while (null!=(line=reader.readLine())){
                buffer.append(line);
            }
            Message message=new Message();
            message.what=0;
            message.obj= NewsParser.getGson(buffer);
            mHandler.sendMessage(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
            mHandler.sendEmptyMessage(2);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();
        }
    }
}
