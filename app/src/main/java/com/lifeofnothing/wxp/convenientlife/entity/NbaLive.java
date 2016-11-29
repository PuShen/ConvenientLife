package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/11/24.
 */

public class NbaLive {
    private  String liveurl;
    private  String player1;
    private  String player1info;
    private  String player1location;
    private  String player1logo;
    private  String player1logobig;
    private  String player1url;
    private  String player2;
    private  String player2info;
    private  String player2location;
    private  String player2logo;
    private  String player2logobig;
    private  String player2url;
    private  String score;
    private  String status;
    private  String title;

    public NbaLive() {
    }

    public NbaLive(String liveurl, String player1, String player1location, String player1info, String player1logo, String player1logobig, String player1url, String player2, String player2info, String player2location, String player2logo, String player2logobig, String player2url, String score, String status, String title) {
        this.liveurl = liveurl;
        this.player1 = player1;
        this.player1location = player1location;
        this.player1info = player1info;
        this.player1logo = player1logo;
        this.player1logobig = player1logobig;
        this.player1url = player1url;
        this.player2 = player2;
        this.player2info = player2info;
        this.player2location = player2location;
        this.player2logo = player2logo;
        this.player2logobig = player2logobig;
        this.player2url = player2url;
        this.score = score;
        this.status = status;
        this.title = title;
    }

    public String getLiveurl() {
        return liveurl;
    }

    public void setLiveurl(String liveurl) {
        this.liveurl = liveurl;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer1info() {
        return player1info;
    }

    public void setPlayer1info(String player1info) {
        this.player1info = player1info;
    }

    public String getPlayer1location() {
        return player1location;
    }

    public void setPlayer1location(String player1location) {
        this.player1location = player1location;
    }

    public String getPlayer1logo() {
        return player1logo;
    }

    public void setPlayer1logo(String player1logo) {
        this.player1logo = player1logo;
    }

    public String getPlayer1logobig() {
        return player1logobig;
    }

    public void setPlayer1logobig(String player1logobig) {
        this.player1logobig = player1logobig;
    }

    public String getPlayer1url() {
        return player1url;
    }

    public void setPlayer1url(String player1url) {
        this.player1url = player1url;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer2info() {
        return player2info;
    }

    public void setPlayer2info(String player2info) {
        this.player2info = player2info;
    }

    public String getPlayer2location() {
        return player2location;
    }

    public void setPlayer2location(String player2location) {
        this.player2location = player2location;
    }

    public String getPlayer2logo() {
        return player2logo;
    }

    public void setPlayer2logo(String player2logo) {
        this.player2logo = player2logo;
    }

    public String getPlayer2logobig() {
        return player2logobig;
    }

    public void setPlayer2logobig(String player2logobig) {
        this.player2logobig = player2logobig;
    }

    public String getPlayer2url() {
        return player2url;
    }

    public void setPlayer2url(String player2url) {
        this.player2url = player2url;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
