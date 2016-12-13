package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/12/12.
 */

public class ExplainDream {
    private String title;
    //list里多种对梦的解释
    private String explain1;
    private String explain2;
    private String explain3;
    private String explain4;
    private String explain5;
    private String explain6;
    private String explain7;

    public ExplainDream() {
    }

    public ExplainDream(String title, String explain1, String explain2, String explain3, String explain4, String explain5, String explain6, String explain7) {
        this.title = title;
        this.explain1 = explain1;
        this.explain2 = explain2;
        this.explain3 = explain3;
        this.explain4 = explain4;
        this.explain5 = explain5;
        this.explain6 = explain6;
        this.explain7 = explain7;
    }

    public String getTitle() {
        return title;
    }

    public ExplainDream setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getExplain1() {
        return explain1;
    }

    public ExplainDream setExplain1(String explain1) {
        this.explain1 = explain1;
        return this;
    }

    public String getExplain2() {
        return explain2;
    }

    public ExplainDream setExplain2(String explain2) {
        this.explain2 = explain2;
        return this;
    }

    public String getExplain3() {
        return explain3;
    }

    public ExplainDream setExplain3(String explain3) {
        this.explain3 = explain3;
        return this;
    }

    public String getExplain4() {
        return explain4;
    }

    public ExplainDream setExplain4(String explain4) {
        this.explain4 = explain4;
        return this;
    }

    public String getExplain5() {
        return explain5;
    }

    public ExplainDream setExplain5(String explain5) {
        this.explain5 = explain5;
        return this;
    }

    public String getExplain6() {
        return explain6;
    }

    public ExplainDream setExplain6(String explain6) {
        this.explain6 = explain6;
        return this;
    }

    public String getExplain7() {
        return explain7;
    }

    public ExplainDream setExplain7(String explain7) {
        this.explain7 = explain7;
        return this;
    }
}
