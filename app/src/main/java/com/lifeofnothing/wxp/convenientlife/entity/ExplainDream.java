package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/12/12.
 */

public class ExplainDream {
    private String title;
    private String des;
    private String list;

    public ExplainDream() {
    }

    public ExplainDream(String title, String des, String list) {
        this.title = title;
        this.des = des;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
