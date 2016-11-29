package com.lifeofnothing.wxp.convenientlife.prasor;


import com.lifeofnothing.wxp.convenientlife.entity.TodayInHistory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 2016/11/29
 */

public class TodayInHisoryParser {

    public static List<TodayInHistory> getGson(StringBuffer result) {

        List<TodayInHistory> list = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(result.toString());
            JSONArray data = object.getJSONArray("result");
//循环便利result Jason 数组
            for (int i = 0; i < data.length(); i++) {
                JSONObject js1 = data.getJSONObject(i);
                list.add(new TodayInHistory(js1.getString("id"), js1.getString("title"), js1.getString("pic"), js1.getString("year"), js1.getString("month"), js1.getString("day"), js1.getString("des"), js1.getString("lindar")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
