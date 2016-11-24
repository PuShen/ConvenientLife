package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/11/24.
 */

public class LWeather {
    private String d_id;
    private String d_weather;
    private String d_temperature;
    private String d_direct;
    private String d_power;
    private String n_id;//night
    private String n_weather;
    private String n_temperature;
    private String n_direct;
    private String n_power;

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD_weather() {
        return d_weather;
    }

    public void setD_weather(String d_weather) {
        this.d_weather = d_weather;
    }

    public String getD_temperature() {
        return d_temperature;
    }

    public void setD_temperature(String d_temperature) {
        this.d_temperature = d_temperature;
    }

    public String getD_direct() {
        return d_direct;
    }

    public void setD_direct(String d_direct) {
        this.d_direct = d_direct;
    }

    public String getD_power() {
        return d_power;
    }

    public void setD_power(String d_power) {
        this.d_power = d_power;
    }

    public String getN_weather() {
        return n_weather;
    }

    public void setN_weather(String n_weather) {
        this.n_weather = n_weather;
    }

    public String getN_id() {
        return n_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getN_temperature() {
        return n_temperature;
    }

    public void setN_temperature(String n_temperature) {
        this.n_temperature = n_temperature;
    }

    public String getN_direct() {
        return n_direct;
    }

    public void setN_direct(String n_direct) {
        this.n_direct = n_direct;
    }

    public String getN_power() {
        return n_power;
    }

    public void setN_power(String n_power) {
        this.n_power = n_power;
    }
}
