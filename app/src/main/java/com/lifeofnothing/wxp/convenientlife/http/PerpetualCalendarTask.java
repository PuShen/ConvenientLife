package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.parser.PerpetualCalendarParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 我需要一枚好辅助丶 on 2016/11/30.
 */

public class PerpetualCalendarTask implements Runnable {
    private String mParam;         //用来存用户输入的日期
    private Handler mHandler;      //用于将返回的信息发送
    private String mParam2 = "822e68f61e7aa02460eb28735dacfcb9";        //app key
    private  String mUrl;

    //构造方法
    public PerpetualCalendarTask(String mParam, Handler mHandler) {
        this.mParam = mParam;
        this.mHandler = mHandler;
    }

    @Override
    public void run() {
        mUrl = "http://v.juhe.cn/calendar/day?date="+mParam+"&key="+mParam2;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            //进行网络请求
            URL url = new URL(mUrl);
            connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer("");
            String line = null;
            while (null != (line = reader.readLine())){
                buffer.append(line);
            }
            //发送信息
            Log.e("ab",PerpetualCalendarParser.getGson(buffer).toString());
            Message message = new Message();
            message.what = 0;
            message.obj = PerpetualCalendarParser.getGson(buffer);
            mHandler.sendMessage(message);
            reader.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(2);
        }finally {
            //释放资源
            if(null != reader){
                try {
                    reader.close();
                    connection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection){
                connection.disconnect();
            }
        }
    }
}
