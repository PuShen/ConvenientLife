//package com.lifeofnothing.wxp.convenientlife.prasor;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//
///**
// * Created by Administrator on 2016/11/23.
// *
// */
//
//public class NBAParser{
//    //源Json串
//    private String mSource = null;
//
//    public NBAParser(String source) {
//        this.mSource = source;
//    }
//
//    public NBA parse() {
//        //用于保存服务器返回的数据
//        NBA nba = null;
//        JSONObject jsonObject = null;
//
//
//        //获取服务器返回的状态
//        String reason = null;
//        try {
//            if (mSource!=null){
//                jsonObject = new JSONObject(mSource);
//                reason = jsonObject.getString("reason");
//            }
//        } catch (JSONException e) {
//            return null;
//            e.printStackTrace();
//        }
//        //检查服务器返回的状态,若成功则开始数据解析
//        if(reason.equals("查询成功")){
//            //开始解析
//            nba =
//                    startParse(jsonObject);
//
//
//        }else{
//            //否则赋值为null
//            nba = null;
//        }
//
//        return nba;
//    }
//
//    private NBA startParse(JSONObject jsonObject) {
//        //开始解析主要数据
//        NBA nba = new NBA();
//
//        return nba;
//    }
//}
