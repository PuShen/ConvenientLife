package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;

import java.util.List;

/**
 * Created by dell on 2016/11/25.
 * 修改日期2016/12/12 by 陈熙
 */

public class BusLineAdapter extends BaseAdapter{
    private Context context;
    private List<BusLine> busLinesList;
    //创建自己的构造方法
    public BusLineAdapter (Context context,List<BusLine> busLines){
        this.context =context;
        this.busLinesList=busLines;
    }
    //重写抽象类或接口的抽象方法
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_bus,null);

        TextView TvItembusName =(TextView)convertView.findViewById(R.id.TvItembusName);
        TvItembusName.setText(busLinesList.get(position).getKey_name());

        TextView TvItembusFront =(TextView)convertView.findViewById(R.id.TvItembusFront);
        TvItembusFront.setText(busLinesList.get(position).getFront_name());

        TextView TvItembusTerminal =(TextView)convertView.findViewById(R.id.TvItembusTerminal);
        TvItembusTerminal.setText(busLinesList.get(position).getTerminal_name());

        TextView TvItembusType =(TextView)convertView.findViewById(R.id.TvItembusType);
        TvItembusType.setText(busLinesList.get(position).getType());

        TextView TvItembusStarttime =(TextView)convertView.findViewById(R.id.TvItembusStarttime);
        TvItembusStarttime.setText(busLinesList.get(position).getStart_time());

        TextView TvItembusEndtime =(TextView)convertView.findViewById(R.id.TvItembusEndtime);
        TvItembusEndtime.setText(busLinesList.get(position).getEnd_time());

        TextView TvItembusPrice =(TextView)convertView.findViewById(R.id.TvItembusPrice);
        TvItembusPrice.setText(busLinesList.get(position).getTotal_price());
        return convertView;
    }
}
