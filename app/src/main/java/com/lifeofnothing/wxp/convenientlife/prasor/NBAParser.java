package com.lifeofnothing.wxp.convenientlife.prasor;

import com.lifeofnothing.wxp.convenientlife.entity.Nba;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Administrator on 2016/11/23.
 */

public class NbaParser {
    //源Json串
    private String mSource = null;

    public NbaParser(String source) {
        this.mSource = source;
    }

    public Nba parse() {
        //用于保存服务器返回的数据
        Nba nba = null;
        JSONObject jsonObject = null;

        //获取服务器返回的状态
        String reason = null;
        try {
            if (mSource != null) {
                jsonObject = new JSONObject(mSource);
                reason = jsonObject.getString("reason");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        //检查服务器返回的状态,若成功则开始数据解析
        if (reason.equals("查询成功")) {
            //开始解析
            nba =
                    startParse(jsonObject);


        } else {
            //否则赋值为null
            nba = null;
        }

        return nba;
    }

    private Nba startParse(JSONObject jsonObject) {
        //开始解析主要数据
        Nba nba = new Nba();

        return nba;
    }


}
