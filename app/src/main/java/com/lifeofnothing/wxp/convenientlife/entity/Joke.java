package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by dell on 2016/11/24.
 */

public class Joke {
    private String mContent;  //内容
    private String mHashId;  //哈希码
    private String mUnixtime;   //指定时间

    public Joke(String mContent, String mHashId, String mUnixtime) {
        this.mContent = mContent;
        this.mHashId = mHashId;
        this.mUnixtime = mUnixtime;
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

    public String getmUnixtime() {
        return mUnixtime;
    }

    public void setmUnixtime(String mUnixtime) {
        this.mUnixtime = mUnixtime;
    }

//    public String getmUpdatetime() {
//        return mUpdatetime;
//    }
//
//    public void setmUpdatetime(String mUpdatetime) {
//        this.mUpdatetime = mUpdatetime;
//    }
}
