package com.lifeofnothing.wxp.convenientlife.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.WeChat;
import com.lifeofnothing.wxp.convenientlife.prasor.NewsParser;
import com.lifeofnothing.wxp.convenientlife.prasor.WeChatsParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by a on 2016/11/30.
 */

public class RefreshTask implements Runnable {
    private String mParam;
    private Handler mHandler;
    private List<WeChat> mList;

    public RefreshTask(String mParam, Handler mHandler, List<WeChat> mList) {
        this.mParam = mParam;
        this.mHandler = mHandler;
        this.mList = mList;
    }

    @Override
    public void run() {
        HttpURLConnection connection=null;
        BufferedReader reader=null;
        try {
            URL url=new URL(mParam);
            connection=(HttpURLConnection) url.openConnection();
            reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer=new StringBuffer("");
            String line=null;
            while (null!=(line=reader.readLine())){
                buffer.append(line);
            }
            WeChatsParser parser=new WeChatsParser(buffer.toString());
            Log.e("refresh", String.valueOf(parser.parse()==null));
            for (WeChat i:parser.parse()){
                mList.add(0,i);
            }
            mHandler.sendEmptyMessage(1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
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
