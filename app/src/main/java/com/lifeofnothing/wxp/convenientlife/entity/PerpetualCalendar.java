package com.lifeofnothing.wxp.convenientlife.entity;


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
    private String mSuit;         //宜
    private String mHoliday;      //节日

    public PerpetualCalendar(String mAnimalsYear, String mWeekday, String mLunarYear, String mLunar, String mYearMonth, String mDate, String mAvoid, String mSuit, String mHoliday) {
        this.mAnimalsYear = mAnimalsYear;
        this.mWeekday = mWeekday;
        this.mLunarYear = mLunarYear;
        this.mLunar = mLunar;
        this.mYearMonth = mYearMonth;
        this.mDate = mDate;
        this.mAvoid = mAvoid;
        this.mSuit = mSuit;
        this.mHoliday = mHoliday;
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

    public String getmSuit() {
        return mSuit;
    }

    public PerpetualCalendar setmSuit(String mSuit) {
        this.mSuit = mSuit;
        return this;
    }

    public String getmHoliday() {
        return mHoliday;
    }

    public PerpetualCalendar setmHoliday(String mHoliday) {
        this.mHoliday = mHoliday;
        return this;
    }

    public String getmAvoid() {
        return mAvoid;
    }

    public PerpetualCalendar setmAvoid(String mAvoid) {
        this.mAvoid = mAvoid;
        return  this;
    }

    @Override
    public String toString() {
        return "PerpetualCalendar{" +
                "mAnimalsYear='" + mAnimalsYear + '\'' +
                ", mWeekday='" + mWeekday + '\'' +
                ", mLunarYear='" + mLunarYear + '\'' +
                ", mLunar='" + mLunar + '\'' +
                ", mYearMonth='" + mYearMonth + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mAvoid='" + mAvoid + '\'' +
                ", mSuit='" + mSuit + '\'' +
                ", mHoliday='" + mHoliday + '\'' +
                '}';
    }
}
