package com.lifeofnothing.wxp.convenientlife.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class NbaList {
    private String title;
    private List<NbaLive> llive;
    private List<NbaLiveLink> llink;
    private List<NbaDetails> ldetails;
    private List<NbaBottomLink> lblink;

    public NbaList() {
    }

    public NbaList(String title, List<NbaLive> llive, List<NbaLiveLink> llink, List<NbaDetails> ldetails, List<NbaBottomLink> lblink) {
        this.title = title;
        this.llive = llive;
        this.llink = llink;
        this.ldetails = ldetails;
        this.lblink = lblink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<NbaLive> getLlive() {
        return llive;
    }

    public void setLlive(List<NbaLive> llive) {
        this.llive = llive;
    }

    public List<NbaDetails> getLdetails() {
        return ldetails;
    }

    public void setLdetails(List<NbaDetails> ldetails) {
        this.ldetails = ldetails;
    }

    public List<NbaLiveLink> getLlink() {
        return llink;
    }

    public void setLlink(List<NbaLiveLink> llink) {
        this.llink = llink;
    }

    public List<NbaBottomLink> getLblink() {
        return lblink;
    }

    public void setLblink(List<NbaBottomLink> lblink) {
        this.lblink = lblink;
    }
}
