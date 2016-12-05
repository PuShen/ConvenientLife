package com.lifeofnothing.wxp.convenientlife.entity;

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
        this.week = week;
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public Weather setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getHumidity() {
        return humidity;
    }

    public Weather setHumidity(String humidity) {
        this.humidity = humidity;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public Weather setInfo(String info) {
        this.info = info;
        return this;
    }

    public int getImg() {
        return img;
    }

    public Weather setImg(int img) {
        this.img = img;
        return this;
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
}
