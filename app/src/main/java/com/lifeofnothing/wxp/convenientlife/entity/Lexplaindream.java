package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/12/13.
 */

public class Lexplaindream {
    private String explain;

    public Lexplaindream(String explain) {
        this.explain = explain;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public String toString() {
        return "Lexplaindream{" +
                "explain='" + explain + '\'' +
                '}';
    }
}
