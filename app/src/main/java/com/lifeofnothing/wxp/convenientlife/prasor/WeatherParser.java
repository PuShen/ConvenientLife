package com.lifeofnothing.wxp.convenientlife.prasor;

import com.lifeofnothing.wxp.convenientlife.entity.LWeather;
import com.lifeofnothing.wxp.convenientlife.entity.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class WeatherParser {
    //源Json串
    private String mSource = null;

    public WeatherParser(String source) {
        this.mSource = source;
    }

    public Weather parse() {
        //用于保存服务器返回的数据
        Weather weather = null;

        //获取服务器返回的状态
        int errorCode = -1;
        try {
            if (mSource != null) {
                JSONObject jsonObject = new JSONObject(mSource);
                errorCode = jsonObject.getInt("error_code");

                //检查服务器返回的状态,若成功则开始数据解析
                if (0 == errorCode) {
                    //开始解析
                    weather =
                            startParse(jsonObject.getJSONObject("result"));
                } else {
                    //否则赋值为null
                    weather = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return weather;
    }

    private Weather startParse(JSONObject result) {
        //开始解析主要数据
        Weather weather = new Weather();
        try {
            JSONObject data = result.getJSONObject("data");

            //实时天气部分
            JSONObject realtime = data.getJSONObject("realtime");
            String cityCode = realtime.getString("city_code");
            weather.setCity_code(cityCode);
            String cityName = realtime.getString("city_name");
            weather.setCity_name(cityName);
            String date = realtime.getString("data");
            weather.setDate(date);
            String time = realtime.getString("time");
            weather.setTime(time);
            String week = realtime.getString("week");
            weather.setWeek(week);
            String moon = realtime.getString("moon");
            weather.setMoon(moon);
            Double dataUptime = realtime.getDouble("dataUptime");
            weather.setDataUptime(Double.toString(dataUptime));

            JSONObject weatherJSONObj = realtime.getJSONObject("weather");
            String temperature = weatherJSONObj.getString("temperature");
            weather.setTemperature(temperature);
            String humidity = weatherJSONObj.getString("humidity");
            weather.setHumidity(humidity);
            String info = weatherJSONObj.getString("info");
            weather.setInfo(info);
            String img = weatherJSONObj.getString("img");
            weather.setImg(img);

            JSONObject windJSONObj = realtime.getJSONObject("wind");
            String direct = windJSONObj.getString("direct");
            weather.setDirect(direct);
            String power = windJSONObj.getString("power");
            weather.setPower(power);
            String offset = windJSONObj.getString("offset");
            weather.setOffset(offset);
            String windspeed = windJSONObj.getString("windspeed");
            weather.setWindspeed(windspeed);

            //生活指数部分
            JSONObject life = data.getJSONObject("life");
            JSONObject infoJSONObj = life.getJSONObject("info");
            JSONArray chuanyiJSONArray = infoJSONObj.getJSONArray("chuanyi");
            String chuanyi =
                    chuanyiJSONArray.get(0) + "#" + chuanyiJSONArray.get(1);
            weather.setChuanyi(chuanyi);
            JSONArray ganmaoJSONArray = infoJSONObj.getJSONArray("ganmao");
            String ganmao =
                    ganmaoJSONArray.get(0) + "#" + ganmaoJSONArray.get(1);
            weather.setGanmao(ganmao);
            JSONArray kongtiaoJSONArray = infoJSONObj.getJSONArray("kongtiao");
            String kongtiao =
                    kongtiaoJSONArray.get(0) + "#" + kongtiaoJSONArray.get(1);
            weather.setKongtiao(kongtiao);
            JSONArray wuranJSONArray = infoJSONObj.getJSONArray("wuran");
            String wuran =
                    wuranJSONArray.get(0) + "#" + wuranJSONArray.get(1);
            weather.setWuran(wuran);
            JSONArray xicheJSONArray = infoJSONObj.getJSONArray("xiche");
            String xiche =
                    xicheJSONArray.get(0) + "#" + xicheJSONArray.get(1);
            weather.setXiche(xiche);
            JSONArray yundongJSONArray = infoJSONObj.getJSONArray("yundong");
            String yundong =
                    yundongJSONArray.get(0) + "#" + yundongJSONArray.get(1);
            weather.setYundong(yundong);
            JSONArray ziwaixianJSONArray = infoJSONObj.getJSONArray("ziwaixian");
            String ziwaixian =
                    ziwaixianJSONArray.get(0) + "#" + ziwaixianJSONArray.get(1);
            weather.setZiwaixian(ziwaixian);

            //天气预报部分
            JSONArray weatherJSONArray = data.getJSONArray("weather");
            List<LWeather> lWeathers = new ArrayList<LWeather>();
            for (int i = 0; i < weatherJSONArray.length(); i++) {
                LWeather lWeather = new LWeather();
                JSONObject lWeatherJSONObj = weatherJSONArray.getJSONObject(i);
                JSONObject lWeatherInfoJSONObj = lWeatherJSONObj.getJSONObject("info");
                JSONArray dayJSONArray = lWeatherInfoJSONObj.getJSONArray("day");
                JSONArray nightJSONArray = lWeatherInfoJSONObj.getJSONArray("night");

                String dId = (String) dayJSONArray.get(0);
                lWeather.setD_id(dId);
                String dWeather = (String) dayJSONArray.get(1);
                lWeather.setD_weather(dWeather);
                String dTemperature = (String) dayJSONArray.get(2);
                lWeather.setD_temperature(dTemperature);
                String dDirect = (String) dayJSONArray.get(3);
                lWeather.setD_direct(dDirect);
                String dPower = (String) dayJSONArray.get(4);
                lWeather.setD_power(dPower);
                String nId = (String) nightJSONArray.get(0);
                lWeather.setN_id(nId);
                String nWeather = (String) nightJSONArray.get(1);
                lWeather.setN_weather(nWeather);
                String nTemperature = (String) nightJSONArray.get(2);
                lWeather.setN_temperature(nTemperature);
                String nDirect = (String) nightJSONArray.get(3);
                lWeather.setN_direct(nDirect);
                String nPower = (String) nightJSONArray.get(4);
                lWeather.setN_power(nPower);

                lWeathers.add(lWeather);
            }
            weather.setLs(lWeathers);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weather;
    }
}
