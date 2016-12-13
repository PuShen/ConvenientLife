package com.lifeofnothing.wxp.convenientlife.prasor;


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

    public static List<Joke> getGson(StringBuffer result) {

        List<Joke> list = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(result.toString());
            JSONArray data = object.getJSONArray("result");

            for (int i = 0; i < data.length(); i++) {
                JSONObject js1 = data.getJSONObject(i);
                String b = js1.getString("url");
                if(b == null){
                    list.add(new Joke(js1.getString("content"), js1.getString("hashId"), js1.getString("unixtime")));
                }else{
                    list.add(new Joke(js1.getString("content"),js1.getString("hashId"),js1.getString("unixtime"),js1.getString("url")));
                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
