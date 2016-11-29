package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.Stationde;

import java.util.List;

/**
 * Created by dell on 2016/11/29.
 */

public class StationdeAdapter extends BaseAdapter{
    private Context context;
    private List<Stationde> stationdeList;
    public StationdeAdapter(Context context,List<Stationde> stationdeList){
        this.context =context;
        this.stationdeList =stationdeList;
    }
    @Override
    public int getCount() {
        return stationdeList.size();
    }

    @Override
    public Object getItem(int position) {
        return stationdeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
