package com.lifeofnothing.wxp.convenientlife.parser;

import android.support.annotation.NonNull;
import android.util.Log;

import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.entity.Stationde;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class BusLineParser {
    //源Json串
    private String mSource = null;

    public BusLineParser(String source) {
        this.mSource = source;
    }

    public List<BusLine> parse(@NonNull String dataType) {
        //用于保存服务器返回的数据
        List<BusLine> busLines = null;

        //获取服务器返回的状态
        int errorCode = -1;
        try {
            if (mSource != null) {
                JSONObject jsonObject = new JSONObject(mSource);
                errorCode = jsonObject.getInt("error_code");

                //检查服务器返回的状态,若成功则开始数据解析
                if (0 == errorCode) {
                    //开始解析
                    busLines =
                            startParse(jsonObject.getJSONArray("result"),dataType);
                } else {
                    //否则赋值为null
                    busLines = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return busLines;
    }

    private List<BusLine> startParse(JSONArray result, @NonNull String dataType) {
        //开始解析主要数据
        List<BusLine> busLines = new ArrayList<BusLine>();

        Log.e("dataType",dataType);
        if (dataType.equals("站点")) { // 站台经往车辆查询模式结果
            for (int i = 0; i < result.length(); i++) {
                BusLine busLine = null;

                try {
                    JSONObject busLineJSONObj = result.getJSONObject(i);
                    busLine = new BusLine();

                    busLine.setType("站点");
                    Log.e("站点模式","请求成功");
                    String keyName = busLineJSONObj.getString("key_name");
                    busLine.setKey_name(keyName);
                    String frontName = busLineJSONObj.getString("front_name");
                    busLine.setFront_name(frontName);
                    String terminalName = busLineJSONObj.getString("terminal_name");
                    busLine.setTerminal_name(terminalName);
                    String startTime = busLineJSONObj.getString("start_time");
                    busLine.setStart_time(startTime);
                    String endTime = busLineJSONObj.getString("end_time");
                    busLine.setEnd_time(endTime);
                    String totalPrice = busLineJSONObj.getString("total_price");
                    busLine.setTotal_price(totalPrice);
                    String length = busLineJSONObj.getString("length");
                    busLine.setLength(length);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                busLines.add(busLine);
            }
            return busLines;
        }

        for (int i = 0; i < result.length(); i++) { // else公交线路查询模式结果
            BusLine busLine = null;

            try {
                JSONObject busLineJSONObj = result.getJSONObject(i);
                busLine = new BusLine();

                busLine.setType("线路");
                String terminalName = busLineJSONObj.getString("terminal_name");
                busLine.setTerminal_name(terminalName);
                String keyName = busLineJSONObj.getString("key_name");
                busLine.setKey_name(keyName);
                String frontName = busLineJSONObj.getString("front_name");
                busLine.setFront_name(frontName);

                JSONArray stationdesJSONArray = busLineJSONObj.getJSONArray("stationdes");
                List<Stationde> stationdes = new ArrayList<Stationde>();
                for (int j = 0; j < stationdesJSONArray.length(); j++) {
                    JSONObject stationdeObj = stationdesJSONArray.getJSONObject(j);
                    Stationde stationde = new Stationde();
                    String stationNum = stationdeObj.getString("stationNum");
                    stationde.setStationNum(stationNum);
                    String name = stationdeObj.getString("name");
                    stationde.setName(name);
                    String xy = stationdeObj.getString("xy");
                    stationde.setXy(xy);
                    stationdes.add(stationde);
                }
                busLine.setLb(stationdes);


                String startTime = busLineJSONObj.getString("start_time");
                busLine.setStart_time(startTime);
                String totalPrice = busLineJSONObj.getString("total_price");
                busLine.setTotal_price(totalPrice);
                String length = busLineJSONObj.getString("length");
                busLine.setLength(length);

                String endTime = busLineJSONObj.getString("end_time");
                busLine.setEnd_time(endTime);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            busLines.add(busLine);
        }

        return busLines;
    }
}
