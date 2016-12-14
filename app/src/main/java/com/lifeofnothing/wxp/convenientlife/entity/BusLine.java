package com.lifeofnothing.wxp.convenientlife.entity;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class BusLine implements Serializable{
    private String type;//定义当前公交查询的模式，线路或者站点
    private String terminal_name;
    private String key_name;
    private String front_name;
    private String start_time;
    private String total_price;
    private String length;
    private String end_time;

    private List<Stationde> lb;

    //无参构造函数
    public BusLine() {
    }

    public BusLine(String terminal_name, String key_name, String front_name, String start_time, String total_price, String length, String end_time, List<Stationde> lb) {
        this.terminal_name = terminal_name;
        this.key_name = key_name;
        this.front_name = front_name;
        this.start_time = start_time;
        this.total_price = total_price;
        this.length = length;
        this.end_time = end_time;
        this.lb = lb;
    }

    public String getType() {
        return type;
    }

    public BusLine setType(String type) {
        Log.e("flag",type);
        if ("线路".equals(type)){
            this.type = "线路";
        }else {
            this.type = "站点";
        }
        return this;
    }

    public String getTerminal_name() {
        return terminal_name;
    }

    public BusLine setTerminal_name(String terminal_name) {
        this.terminal_name = terminal_name;
        return this;
    }

    public String getKey_name() {
        return key_name;
    }

    public BusLine setKey_name(String key_name) {
        if (key_name.endsWith("路")){
            this.key_name=key_name.substring(0,key_name.length()-1);
        }else {
            this.key_name = key_name;
        }
        return this;
    }

    public String getFront_name() {
        return front_name;
    }

    public BusLine setFront_name(String front_name) {
        this.front_name = front_name;
        return this;
    }

    public String getStart_time() {
        return start_time;
    }

    public BusLine setStart_time(String start_time) {
        if (4==start_time.length()){
            this.start_time = start_time.substring(0,2)+":"+start_time.substring(2,4);
        }else {
            this.start_time=start_time;
        }
        return this;
    }

    public String getTotal_price() {
        return total_price;
    }

    public BusLine setTotal_price(String total_price) {
        if (total_price.contains(".")){
            this.total_price=total_price.substring(0,total_price.indexOf(".")+3)+"元";
        }else {
            this.total_price = total_price+"元";
        }
        return this;
    }

    public String getLength() {
        return length;
    }

    public BusLine setLength(String length) {
        this.length = length+"公里";
        return this;
    }

    public String getEnd_time() {
        return end_time;
    }

    public BusLine setEnd_time(String end_time) {
        if (4==end_time.length()){
            this.end_time=end_time.substring(0,2)+":"+end_time.substring(2,4);
        }else {
            this.end_time = end_time;
        }
        return this;
    }

    public List<Stationde> getLb() {
        return lb;
    }

    public BusLine setLb(List<Stationde> lb) {
        this.lb = lb;
        return this;
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "type='" + type + '\'' +
                ", terminal_name='" + terminal_name + '\'' +
                ", key_name='" + key_name + '\'' +
                ", front_name='" + front_name + '\'' +
                ", start_time='" + start_time + '\'' +
                ", total_price='" + total_price + '\'' +
                ", length='" + length + '\'' +
                ", end_time='" + end_time + '\'' +
                ", lb=" + lb +
                '}';
    }
}

