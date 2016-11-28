package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by dell on 2016/11/24.
 */

public class Joke {
    private String mContent;  //内容
    private String mHashId;  //哈希码
    private int mUnixtime;   //指定时间
    private String mUpdatetime; //更新时间

    public Joke(String mContent, String mHashId, int mUnixtime, String mUpdatetime) {
        this.mContent = mContent;
        this.mHashId = mHashId;
        this.mUnixtime = mUnixtime;
        this.mUpdatetime = mUpdatetime;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmHashId() {
        return mHashId;
    }

    public void setmHashId(String mHashId) {
        this.mHashId = mHashId;
    }

    public int getmUnixtime() {
        return mUnixtime;
    }

    public void setmUnixtime(int mUnixtime) {
        this.mUnixtime = mUnixtime;
    }

    public String getmUpdatetime() {
        return mUpdatetime;
    }

    public void setmUpdatetime(String mUpdatetime) {
        this.mUpdatetime = mUpdatetime;
    }
}
