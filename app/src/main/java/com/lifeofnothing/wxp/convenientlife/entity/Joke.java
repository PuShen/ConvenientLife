package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by dell on 2016/11/24.
 */

public class Joke {
    private String mContent;
    private String mHashId;

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

    private int mUnixtime;
    private String mUpdatetime;

}
