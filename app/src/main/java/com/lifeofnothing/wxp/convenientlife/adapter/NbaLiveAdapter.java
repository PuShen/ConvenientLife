package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.NbaLive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/28.
 */

public class NbaLiveAdapter extends BaseAdapter {
    private Context context;
    private List<NbaLive> nbaLiveList=new ArrayList<>();
    public NbaLiveAdapter(Context context,ArrayList<NbaLive> nbaLive){
        this.context=context;
        this.nbaLiveList=nbaLive;
    }
    @Override
    public int getCount() {
        return nbaLiveList.size();
    }

    @Override
    public Object getItem(int position) {
        return nbaLiveList.get(position);
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
