package com.lifeofnothing.wxp.convenientlife.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class Weather {
//城市，日期，图标
    private String city_name;
    private String date;
//周几
    private String week;
//当前天气
    private String weather;
    private String temperature;
    private String humidity;
    private String info;
    private int img;
//风
    private String direct;
    private String power;
    private String offset;
    private String windspeed;
//生活指数
    private String chuanyi;
    private String ganmao;
    private String kongtiao;
    private String wuran;
    private String xiche;
    private String yundong;
    private String ziwaixian;
//PM2.5
    private String pm25;
    private String pm10;
    private String quality;
    private String des;

    public Weather() {
    }

    public Weather(  String city_name, String date, String week, String weather, String humidity,String info,int img, String temperature, String direct, String power, String offset, String windspeed, String chuanyi, String ganmao, String kongtiao, String wuran, String xiche, String yundong, String ziwaixian, String curPm, String pm25, String pm10, String level, String quality, String des) {

        this.city_name = city_name;
        this.date = date;
        this.week = week;
        this.weather = weather;
        this.humidity = humidity;
        this.temperature = temperature;
        this.info=info;
        this.img=img;
        this.direct = direct;
        this.power = power;
        this.offset = offset;
        this.windspeed = windspeed;
        this.chuanyi = chuanyi;
        this.ganmao = ganmao;
        this.kongtiao = kongtiao;
        this.wuran = wuran;
        this.xiche = xiche;
        this.yundong = yundong;
        this.ziwaixian = ziwaixian;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.quality = quality;
        this.des = des;

    }


    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getChuanyi() {
        return chuanyi;
    }

    public void setChuanyi(String chuanyi) {
        this.chuanyi = chuanyi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWuran() {
        return wuran;
    }

    public void setWuran(String wuran) {
        this.wuran = wuran;
    }

    public String getKongtiao() {
        return kongtiao;
    }

    public void setKongtiao(String kongtiao) {
        this.kongtiao = kongtiao;
    }

    public String getXiche() {
        return xiche;
    }

    public void setXiche(String xiche) {
        this.xiche = xiche;
    }

    public String getYundong() {
        return yundong;
    }

    public void setYundong(String yundong) {
        this.yundong = yundong;
    }

    public String getZiwaixian() {
        return ziwaixian;
    }

    public void setZiwaixian(String ziwaixian) {
        this.ziwaixian = ziwaixian;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }



}
