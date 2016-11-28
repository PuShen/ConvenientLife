package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.LWeather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/28.
 */

public class LWeatherAdapter extends BaseAdapter {
    private Context context;
    private List<LWeather> lWeatherList=new ArrayList<>();
    //创建自己的构造函数
    public LWeatherAdapter(Context context,ArrayList<LWeather> lw){
         this.context=context;
         this.lWeatherList=lw;
    }
    @Override
    public int getCount() {
        return lWeatherList.size();
    }

    @Override
    public Object getItem(int position) {
        return lWeatherList.get(position);
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
