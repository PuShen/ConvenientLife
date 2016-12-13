package com.lifeofnothing.wxp.convenientlife.entity;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/12/12.
 */

public class ExplainDream {
    private String title;
    private String des;
    //list里多种对梦的解释
   private List<Lexplaindream> ls;

    public ExplainDream(String title,String des, List<Lexplaindream> ls) {
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

    public List<Lexplaindream> getLs() {
        return ls;
    }

    public ExplainDream setLs(List<Lexplaindream> ls) {
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
