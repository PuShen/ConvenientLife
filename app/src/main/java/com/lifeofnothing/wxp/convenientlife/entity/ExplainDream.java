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

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Lexplaindream> getLs() {
        return ls;
    }

    public void setLs(List<Lexplaindream> ls) {
        this.ls = ls;
    }

    @Override
    public String toString() {
        return "ExplainDream{" +
                "title='" + title + '\'' +
                ", ls=" + ls +
                '}';
    }
}
