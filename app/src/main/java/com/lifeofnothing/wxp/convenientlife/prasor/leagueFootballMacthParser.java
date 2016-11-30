package com.lifeofnothing.wxp.convenientlife.prasor;


import com.lifeofnothing.wxp.convenientlife.entity.LeagueFootballMatch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class leagueFootballMacthParser {

    public static List<LeagueFootballMatch> getGson(StringBuffer result) {
        String mSaiCheng1; //赛程1
        String mSaiCheng2; //赛程2
        String mSaiCheng3; //赛程3
        List<LeagueFootballMatch> list = new ArrayList<>();

        try {
            //获取json  将json数组分类
            JSONObject object = new JSONObject(result.toString());
            JSONObject res = object.getJSONObject("result");
            JSONObject tabs = res.getJSONObject("table");
            JSONArray views = res.getJSONArray("views");
            JSONArray saicheng1 = views.getJSONArray(1);
            JSONArray saicheng2 = views.getJSONArray(2);
            JSONArray saicheng3 = views.getJSONArray(3);
            mSaiCheng1 = tabs.getString("saicheng1");
            mSaiCheng2 = tabs.getString("saicheng2");
            mSaiCheng3 = tabs.getString("saicheng3");
            //循环便利赛程1
            if (mSaiCheng1 != null) {
                for (int i = 0; i < saicheng1.length(); i++) {
                    JSONObject js1 = saicheng1.getJSONObject(i);


                    list.add(new LeagueFootballMatch(mSaiCheng1, mSaiCheng2, mSaiCheng3, tabs.getString("jifenbang"), js1.getString("c1"), js1.getString("c2"),
                            js1.getString("c3"), js1.getString("c4T1"), js1.getString("c4T1URL"), js1.getString("c4R"), js1.getString("c4T2"), js1.getString("c4T2URL"),
                            js1.getString("c51"), js1.getString("c51Link"), js1.getString("c52"), js1.getString("c52Link"), js1.getString("liveid")));
                }
            }
            //循环便利赛程2
            if (mSaiCheng2 != null) {
                for (int i = 0; i < saicheng2.length(); i++) {
                    JSONObject js1 = saicheng2.getJSONObject(i);


                    list.add(new LeagueFootballMatch(mSaiCheng1, mSaiCheng2, mSaiCheng3, tabs.getString("jifenbang"), js1.getString("c1"), js1.getString("c2"),
                            js1.getString("c3"), js1.getString("c4T1"), js1.getString("c4T1URL"), js1.getString("c4R"), js1.getString("c4T2"), js1.getString("c4T2URL"),
                            js1.getString("c51"), js1.getString("c51Link"), js1.getString("c52"), js1.getString("c52Link"), js1.getString("liveid")));
                }
            }
            //循环便利赛程3
            if (mSaiCheng3 != null) {
                for (int i = 0; i < saicheng3.length(); i++) {
                    JSONObject js1 = saicheng3.getJSONObject(i);


                    list.add(new LeagueFootballMatch(mSaiCheng1, mSaiCheng2, mSaiCheng3, tabs.getString("jifenbang"), js1.getString("c1"), js1.getString("c2"),
                            js1.getString("c3"), js1.getString("c4T1"), js1.getString("c4T1URL"), js1.getString("c4R"), js1.getString("c4T2"), js1.getString("c4T2URL"),
                            js1.getString("c51"), js1.getString("c51Link"), js1.getString("c52"), js1.getString("c52Link"), js1.getString("liveid")));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
