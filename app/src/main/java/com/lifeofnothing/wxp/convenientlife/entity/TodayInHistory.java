package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by dell on 2016/11/24.
 */

public class TodayInHistory {
    private String mId;     //哪一年
    private String mTitle;  //标题
    private String mPic;    //图片
    private String mYear;   //年份
    private String mMonth;  //月份
    private String mDay;    //天
    private String mDes;    //事件
    private String mLunar;  //阴历

    public TodayInHistory(String mId, String mTitle, String mPic, String mYear, String mMonth, String mDay, String mDes, String mLunar) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mPic = mPic;
        this.mYear = mYear;
        this.mMonth = mMonth;
        this.mDay = mDay;
        this.mDes = mDes;
        this.mLunar = mLunar;
    }

    public String getmId() {
        return mId;
    }

    public TodayInHistory setmId(String mId) {
        this.mId = mId;
        return this;
    }

    public String getmTitle() {
        return mTitle;
    }

    public TodayInHistory setmTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public String getmPic() {
        return mPic;
    }

    public TodayInHistory setmPic(String mPic) {
        this.mPic = mPic;
        return this;
    }

    public String getmYear() {
        return mYear;
    }

    public TodayInHistory setmYear(String mYear) {
        this.mYear = mYear;
        return this;
    }

    public String getmMonth() {
        return mMonth;
    }

    public TodayInHistory setmMonth(String mMonth) {
        this.mMonth = mMonth;
        return this;
    }

    public String getmDay() {
        return mDay;
    }

    public TodayInHistory setmDay(String mDay) {
        this.mDay = mDay;
        return this;
    }

    public String getmDes() {
        return mDes;
    }

    public TodayInHistory setmDes(String mDes) {
        this.mDes = mDes;
        return this;
    }

    public String getmLunar() {
        return mLunar;
    }

    public TodayInHistory setmLunar(String mLunar) {
        this.mLunar = mLunar;
        return this;
    }
}
