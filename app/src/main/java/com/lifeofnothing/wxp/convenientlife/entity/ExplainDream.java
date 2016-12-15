package com.lifeofnothing.wxp.convenientlife.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/12/12.
 */

public class ExplainDream implements Serializable{
    private String title;
    private String des;
    //1 list里多种对梦的解释
   private List<String> ls;

    public ExplainDream(String title, String des, List<String> ls) {
        this.title = title;
        this.des=des;
        this.ls = ls;
    }

    public String getTitle() {
        return title;
    }

    public ExplainDream setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDes() {
        return des;
    }

    public ExplainDream setDes(String des) {
        this.des = des;
        return this;
    }

    public List<String> getLs() {
        return ls;
    }

    public ExplainDream setLs(List<String> ls) {
        this.ls = ls;
        return this;
    }

    @Override
    public String toString() {
        return "ExplainDream{" +
                "title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", ls=" + ls +
                '}';
    }
}
