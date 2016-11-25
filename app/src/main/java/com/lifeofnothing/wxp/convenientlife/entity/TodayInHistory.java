package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by dell on 2016/11/24.
 */

public class TodayInHistory {
    private String mId;
    private String mTitle;
    private String mPic;
    private String mYear;
    private String mMonth;
    private String mDay;
    private String mDes;
    private String mLunar;

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

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPic() {
        return mPic;
    }

    public void setmPic(String mPic) {
        this.mPic = mPic;
    }

    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear;
    }

    public String getmMonth() {
        return mMonth;
    }

    public void setmMonth(String mMonth) {
        this.mMonth = mMonth;
    }

    public String getmDay() {
        return mDay;
    }

    public void setmDay(String mDay) {
        this.mDay = mDay;
    }

    public String getmDes() {
        return mDes;
    }

    public void setmDes(String mDes) {
        this.mDes = mDes;
    }

    public String getmLunar() {
        return mLunar;
    }

    public void setmLunar(String mLunar) {
        this.mLunar = mLunar;
    }
}