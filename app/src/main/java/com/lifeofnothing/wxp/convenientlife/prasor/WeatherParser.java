package com.lifeofnothing.wxp.convenientlife.prasor;

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
            String pubDate = data.getString("pubdate");
            JSONObject realtime = data.getJSONObject("realtime");
            String cityName = realtime.getString("city_name");
            weather.setCity_name(cityName);

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
            String img = realtimeWeatherJSONObj.getString("img");
            int imgInt = Integer.parseInt(img);
            weather.setImg(imgInt);

            JSONObject windJSONObj = realtime.getJSONObject("wind");
            String direct = windJSONObj.getString("direct");
            weather.setDirect(direct);
            String power = windJSONObj.getString("power");
            weather.setPower(power);

            //生活指数部分
            JSONObject life = data.getJSONObject("life");
            JSONObject infoJSONObj = life.getJSONObject("info");
            JSONArray chuanyiJSONArray = infoJSONObj.getJSONArray("chuanyi");
            String chuanyi = chuanyiJSONArray.get(0).toString();
            weather.setChuanyi(chuanyi);
            String chuanyides = chuanyiJSONArray.get(1).toString();
            weather.setChuanyides(chuanyides);
            JSONArray ganmaoJSONArray = infoJSONObj.getJSONArray("ganmao");
            String ganmao = ganmaoJSONArray.get(0).toString();
            weather.setGanmao(ganmao);
            String ganmaodes = ganmaoJSONArray.get(1).toString();
            weather.setGanmaodes(ganmaodes);
            JSONArray kongtiaoJSONArray = infoJSONObj.getJSONArray("kongtiao");
            String kongtiao = kongtiaoJSONArray.get(0).toString();
            weather.setKongtiao(kongtiao);
            String kongtiaodes = kongtiaoJSONArray.get(1).toString();
            weather.setKongtiaodes(kongtiaodes);
            JSONArray xicheJSONArray = infoJSONObj.getJSONArray("xiche");
            String xiche = xicheJSONArray.get(0).toString();
            weather.setXiche(xiche);
            String xichedes = xicheJSONArray.get(1).toString();
            weather.setXichedes(xichedes);
            JSONArray yundongJSONArray = infoJSONObj.getJSONArray("yundong");
            String yundong = yundongJSONArray.get(0).toString();
            weather.setYundong(yundong);
            String yundongdes = yundongJSONArray.get(1).toString();
            weather.setYundongdes(yundongdes);
            JSONArray ziwaixianJSONArray = infoJSONObj.getJSONArray("ziwaixian");
            String ziwaixian = ziwaixianJSONArray.get(0).toString();
            weather.setZiwaixian(ziwaixian);
            String ziwaixiandes = ziwaixianJSONArray.get(1).toString();
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

                int forecastImgInt = Integer.parseInt((String) dayJSONArray.get(0));
                weather1.setImg(forecastImgInt);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weathers;
    }
}
