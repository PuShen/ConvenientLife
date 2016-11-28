package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.LeagueFootballMatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/28.
 */

public class LeagueFootballMatchAdapter extends BaseAdapter{
        private Context context;
        private List<LeagueFootballMatch> lfmalist =new ArrayList<>();
        public  LeagueFootballMatchAdapter(Context context,ArrayList<LeagueFootballMatch> lfmalist){
            this.context=context;
            this.lfmalist=lfmalist;
        }
        @Override
        public int getCount() {
            return lfmalist.size();
        }

        @Override
        public Object getItem(int position) {
            return lfmalist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return convertView;
        }
    }

