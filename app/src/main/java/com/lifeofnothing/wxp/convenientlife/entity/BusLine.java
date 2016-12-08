package com.lifeofnothing.wxp.convenientlife.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class BusLine {
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

    public String getTerminal_name() {
        return terminal_name;
    }

    public void setTerminal_name(String terminal_name) {
        this.terminal_name = terminal_name;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getFront_name() {
        return front_name;
    }

    public void setFront_name(String front_name) {
        this.front_name = front_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public List<Stationde> getLb() {
        return lb;
    }

    public void setLb(List<Stationde> lb) {
        this.lb = lb;
    }
}

