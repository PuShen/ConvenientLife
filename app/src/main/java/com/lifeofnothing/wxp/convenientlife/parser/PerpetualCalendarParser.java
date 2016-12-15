package com.lifeofnothing.wxp.convenientlife.parser;


import org.json.JSONException;
import org.json.JSONObject;

import com.lifeofnothing.wxp.convenientlife.entity.PerpetualCalendar;

/**
 * Created by Administrator on 2016/11/25.
 */

public class PerpetualCalendarParser {

    public static PerpetualCalendar getGson(StringBuffer result) {
        PerpetualCalendar p = new PerpetualCalendar("", "", "", "", "", "");
        try {
            JSONObject object = new JSONObject(result.toString());
            JSONObject temp = object.getJSONObject("result");
            JSONObject js1 = temp.getJSONObject("data");
            p = new PerpetualCalendar(js1.getString("lunarYear"), js1.getString("weekday"), js1.getString("lunar"), js1.getString("lunarYear"),
                    js1.getString("year-month"), js1.getString("data"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return p;
    }

}
