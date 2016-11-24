package com.lifeofnothing.wxp.convenientlife.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class Nba{
   private List<NbaList> llist=new ArrayList<>();
   private  List<NbaTeamMatch> ltmatch=new ArrayList<>();

    public Nba() {
    }

    public Nba(List<NbaList> llist, List<NbaTeamMatch> ltmatch) {
        this.llist = llist;
        this.ltmatch = ltmatch;
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
}
