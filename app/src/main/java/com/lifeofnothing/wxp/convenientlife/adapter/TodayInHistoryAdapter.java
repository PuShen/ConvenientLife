package com.lifeofnothing.wxp.convenientlife.adapter;

import android.app.ListActivity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.TodayInHistory;

import java.util.List;

/**
 * Created by dell on 2016/11/28.
 */

public class TodayInHistoryAdapter extends BaseAdapter {
    private Context context;
    private List<TodayInHistory> todayInHistoryList;
    //创建自定义的构建方法
    public TodayInHistoryAdapter(Context context,List<TodayInHistory> todayInHistoryList){
        this.context=context;
        this.todayInHistoryList=todayInHistoryList;
    }
    @Override
    public int getCount() {
        return todayInHistoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return todayInHistoryList.get(position);
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
