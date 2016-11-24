package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/11/24.
 */

public class QQNumber {
    private String qq;
    private String conclusion;
    private String analysis;

    public QQNumber(String qq, String conclusion, String analysis) {
        this.qq = qq;
        this.conclusion = conclusion;
        this.analysis = analysis;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}
