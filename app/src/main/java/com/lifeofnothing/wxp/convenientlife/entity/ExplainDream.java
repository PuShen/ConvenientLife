package com.lifeofnothing.wxp.convenientlife.entity;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/12/12.
 */

public class ExplainDream {
    private String title;
    //list里多种对梦的解释
   private List<Lexplaindream> ls;

    public ExplainDream(String title, List<Lexplaindream> ls) {
        this.title = title;
        this.ls = ls;
    }

    public String getTitle() {
        return title;
    }

    public ExplainDream setTitle(String title) {
        this.title = title;
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
                ", ls=" + ls +
                '}';
    }
}
