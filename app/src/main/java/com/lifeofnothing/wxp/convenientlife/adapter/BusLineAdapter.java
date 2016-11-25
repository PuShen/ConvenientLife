package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.entity.Nba;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/11/25.
 */

public class BusLineAdapter extends BaseAdapter{
    private Context context;
    private List<BusLine> busLinesList=new ArrayList<>();
    //创建自己的构造方法
    public BusLineAdapter (Context context,ArrayList<BusLine> busLines){
        this.context =context;
        this.busLinesList=busLines;
    }
    @Override
    public int getCount() {
        return busLinesList.size();
    }

    @Override
    public Object getItem(int position) {
        return busLinesList.get(position);
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
