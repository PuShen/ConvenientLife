package com.lifeofnothing.wxp.convenientlife.entity;

import java.util.List;

/**
 * Created by dell on 2016/11/24.
 */

public class LeagueFootballMatch {
    private String mSaiCheng1; //赛程1
    private String mSaiCheng2; //赛程2
    private String mSaiCheng3; //赛程3
    private String mJiFenBang; //积分榜
    private String mC1;  // 是否结束
    private String mC2;  //日期
    private String mC3;  //时间
    private String mC4T1;//队名
    private String mC4T1Url;//网址
    private String mC4R;    //比分
    private String mC4T2;   //队名
    private String mC4T2Url;//网址
    private String mC51;    //统计
    private String mC51Link;//网址
    private String mC52;    //图文书数据
    private String mC52Link;//网址
    private String mLived;  //编号

    public LeagueFootballMatch(String mSaiCheng1, String mSaiCheng2, String mSaiCheng3, String mJiFenBang, String mC1, String mC2, String mC3, String mC4T1, String mC4T1Url, String mC4R, String mC4T2, String mC4T2Url, String mC51, String mC51Link, String mC52, String mC52Link, String mLived) {
        this.mSaiCheng1 = mSaiCheng1;
        this.mSaiCheng2 = mSaiCheng2;
        this.mSaiCheng3 = mSaiCheng3;
        this.mJiFenBang = mJiFenBang;
        this.mC1 = mC1;
        this.mC2 = mC2;
        this.mC3 = mC3;
        this.mC4T1 = mC4T1;
        this.mC4T1Url = mC4T1Url;
        this.mC4R = mC4R;
        this.mC4T2 = mC4T2;
        this.mC4T2Url = mC4T2Url;
        this.mC51 = mC51;
        this.mC51Link = mC51Link;
        this.mC52 = mC52;
        this.mC52Link = mC52Link;
        this.mLived = mLived;
    }

    public String getmSaiCheng1() {
        return mSaiCheng1;
    }

    public LeagueFootballMatch setmSaiCheng1(String mSaiCheng1) {
        this.mSaiCheng1 = mSaiCheng1;
        return this;
    }

    public String getmSaiCheng2() {
        return mSaiCheng2;
    }

    public LeagueFootballMatch setmSaiCheng2(String mSaiCheng2) {
        this.mSaiCheng2 = mSaiCheng2;
        return this;
    }

    public String getmSaiCheng3() {
        return mSaiCheng3;
    }

    public LeagueFootballMatch setmSaiCheng3(String mSaiCheng3) {
        this.mSaiCheng3 = mSaiCheng3;
        return this;
    }

    public String getmJiFenBang() {
        return mJiFenBang;
    }

    public LeagueFootballMatch setmJiFenBang(String mJiFenBang) {
        this.mJiFenBang = mJiFenBang;
        return this;
    }

    public String getmC1() {
        return mC1;
    }

    public LeagueFootballMatch setmC1(String mC1) {
        this.mC1 = mC1;
        return this;
    }

    public String getmC2() {
        return mC2;
    }

    public LeagueFootballMatch setmC2(String mC2) {
        this.mC2 = mC2;
        return this;
    }

    public String getmC3() {
        return mC3;
    }

    public LeagueFootballMatch setmC3(String mC3) {
        this.mC3 = mC3;
        return this;
    }

    public String getmC4T1() {
        return mC4T1;
    }

    public LeagueFootballMatch setmC4T1(String mC4T1) {
        this.mC4T1 = mC4T1;
        return this;
    }

    public String getmC4T1Url() {
        return mC4T1Url;
    }

    public LeagueFootballMatch setmC4T1Url(String mC4T1Url) {
        this.mC4T1Url = mC4T1Url;
        return this;
    }

    public String getmC4R() {
        return mC4R;
    }

    public LeagueFootballMatch setmC4R(String mC4R) {
        this.mC4R = mC4R;
        return this;
    }

    public String getmC4T2() {
        return mC4T2;
    }

    public LeagueFootballMatch setmC4T2(String mC4T2) {
        this.mC4T2 = mC4T2;
        return this;
    }

    public String getmC4T2Url() {
        return mC4T2Url;
    }

    public LeagueFootballMatch setmC4T2Url(String mC4T2Url) {
        this.mC4T2Url = mC4T2Url;
        return this;
    }

    public String getmC51() {
        return mC51;
    }

    public LeagueFootballMatch setmC51(String mC51) {
        this.mC51 = mC51;
        return this;
    }

    public String getmC51Link() {
        return mC51Link;
    }

    public LeagueFootballMatch setmC51Link(String mC51Link) {
        this.mC51Link = mC51Link;
        return this;
    }

    public String getmC52() {
        return mC52;
    }

    public LeagueFootballMatch setmC52(String mC52) {
        this.mC52 = mC52;
        return this;
    }

    public String getmC52Link() {
        return mC52Link;
    }

    public LeagueFootballMatch setmC52Link(String mC52Link) {
        this.mC52Link = mC52Link;
        return this;
    }

    public String getmLived() {
        return mLived;
    }

    public LeagueFootballMatch setmLived(String mLived) {
        this.mLived = mLived;
        return this;
    }
}
