package com.lifeofnothing.wxp.convenientlife.entity;

import android.util.MonthDisplayHelper;

/**
 * Created by dell on 2016/11/24.
 */

public class PerpetualCalendar {
    private  String mAnimalsYear;
    private  String mWeekday;
    private  String mLunarYear;
    private  String mLunar;
    private  String mYearMonth;
    private  String mDate;

    public PerpetualCalendar(String mAnimalsYear, String mWeekday, String mLunarYear, String mLunar, String mYearMonth, String mDate) {
        this.mAnimalsYear = mAnimalsYear;
        this.mWeekday = mWeekday;
        this.mLunarYear = mLunarYear;
        this.mLunar = mLunar;
        this.mYearMonth = mYearMonth;
        this.mDate = mDate;
    }

    public String getmAnimalsYear() {
        return mAnimalsYear;
    }

    public void setmAnimalsYear(String mAnimalsYear) {
        this.mAnimalsYear = mAnimalsYear;
    }

    public String getmWeekday() {
        return mWeekday;
    }

    public void setmWeekday(String mWeekday) {
        this.mWeekday = mWeekday;
    }

    public String getmLunarYear() {
        return mLunarYear;
    }

    public void setmLunarYear(String mLunarYear) {
        this.mLunarYear = mLunarYear;
    }

    public String getmLunar() {
        return mLunar;
    }

    public void setmLunar(String mLunar) {
        this.mLunar = mLunar;
    }

    public String getmYearMonth() {
        return mYearMonth;
    }

    public void setmYearMonth(String mYearMonth) {
        this.mYearMonth = mYearMonth;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
