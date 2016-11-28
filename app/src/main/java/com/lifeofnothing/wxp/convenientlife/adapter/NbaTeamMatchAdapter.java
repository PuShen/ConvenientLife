package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.NbaTeamMatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/28.
 */

public class NbaTeamMatchAdapter extends BaseAdapter {
     private Context context;
    private List<NbaTeamMatch> nbaTeamMatchs=new ArrayList<>();
    //创建自己的构造函数
    public NbaTeamMatchAdapter(Context context, ArrayList<NbaTeamMatch> ntms){
        this.context=context;
        this.nbaTeamMatchs=ntms;
    }
    @Override
    public int getCount() {
        return nbaTeamMatchs.size();
    }

    @Override
    public Object getItem(int position) {
        return nbaTeamMatchs.get(position);
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
