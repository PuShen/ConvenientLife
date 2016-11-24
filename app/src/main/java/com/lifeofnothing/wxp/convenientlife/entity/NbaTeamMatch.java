package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by Administrator on 2016/11/24.
 */

public class NbaTeamMatch {
    private String name;
    private String url;

    public NbaTeamMatch() {
    }

    public NbaTeamMatch(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
