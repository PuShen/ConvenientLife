package com.lifeofnothing.wxp.convenientlife.parser;

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

    public List<Weather> parse() {
        //用于保存服务器返回的数据
        List<Weather> weathers = null;

        //获取服务器返回的状态
        int errorCode = -1;
        try {
            if (mSource != null) {
                JSONObject jsonObject = new JSONObject(mSource);
                errorCode = jsonObject.getInt("error_code");

                //检查服务器返回的状态,若成功则开始数据解析
                if (0 == errorCode) {
                    //开始解析
                    weathers =
                            startParse(jsonObject.getJSONObject("result"));
                } else {
                    //否则赋值为null
                    weathers = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return weathers;
    }

    private List<Weather> startParse(JSONObject result) {
        //开始解析主要数据
        List<Weather> weathers = new ArrayList<Weather>();
        Weather weather = null;
        try {
            JSONObject data = result.getJSONObject("data");
//            String pubDate = data.getString("pubdate");
            JSONObject realtime = data.getJSONObject("realtime");
            String cityName = realtime.getString("city_name");
            String pubDate=data.getString("date");

            weather = new Weather(cityName, pubDate);

            String week = realtime.getString("week");
            weather.setWeek(week);
            JSONObject realtimeWeatherJSONObj = realtime.getJSONObject("weather");
            String temperature = realtimeWeatherJSONObj.getString("temperature");
            weather.setTemperature(temperature);
            String humidity = realtimeWeatherJSONObj.getString("humidity");
            weather.setHumidity(humidity);
            String info = realtimeWeatherJSONObj.getString("info");
            weather.setInfo(info);

            JSONObject windJSONObj = realtime.getJSONObject("wind");
            String direct = windJSONObj.getString("direct");
            weather.setDirect(direct);
            String power = windJSONObj.getString("power");
            weather.setPower(power);

            //生活指数部分
            JSONObject life = data.getJSONObject("life");
            JSONObject infoJSONObj = life.getJSONObject("info");
            JSONArray chuanyiJSONArray = infoJSONObj.getJSONArray("chuanyi");
            String chuanyi = (String) chuanyiJSONArray.get(0);
            weather.setChuanyi(chuanyi);
            String chuanyides = (String) chuanyiJSONArray.get(1);
            weather.setChuanyides(chuanyides);
            JSONArray ganmaoJSONArray = infoJSONObj.getJSONArray("ganmao");
            String ganmao = (String) ganmaoJSONArray.get(0);
            weather.setGanmao(ganmao);
            String ganmaodes = (String) ganmaoJSONArray.get(1);
            weather.setGanmaodes(ganmaodes);
            JSONArray kongtiaoJSONArray = infoJSONObj.getJSONArray("kongtiao");
            String kongtiao = (String) kongtiaoJSONArray.get(0);
            weather.setKongtiao(kongtiao);
            String kongtiaodes = (String) kongtiaoJSONArray.get(1);
            weather.setKongtiaodes(kongtiaodes);
            JSONArray xicheJSONArray = infoJSONObj.getJSONArray("xiche");
            String xiche = (String) xicheJSONArray.get(0);
            weather.setXiche(xiche);
            String xichedes = (String) xicheJSONArray.get(1);
            weather.setXichedes(xichedes);
            JSONArray yundongJSONArray = infoJSONObj.getJSONArray("yundong");
            String yundong = (String) yundongJSONArray.get(0);
            weather.setYundong(yundong);
            String yundongdes = (String) yundongJSONArray.get(1);
            weather.setYundongdes(yundongdes);
            JSONArray ziwaixianJSONArray = infoJSONObj.getJSONArray("ziwaixian");
            String ziwaixian = (String) ziwaixianJSONArray.get(0);
            weather.setZiwaixian(ziwaixian);
            String ziwaixiandes = (String) ziwaixianJSONArray.get(1);
            weather.setZiwaixiandes(ziwaixiandes);

            weathers.add(weather);

            //天气预报部分
            JSONArray weatherJSONArray = data.getJSONArray("weather");

            for (int i = 1; i < weatherJSONArray.length(); i++) {
                Weather weather1 = new Weather(cityName, null);

                JSONObject weatherJSONObj = weatherJSONArray.getJSONObject(i);
                String date = weatherJSONObj.getString("date");
                weather1.setDate(date);
                JSONObject weatherInfoJSONObj = weatherJSONObj.getJSONObject("info");
                JSONArray dayJSONArray = weatherInfoJSONObj.getJSONArray("day");

                String forecastInfo = (String) dayJSONArray.get(1);
                weather1.setInfo(forecastInfo);
                String forecastTemperature = (String) dayJSONArray.get(2);
                weather1.setTemperature(forecastTemperature);
                String forecastDirect = (String) dayJSONArray.get(3);
                weather1.setDirect(forecastDirect);
                String forecastPower = (String) dayJSONArray.get(4);
                weather1.setPower(forecastPower);
                String forecastWeek = weatherJSONObj.getString("week");
                weather1.setWeek(forecastWeek);

                weathers.add(weather1);
            }
            //空气质量
            JSONObject airPollution = data.getJSONObject("pm25");
            JSONObject pm25JSONObj = airPollution.getJSONObject("pm25");
            String pm25 = pm25JSONObj.getString("pm25");
            weathers.get(0).setPm25(pm25);
            String pm10 = pm25JSONObj.getString("pm10");
            weathers.get(0).setPm10(pm10);
            String quality = pm25JSONObj.getString("quality");
            weathers.get(0).setQuality(quality);
            String des = pm25JSONObj.getString("des");
            weathers.get(0).setDes(des);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weathers;
    }
}
