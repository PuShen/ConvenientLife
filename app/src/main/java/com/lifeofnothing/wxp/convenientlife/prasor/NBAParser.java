package com.lifeofnothing.wxp.convenientlife.prasor;

import com.lifeofnothing.wxp.convenientlife.entity.Nba;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Administrator on 2016/11/23.
 */

public class NBAParser {
    //源Json串
    private String mSource = null;

    public NBAParser(String source) {
        this.mSource = source;
    }

    public Nba parse() {
        //用于保存服务器返回的数据
        Nba nba = null;

        //获取服务器返回的状态
        int errorCode = -1;
        try {
            if (mSource != null) {
                JSONObject jsonObject = new JSONObject(mSource);
                errorCode = jsonObject.getInt("error_code");

                //检查服务器返回的状态,若成功则开始数据解析
                if (0 == errorCode) {
                    //开始解析
                    nba =
                            startParse(jsonObject.getJSONObject("result"));
                } else {
                    //否则赋值为null
                    nba = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return nba;
    }

    private Nba startParse(JSONObject jsonObject) {
        //开始解析主要数据
        Nba nba = new Nba();

        return nba;
    }


}
