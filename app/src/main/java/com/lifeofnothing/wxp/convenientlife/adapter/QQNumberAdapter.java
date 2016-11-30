package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.text.NoCopySpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.QQNumber;

import java.util.List;

/**
 * Created by dell on 2016/11/30.
 */

public class QQNumberAdapter extends BaseAdapter {
    private Context context;
    private List<QQNumber> qqNumberList;
    public QQNumberAdapter(Context context,List<QQNumber> qqNumberList){
        this.context = context;
        this.qqNumberList = qqNumberList;
    }
    @Override
    public int getCount() {
        return qqNumberList.size();
    }

    @Override
    public Object getItem(int position) {
        return qqNumberList.get(position);
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
