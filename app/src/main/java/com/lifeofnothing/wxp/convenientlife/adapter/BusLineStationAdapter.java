package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.entity.Stationde;

import java.util.List;

/**
 * Created by dell on 2016/12/13.
 */

public class BusLineStationAdapter extends BaseAdapter{
    private Context context;
    private List<Stationde> busLinesList1;

    //构造方法
    public BusLineStationAdapter (Context context,List<Stationde> busLines){
        this.context =context;
        this.busLinesList1=busLines;
    }
    @Override
    public int getCount() {
        return busLinesList1.size();
    }

    @Override
    public Object getItem(int position) {
        return busLinesList1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_bus_station,null);

        TextView TvItembusstationNum =(TextView)convertView.findViewById(R.id.TvItembusstationNum);
        TvItembusstationNum.setText(busLinesList1.get(position).getStationNum());

        TextView TvItembusstaionStation=(TextView)convertView.findViewById((R.id.TvItembusstaionStation));
        TvItembusstaionStation.setText(busLinesList1.get(position).getName());
        return convertView;

    }
}
