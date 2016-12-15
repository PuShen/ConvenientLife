package com.lifeofnothing.wxp.convenientlife.parser;



import com.lifeofnothing.wxp.convenientlife.entity.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class NewsParser {

    public static List<News> getGson(StringBuffer result){

          List<News> lnews=new ArrayList<>();
        try {
            JSONObject object=new JSONObject(result.toString());
            JSONObject temp=object.getJSONObject("result");
            JSONArray data=temp.getJSONArray("data");

            for(int i=0;i<data.length();i++){
                JSONObject js1=data.getJSONObject(i);
                JSONObject js2=data.getJSONObject(i);
                JSONObject js3=data.getJSONObject(i);
                JSONObject js4=data.getJSONObject(i);
                JSONObject js5=data.getJSONObject(i);

                lnews.add(new News(js1.getString("title"),js2.getString("author_name"),js3.getString("url"),js4.getString("thumbnail_pic_s"),js5.getString("date")));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return lnews;
    }

}
