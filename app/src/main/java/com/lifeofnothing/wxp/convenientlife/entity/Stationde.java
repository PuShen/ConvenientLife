package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/11/24.
 */

public class Stationde {
    private String code;
    private String stationNum;
    private String name;
    private String xy;
    //无参构造函数
    public Stationde() {
    }

    public Stationde(String code, String stationNum, String name, String xy) {
        this.code = code;
        this.stationNum = stationNum;
        this.name = name;
        this.xy = xy;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStationNum() {
        return stationNum;
    }

    public void setStationNum(String stationNum) {
        this.stationNum = stationNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }
}
