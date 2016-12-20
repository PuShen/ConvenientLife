package com.lifeofnothing.wxp.convenientlife.entity;

import java.io.Serializable;

/**
 * Created by dell on 2016/11/24.
 */

public class Joke implements Serializable {
    private String mContent;  //内容
    private String mHashId;  //哈希码
    private String mUnixtime;   //指定时间
    private String mImageUrl;  //图片网址

    public Joke(String mContent) {
        this.mContent = mContent;
    }

    public Joke(String mContent,String mImageUrl) {
        this.mContent = mContent;
        this.mImageUrl = mImageUrl;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }


    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    //    public String getmUpdatetime() {
//        return mUpdatetime;
//    }
//
//    public void setmUpdatetime(String mUpdatetime) {
//        this.mUpdatetime = mUpdatetime;
//    }
}
