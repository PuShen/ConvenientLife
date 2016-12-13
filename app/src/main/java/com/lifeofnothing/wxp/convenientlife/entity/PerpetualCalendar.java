package com.lifeofnothing.wxp.convenientlife.entity;

import android.util.MonthDisplayHelper;

/**
 * Created by dell on 2016/11/24.
 */

public class PerpetualCalendar {
    private  String mAnimalsYear; //天干地支
    private  String mWeekday;     //星期
    private  String mLunarYear;   //阴历年
    private  String mLunar;       //阴历
    private  String mYearMonth;   //年月
    private  String mDate;        //日期
    private  String mAvoid;       //忌
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

    public PerpetualCalendar setmAnimalsYear(String mAnimalsYear) {
        this.mAnimalsYear = mAnimalsYear;
        return this;
    }

    public String getmWeekday() {
        return mWeekday;
    }

    public PerpetualCalendar setmWeekday(String mWeekday) {
        this.mWeekday = mWeekday;
        return this;
    }

    public String getmLunarYear() {
        return mLunarYear;
    }

    public PerpetualCalendar setmLunarYear(String mLunarYear) {
        this.mLunarYear = mLunarYear;
        return this;
    }

    public String getmLunar() {
        return mLunar;
    }

    public PerpetualCalendar setmLunar(String mLunar) {
        this.mLunar = mLunar;
        return this;
    }

    public String getmYearMonth() {
        return mYearMonth;
    }

    public PerpetualCalendar setmYearMonth(String mYearMonth) {
        this.mYearMonth = mYearMonth;
        return this;
    }

    public String getmDate() {
        return mDate;
    }

    public PerpetualCalendar setmDate(String mDate) {
        this.mDate = mDate;
        return this;
    }
}
