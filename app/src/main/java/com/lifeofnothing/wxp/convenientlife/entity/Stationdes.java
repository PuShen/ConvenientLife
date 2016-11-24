package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/11/24.
 */

public class Stationdes {
    private String code;
    private String stationNum;
    private String name;
    private String xy;

    public Stationdes(String code, String stationNum, String name, String xy) {
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
