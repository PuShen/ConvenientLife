package com.lifeofnothing.wxp.convenientlife.prasor;

import com.lifeofnothing.wxp.convenientlife.entity.WeChat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class WeChatsParser {
    //源Json串
    private String mSource = null;

    public WeChatsParser(String source) {
        this.mSource = source;
    }

    public List<WeChat> parse() {
        //用于保存服务器返回的数据
        List<WeChat> weChats = null;

        //获取服务器返回的状态
        int errorCode = -1;
        try {
            if (mSource != null) {
                JSONObject jsonObject = new JSONObject(mSource);
                errorCode = jsonObject.getInt("error_code");

                //检查服务器返回的状态,若成功则开始数据解析
                if (0 == errorCode) {
                    //开始解析
                    weChats =
                            startParse(jsonObject.getJSONObject("result"));
                } else {
                    //否则赋值为null
                    weChats = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return weChats;
    }

    private List<WeChat> startParse(JSONObject result) {
        //开始解析主要数据
        List<WeChat> weChats = new ArrayList<WeChat>();
        try {
            JSONArray list = result.getJSONArray("list");
            for (int i = 0; i < list.length(); i++) {
                JSONObject object = list.getJSONObject(i);
                WeChat weChat = new WeChat();
                String id = object.getString("id");
                weChat.setId(id);
                String title = object.getString("title");
                weChat.setTitle(title);
                String source = object.getString("source");
                weChat.setSource(source);
                String firstImg = object.getString("firstImg");
                weChat.setFirstImg(firstImg);
                String url = object.getString("url");
                weChat.setUrl(url);
                weChats.add(weChat);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weChats;
    }
}
