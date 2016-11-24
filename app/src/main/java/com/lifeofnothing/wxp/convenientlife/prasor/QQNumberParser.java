package com.lifeofnothing.wxp.convenientlife.prasor;

import com.lifeofnothing.wxp.convenientlife.entity.QQNumber;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/11/24.
 */

public class QQNumberParser {
    //源Json串
    private String mSource = null;

    public QQNumberParser(String source) {
        this.mSource = source;
    }

    public QQNumber parse() {
        //用于保存服务器返回的数据
        QQNumber qqNumber = null;

        //获取服务器返回的状态
        int errorCode = -1;
        try {
            if (mSource != null) {
                JSONObject jsonObject = new JSONObject(mSource);
                errorCode = jsonObject.getInt("error_code");

                //检查服务器返回的状态,若成功则开始数据解析
                if (0 == errorCode) {
                    //开始解析
                    qqNumber =
                            startParse(jsonObject.getJSONObject("result"));
                } else {
                    //否则赋值为null
                    qqNumber = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return qqNumber;
    }

    private QQNumber startParse(JSONObject result) {
        //开始解析主要数据
        QQNumber qqNumber = new QQNumber();
        String conclusion = null;
        String analysis = null;
        try {
            JSONObject data = result.getJSONObject("data");
            conclusion = data.getString("conclusion");
            analysis = data.getString("analysis");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        qqNumber.setConclusion(conclusion);
        qqNumber.setAnalysis(analysis);
        return qqNumber;
    }
}
