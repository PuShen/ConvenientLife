package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.Nba;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/25.
 */

public class NbaAdapter extends BaseAdapter {
    private Context context;
    private List<Nba>nbaList=new ArrayList<>();
    //构造自己的方法
    public NbaAdapter(Context context,ArrayList<Nba> nl){
        this.context=context;
        this.nbaList=nl;
    }
    @Override
    public int getCount() {
        return nbaList.size();
    }

    @Override
    public Object getItem(int position) {
        return nbaList.get(position);
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
