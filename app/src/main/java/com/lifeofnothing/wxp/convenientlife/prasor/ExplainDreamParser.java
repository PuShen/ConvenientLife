package com.lifeofnothing.wxp.convenientlife.prasor;

import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.ExplainDream;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/12/13.
 */

public class ExplainDreamParser {
    public static List<ExplainDream> getGson(JSONObject object){

        List<ExplainDream> explaindream=new ArrayList<>();

        try {
            JSONArray jsexplaindream=object.getJSONArray("result");
            for(int i=0;i<jsexplaindream.length();i++){
               JSONObject js1=jsexplaindream.getJSONObject(i);
                JSONArray jsonArray=js1.getJSONArray("list");
                 List<String> list=new ArrayList<>();
                 for(int j=0;j<jsonArray.length();j++){
                     list.add(jsonArray.getString(j));
                }

                explaindream.add(new ExplainDream(js1.getString("title"),js1.getString("des"),list));
                // Log.e("result", String.valueOf(list));
            }
           // Log.e("result", String.valueOf(explaindream));

        }catch (JSONException e){
            e.printStackTrace();
        }

     return explaindream;
    }
}
