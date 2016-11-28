package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/11/28.
 */

public class WeatherAdapter extends BaseAdapter{
    private Context context;
    private List<Weather> weatherList=new ArrayList<>();

    //创建自己的构造方法
    public WeatherAdapter(Context context,List<Weather>weatherList){
        this.context =context;
        this.weatherList=weatherList;
    }
    @Override
    public int getCount() {
        return weatherList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherList.get(position);
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
