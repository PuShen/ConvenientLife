package com.lifeofnothing.wxp.convenientlife.entity;

import com.lifeofnothing.wxp.convenientlife.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class Weather {
//城市，日期
    private String city_name;
    private String date;
//周几
    private String week;
//当前天气
    private String temperature;
    private String humidity;
    private String info;
    private int img;
//风
    private String direct;
    private String power;

//生活指数
    private String chuanyi;
    private String chuanyides;
    private String ganmao;
    private String ganmaodes;
    private String kongtiao;
    private String kongtiaodes;
    private String xiche;
    private String xichedes;
    private String yundong;
    private String yundongdes;
    private String ziwaixian;
    private String ziwaixiandes;
//PM2.5
    private String pm25;
    private String pm10;
    private String quality;
    private String des;

    public Weather(String city_name, String date) {
        this.city_name = city_name;
        this.date = date;
    }

    public String getCity_name() {
        return city_name;
    }

    public Weather setCity_name(String city_name) {
        this.city_name = city_name;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Weather setDate(String date) {
        this.date = date;
        return this;
    }

    public String getChuanyides() {
        return chuanyides;
    }

    public Weather setChuanyides(String chuanyides) {
        this.chuanyides = chuanyides;
        return this;
    }

    public String getGanmaodes() {
        return ganmaodes;
    }

    public Weather setGanmaodes(String ganmaodes) {
        this.ganmaodes = ganmaodes;
        return this;
    }

    public String getKongtiaodes() {
        return kongtiaodes;
    }

    public Weather setKongtiaodes(String kongtiaodes) {
        this.kongtiaodes = kongtiaodes;
        return this;
    }

    public String getXichedes() {
        return xichedes;
    }

    public Weather setXichedes(String xichedes) {
        this.xichedes = xichedes;
        return this;
    }

    public String getYundongdes() {
        return yundongdes;
    }

    public Weather setYundongdes(String yundongdes) {
        this.yundongdes = yundongdes;
        return this;
    }

    public String getZiwaixiandes() {
        return ziwaixiandes;
    }

    public Weather setZiwaixiandes(String ziwaixiandes) {
        this.ziwaixiandes = ziwaixiandes;
        return this;
    }

    public String getWeek() {
        return week;
    }

    public Weather setWeek(String week) {
        this.week = "星期"+week;
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public Weather setTemperature(String temperature) {
        this.temperature = temperature+"°";
        return this;
    }

    public String getHumidity() {
        return humidity;
    }

    public Weather setHumidity(String humidity) {
        this.humidity = humidity+"％";
        return this;
    }

    public String getInfo() {
        return info;
    }

    public Weather setInfo(String info) {
        this.info = info;
        setImg(info);
        return this;
    }

    public int getImg() {
        return img;
    }


    public String getDirect() {
        return direct;
    }

    public Weather setDirect(String direct) {
        this.direct = direct;
        return this;
    }

    public String getPower() {
        return power;
    }

    public Weather setPower(String power) {
        this.power = power;
        return this;
    }

    public String getChuanyi() {
        return chuanyi;
    }

    public Weather setChuanyi(String chuanyi) {
        this.chuanyi = chuanyi;
        return this;
    }

    public String getGanmao() {
        return ganmao;
    }

    public Weather setGanmao(String ganmao) {
        this.ganmao = ganmao;
        return this;
    }

    public String getKongtiao() {
        return kongtiao;
    }

    public Weather setKongtiao(String kongtiao) {
        this.kongtiao = kongtiao;
        return this;
    }

    public String getXiche() {
        return xiche;
    }

    public Weather setXiche(String xiche) {
        this.xiche = xiche;
        return this;
    }

    public String getYundong() {
        return yundong;
    }

    public Weather setYundong(String yundong) {
        this.yundong = yundong;
        return this;
    }

    public String getZiwaixian() {
        return ziwaixian;
    }

    public Weather setZiwaixian(String ziwaixian) {
        this.ziwaixian = ziwaixian;
        return this;
    }

    public String getPm25() {
        return pm25;
    }

    public Weather setPm25(String pm25) {
        this.pm25 = pm25;
        return this;
    }

    public String getPm10() {
        return pm10;
    }

    public Weather setPm10(String pm10) {
        this.pm10 = pm10;
        return this;
    }

    public String getQuality() {
        return quality;
    }

    public Weather setQuality(String quality) {
        this.quality = quality;
        return this;
    }

    public String getDes() {
        return des;
    }

    public Weather setDes(String des) {
        this.des = des;
        return this;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city_name='" + city_name + '\'' +
                ", date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", info='" + info + '\'' +
                ", img=" + img +
                ", direct='" + direct + '\'' +
                ", power='" + power + '\'' +
                ", chuanyi='" + chuanyi + '\'' +
                ", chuanyides='" + chuanyides + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", ganmaodes='" + ganmaodes + '\'' +
                ", kongtiao='" + kongtiao + '\'' +
                ", kongtiaodes='" + kongtiaodes + '\'' +
                ", xiche='" + xiche + '\'' +
                ", xichedes='" + xichedes + '\'' +
                ", yundong='" + yundong + '\'' +
                ", yundongdes='" + yundongdes + '\'' +
                ", ziwaixian='" + ziwaixian + '\'' +
                ", ziwaixiandes='" + ziwaixiandes + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", pm10='" + pm10 + '\'' +
                ", quality='" + quality + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    private void setImg(String info){
        switch (info){
            case "晴":
                img= R.drawable.weather_qing;
                break;
            case "多云":
                img=R.drawable.weather_duoyun;
                break;
            case "霾":
                img=R.drawable.weather_mai;
                break;
            case "阴":
                img=R.drawable.weather_yin;
                break;
            case "阵雨":
                img=R.drawable.weather_zhenyu;
                break;
            case "雷阵雨":
                img=R.drawable.weather_leizhenyu;
                break;
            case "雷阵雨伴有冰雹":
                img=R.drawable.weather_leiyubing;
                break;
            case "雨夹雪":
                img=R.drawable.weather_yujiaxue;
                break;
            case "小雨":
                img=R.drawable.weather_xiaoyu;
                break;
            case "中雨":
                img=R.drawable.weather_zhongyu;
                break;
            case "大雨":
                img=R.drawable.weather_dayu;
                break;
            case "暴雨":
                img=R.drawable.weather_baoyu;
                break;
            case "大暴雨":
                img=R.drawable.weather_dabaoyu;
                break;
            case "特大暴雨":
                img=R.drawable.weather_tedabaoyu;
                break;
            case "阵雪":
                img=R.drawable.weather_zhenxue;
                break;
            case "小雪":
                img=R.drawable.weather_xiaoxue;
                break;
            case "中雪":
                img=R.drawable.weather_zhongxue;
                break;
            case "大雪":
                img=R.drawable.weather_daxue;
                break;
            case "暴雪":
                img=R.drawable.weather_baoxue;
                break;
            case "雾":
                img=R.drawable.weather_wu;
                break;
            case "冻雨":
                img=R.drawable.weather_dongyu;
                break;
            case "沙尘暴":
                img=R.drawable.weather_shachen;
                break;
            case "小雨-中雨":
                img=R.drawable.weather_yu_zhuan1;
                break;
            case "中雨-大雨":
                img=R.drawable.weather_yu_zhuan2;
                break;
            case "大雨-暴雨":
                img=R.drawable.weather_yu_zhuan3;
                break;
            case "暴雨-大暴雨":
                img=R.drawable.weather_yu_zhuan4;
                break;
            case "大暴雨-特大暴雨":
                img=R.drawable.weather_yu_zhuan5;
                break;
            case "小雪-中雪":
                img=R.drawable.weather_xue_zhuan1;
                break;
            case "中雪-大雪":
                img=R.drawable.weather_xue_zhuan2;
                break;
            case "大雪-暴雪":
                img=R.drawable.weather_xue_zhuan3;
                break;
            case "浮尘":
                img=R.drawable.weather_fuchen;
                break;
            case "扬沙":
                img=R.drawable.weather_yangsha;
                break;
            case "强沙尘暴":
                img=R.drawable.weather_qiangchen;
                break;
            default:
                img= R.drawable.weather_qing;
                break;
        }
    }
}
