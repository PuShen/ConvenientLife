package com.lifeofnothing.wxp.convenientlife.prasor;

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

    public List<BusLine> parse() {
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
                            startParse(jsonObject.getJSONArray("result"));
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

    private List<BusLine> startParse(JSONArray result) {
        //开始解析主要数据
        List<BusLine> busLines = new ArrayList<BusLine>();

        for (int i = 0; i < result.length(); i++) {
            BusLine busLine = null;

            try {
                JSONObject busLineJSONObj = result.getJSONObject(i);
                busLine = new BusLine();

                String terminalName = busLineJSONObj.getString("terminal_name");
                busLine.setTerminal_name(terminalName);
                String frontSpell = busLineJSONObj.getString("front_spell");
                busLine.setFront_spell(frontSpell);
                String lineId = busLineJSONObj.getString("line_id");
                busLine.setLine_id(lineId);
                String keyName = busLineJSONObj.getString("key_name");
                busLine.setKey_name(keyName);
                String timeDesc = busLineJSONObj.getString("time_desc");
                busLine.setTime_desc(timeDesc);
                String frontName = busLineJSONObj.getString("front_name");
                busLine.setFront_name(frontName);

                JSONArray stationdesJSONArray = busLineJSONObj.getJSONArray("stationdes");
                List<Stationde> stationdes = new ArrayList<Stationde>();
                for (int j = 0; j < stationdesJSONArray.length(); j++) {
                    JSONObject stationdeObj = stationdesJSONArray.getJSONObject(j);
                    Stationde stationde = new Stationde();
                    String code = stationdeObj.getString("code");
                    stationde.setCode(code);
                    String stationNum = stationdeObj.getString("stationNum");
                    stationde.setStationNum(stationNum);
                    String name = stationdeObj.getString("name");
                    stationde.setName(name);
                    String xy = stationdeObj.getString("xy");
                    stationde.setXy(xy);
                    stationdes.add(stationde);
                }

                String description = busLineJSONObj.getString("description");
                busLine.setDescription(description);
                String startTime = busLineJSONObj.getString("start_time");
                String hour = startTime.substring(0, 1);
                String minute = startTime.substring(2, 3);
                busLine.setEnd_time(hour + ":" + minute);
                busLine.setStart_time(startTime);
                String photo_folder = busLineJSONObj.getString("photo_folder");
                busLine.setPhoto_floder(photo_folder);
//                String interval5 = busLineJSONObj.getString("interval5"); //意义不明
//                busLine.setInterval5(interval5);//意义不明
                String gpsfileId = busLineJSONObj.getString("gpsfile_id");
                busLine.setGpsfile_id(gpsfileId);
                String dataSource = busLineJSONObj.getString("data_source");
                busLine.setData_source(dataSource);
                String totalPrice = busLineJSONObj.getString("total_price");
                busLine.setTotal_price(totalPrice);
                String company = busLineJSONObj.getString("company");
                busLine.setCompany(company);
                String speed = busLineJSONObj.getString("speed");
                busLine.setSpeed(speed);
                String length = busLineJSONObj.getString("length");
                busLine.setLength(length);
                String loop = busLineJSONObj.getString("loop").equals("0") ? "是" : "否";
                busLine.setLoop(loop);
                String auto = busLineJSONObj.getString("auto").equals("0") ? "人工售票" : "无人售票";
                busLine.setAuto(auto);
                String icCard = busLineJSONObj.getString("ic_card").equals("0") ? "不可以使用" : "可以使用";
                busLine.setIc_card(icCard);
                String doubleDeck = busLineJSONObj.getString("double_deck").equals("0") ? "否" : "是";
                busLine.setDouble_deck(doubleDeck);
                String expressWay = busLineJSONObj.getString("express_way").equals("0") ? "不经过" : "经过";
                busLine.setExpress_way(expressWay);
                String status = busLineJSONObj.getString("status").equals("0") ? "停运" : "正常";
                busLine.setStatus(status);
                String basicPrice = busLineJSONObj.getString("basic_price");
                busLine.setBasic_price(basicPrice);
                String endTime = busLineJSONObj.getString("end_time");
                hour = endTime.substring(0, 1);
                minute = endTime.substring(2, 3);
                busLine.setEnd_time(hour + ":" + minute);
                String air = busLineJSONObj.getString("air").equals("0") ? "非空调车" : "空调车";
                busLine.setAir(air);
                String type = busLineJSONObj.getString("type");
                busLine.setType(type);
                String paperTableId = busLineJSONObj.getString("paper_table_id");
                busLine.setPaper_table_id(paperTableId);
                String name = busLineJSONObj.getString("name");
                busLine.setName(name);
                String commutationTicket = busLineJSONObj.getString("commutation_ticket").equals("0") ? "不可用" : "可用";
                busLine.setCommutation_ticket(commutationTicket);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            busLines.add(busLine);
        }

        return busLines;
    }
}
