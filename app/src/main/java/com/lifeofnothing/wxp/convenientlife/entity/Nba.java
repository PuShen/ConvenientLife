package com.lifeofnothing.wxp.convenientlife.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class Nba{
   private  String title;
   private List<NbaList> llist;
   private  List<NbaTeamMatch> ltmatch;

    public Nba() {
    }

    public Nba(List<NbaList> llist, List<NbaTeamMatch> ltmatch, String title) {
        this.llist = llist;
        this.ltmatch = ltmatch;
        this.title=title;
    }

    public List<NbaList> getLlist() {
        return llist;
    }

    public void setLlist(List<NbaList> llist) {
        this.llist = llist;
    }

    public List<NbaTeamMatch> getLtmatch() {
        return ltmatch;
    }

    public void setLtmatch(List<NbaTeamMatch> ltmatch) {
        this.ltmatch = ltmatch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
