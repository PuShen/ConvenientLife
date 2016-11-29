package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;

import com.lifeofnothing.wxp.convenientlife.prasor.TodayInHisoryParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hang on 2016/11/29.
 */

public class TodayInHistoryTask implements Runnable{

    private String mUrl = "http://api.juheapi.com/japi/toh?key=您申请的KEY&v=1.0";
    private String mParam;      //月份
    private String mParam1;     //日
    private String mMonth = "&month=";
    private String mDay = "&day=";
    private Handler handler;

    public TodayInHistoryTask(String month, String day, Handler mHandler){
        this.mParam = month;
        this.mParam1 = day;
        this.handler = mHandler;
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(mUrl+mMonth+mParam+mDay+mParam1);
            connection = (HttpURLConnection)url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer("");
            String line = null;
            while (null != (line = reader.readLine())){
                buffer.append(line);
            }
            Message message = new Message();
            message.what = 0;
            message.obj = TodayInHisoryParser.getGson(buffer);
            handler.sendMessage(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
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
