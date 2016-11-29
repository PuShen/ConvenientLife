package com.lifeofnothing.wxp.convenientlife.prasor;

import com.lifeofnothing.wxp.convenientlife.entity.Nba;
import com.lifeofnothing.wxp.convenientlife.entity.NbaBottomLink;
import com.lifeofnothing.wxp.convenientlife.entity.NbaDetails;
import com.lifeofnothing.wxp.convenientlife.entity.NbaList;
import com.lifeofnothing.wxp.convenientlife.entity.NbaLive;
import com.lifeofnothing.wxp.convenientlife.entity.NbaLiveLink;
import com.lifeofnothing.wxp.convenientlife.entity.NbaTeamMatch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/11/23.
 */

public class NBAParser {
    //源Json串
    private String mSource = null;

    public NBAParser(String source) {
        this.mSource = source;
    }

    public Nba parse() {
        //用于保存服务器返回的数据
        Nba nba = null;

        //获取服务器返回的状态
        int errorCode = -1;
        try {
            if (mSource != null) {
                JSONObject jsonObject = new JSONObject(mSource);
                errorCode = jsonObject.getInt("error_code");

                //检查服务器返回的状态,若成功则开始数据解析
                if (0 == errorCode) {
                    //开始解析
                    nba =
                            startParse(jsonObject.getJSONObject("result"));
                } else {
                    //否则赋值为null
                    nba = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return nba;
    }

    private Nba startParse(JSONObject result) {
        //开始解析主要数据
        Nba nba = new Nba();
        try {
            String title = result.getString("title");
            nba.setTitle(title);
            JSONObject statuslist = result.getJSONObject("statuslist");
            String st0 = statuslist.getString("st0");
            String st1 = statuslist.getString("st1");
            String st2 = statuslist.getString("st2");
            final String[] status = new String[]{st0, st1, st2};

            List<NbaList> nbaDailies = new ArrayList<NbaList>();
            JSONArray list = result.getJSONArray("list");
            for (int i = 0; i < list.length(); i++) {
                JSONObject nbaDailyJSONobj = list.getJSONObject(i);
                NbaList nbaDaily = new NbaList();

                String nbaDailyTitle = nbaDailyJSONobj.getString("title");
                nbaDaily.setTitle(nbaDailyTitle);

                JSONArray tr = nbaDailyJSONobj.getJSONArray("tr");
                List<NbaDetails> nbaDetails = new ArrayList<NbaDetails>();
                for (int j = 0; j < tr.length(); j++) {
                    JSONObject nbaDetailJSONObj = tr.getJSONObject(j);
                    NbaDetails nbaDetail = new NbaDetails();

                    String link1text = nbaDetailJSONObj.getString("link1text");
                    nbaDetail.setLink1text(link1text);
                    String link1url = nbaDetailJSONObj.getString("link1url");
                    link1url = UrlFixer.fix(link1url);
                    nbaDetail.setLink1url(link1url);
                    String link2text = nbaDetailJSONObj.getString("link2text");
                    nbaDetail.setLink2text(link2text);
                    String link2url = nbaDetailJSONObj.getString("link2url");
                    link2url = UrlFixer.fix(link2url);
                    nbaDetail.setLink2url(link2url);
                    String player1 = nbaDetailJSONObj.getString("player1");
                    nbaDetail.setPlayer1(player1);
                    String player1logo = nbaDetailJSONObj.getString("player1logo");
                    player1logo = UrlFixer.fix(player1logo);
                    nbaDetail.setPlayer1logo(player1logo);
                    String player1logobig = nbaDetailJSONObj.getString("player1logobig");
                    player1logobig = UrlFixer.fix(player1logobig);
                    nbaDetail.setPlayer1logobig(player1logobig);
                    String player1url = nbaDetailJSONObj.getString("player1url");
                    player1url = UrlFixer.fix(player1url);
                    nbaDetail.setPlayer1url(player1url);
                    String player2 = nbaDetailJSONObj.getString("player2");
                    nbaDetail.setPlayer2(player2);
                    String player2logo = nbaDetailJSONObj.getString("player2logo");
                    player2logo = UrlFixer.fix(player2logo);
                    nbaDetail.setPlayer2logo(player2logo);
                    String player2logobig = nbaDetailJSONObj.getString("player2logobig");
                    player2logobig = UrlFixer.fix(player2logobig);
                    nbaDetail.setPlayer2logobig(player2logobig);
                    String player2url = nbaDetailJSONObj.getString("player2url");
                    player2url = UrlFixer.fix(player2url);
                    nbaDetail.setPlayer2url(player2url);
                    String m_link1url = nbaDetailJSONObj.getString("m_link1url");
                    m_link1url = UrlFixer.fix(m_link1url);
                    nbaDetail.setM_link1url(m_link1url);
                    String m_link2url = nbaDetailJSONObj.getString("m_link2url");
                    m_link2url = UrlFixer.fix(m_link2url);
                    nbaDetail.setM_link2url(m_link2url);
                    String score = nbaDetailJSONObj.getString("score");
                    nbaDetail.setScore(score);
                    int st = nbaDetailJSONObj.getInt("status");
                    String stString = null;
                    switch (st) {
                        case 0:
                            stString = status[0];
                            break;
                        case 1:
                            stString = status[1];
                            break;
                        case 2:
                            stString = status[2];
                            break;
                    }
                    nbaDetail.setStatus(stString);
                    String time = nbaDetailJSONObj.getString("time");
                    nbaDetail.setTime(time);

                    nbaDetails.add(nbaDetail);
                }
                nbaDaily.setLdetails(nbaDetails);


                List<NbaBottomLink> bottomLinks = new ArrayList<NbaBottomLink>();
                JSONArray bottomLinksJSONArray = nbaDailyJSONobj.getJSONArray("bottomlink");

                for (int j = 0; j < bottomLinksJSONArray.length(); j++) {
                    JSONObject bottomLinkJSONObj = bottomLinksJSONArray.getJSONObject(j);
                    NbaBottomLink bottomLink = new NbaBottomLink();

                    String text = bottomLinkJSONObj.getString("text");
                    bottomLink.setText(text);
                    String url = bottomLinkJSONObj.getString("url");
                    url = UrlFixer.fix(url);
                    bottomLink.setUrl(url);

                    bottomLinks.add(bottomLink);
                }
                nbaDaily.setLblink(bottomLinks);

                if (i == 1) { //服务器共返回三日数据, 其中仅中间一日(今日)具有直播信息
                    List<NbaLive> nbaLives = new ArrayList<NbaLive>();
                    JSONArray livesJSONArray = nbaDailyJSONobj.getJSONArray("live");

                    for (int j = 0; j < livesJSONArray.length(); j++) {
                        JSONObject liveJSONObj = livesJSONArray.getJSONObject(j);
                        NbaLive live = new NbaLive();

                        String liveTitle = liveJSONObj.getString("title");
                        live.setTitle(liveTitle);
                        String player1 = liveJSONObj.getString("player1");
                        live.setPlayer1(player1);
                        String player2 = liveJSONObj.getString("player2");
                        live.setPlayer2(player2);
                        String player1info = liveJSONObj.getString("player1info");
                        live.setPlayer1info(player1info);
                        String player2info = liveJSONObj.getString("player2info");
                        live.setPlayer2info(player2info);
                        String player1logobig = liveJSONObj.getString("player1logobig");
                        player1logobig = UrlFixer.fix(player1logobig);
                        live.setPlayer1logobig(player1logobig);
                        String player2logobig = liveJSONObj.getString("player2logobig");
                        player2logobig = UrlFixer.fix(player2logobig);
                        live.setPlayer2logobig(player2logobig);
                        String player1url = liveJSONObj.getString("player1url");
                        player1url = UrlFixer.fix(player1url);
                        live.setPlayer1url(player1url);
                        String player2url = liveJSONObj.getString("player2url");
                        player2url = UrlFixer.fix(player2url);
                        live.setPlayer2url(player2url);
                        String player1location = liveJSONObj.getString("player1location");
                        live.setPlayer1location(player1location);
                        String player2location = liveJSONObj.getString("player2location");
                        live.setPlayer2location(player2location);
                        int st = liveJSONObj.getInt("status");
                        String stString = null;
                        switch (st) {
                            case 0:
                                stString = status[0];
                                break;
                            case 1:
                                stString = status[1];
                                break;
                            case 2:
                                stString = status[2];
                                break;
                        }
                        live.setStatus(stString);
                        String score = liveJSONObj.getString("score");
                        live.setScore(score);
                        String liveurl = liveJSONObj.getString("liveurl");
                        liveurl = UrlFixer.fix(liveurl);
                        live.setLiveurl(liveurl);
                    }
                    nbaDaily.setLlive(nbaLives);

                    List<NbaLiveLink> liveLinks = new ArrayList<NbaLiveLink>();
                    JSONArray liveLinksJSONArray = nbaDailyJSONobj.getJSONArray("livelink");

                    for (int j = 0; j < liveLinksJSONArray.length(); j++) {
                        JSONObject liveLinkJSONObj = liveLinksJSONArray.getJSONObject(j);
                        NbaLiveLink liveLink = new NbaLiveLink();

                        String text = liveLinkJSONObj.getString("text");
                        liveLink.setText(text);
                        String url = liveLinkJSONObj.getString("url");
                        url = UrlFixer.fix(url);
                        liveLink.setUrl(url);

                        liveLinks.add(liveLink);
                    }
                    nbaDaily.setLlink(liveLinks);
                }

                nbaDailies.add(nbaDaily);
            }
            nba.setLlist(nbaDailies);

            JSONArray teammatchesJSONArray = result.getJSONArray("teammatch");
            List<NbaTeamMatch> teamMatches = new ArrayList<NbaTeamMatch>();

            for (int i = 0; i < teammatchesJSONArray.length(); i++) {
                NbaTeamMatch teamMatch = new NbaTeamMatch();
                JSONObject teamMatchJSONObj = teammatchesJSONArray.getJSONObject(i);
                String name = teamMatchJSONObj.getString("name");
                teamMatch.setName(name);
                String url = teamMatchJSONObj.getString("url");
                url = UrlFixer.fix(url);
                teamMatch.setUrl(url);

                teamMatches.add(teamMatch);
            }
            nba.setLtmatch(teamMatches);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return nba;
    }

}
