package com.lifeofnothing.wxp.convenientlife.parser;


import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2016/12/1
 */

public class JokeParser {

    private int flag; // 用于区别传来的信息

    public static List<Joke> getGson(StringBuffer result , int flag) {

        List<Joke> list = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(result.toString());
            JSONArray data = object.getJSONArray("result");

            switch (flag){
                case 0:
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject js1 = data.getJSONObject(i);

                        list.add(new Joke(js1.getString("content"), js1.getString("hashId"), js1.getString("unixtime")));
                    }
                    break;
                case 1:
                    for (int i = 0; i <data.length();i++){
                        JSONObject js2 = data.getJSONObject(i);
                        Log.e("测试","调用");
                        String b = js2.getString("url");
                        if(b != null){
                            list.add(new Joke(js2.getString("content"),js2.getString("hashId"),js2.getString("unixtime"),js2.getString("url")));
                        }
                    }
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
