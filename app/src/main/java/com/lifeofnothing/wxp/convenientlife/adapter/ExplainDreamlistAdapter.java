package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;

import java.util.List;
import com.lifeofnothing.wxp.convenientlife.entity.ExplainDream;
/**
 * Created by Administrator on 2016/12/15.
 */

public class ExplainDreamlistAdapter extends BaseAdapter{
    private Context context;
    private List<ExplainDream> list;

    public ExplainDreamlistAdapter(Context context, List<ExplainDream> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_explaindream_list,null);
        TextView textView=(TextView)convertView.findViewById(R.id.TvItemExplainDreamlist);
      //  textView.setText(list.get(position).getLs().);
        return convertView;
    }
}
