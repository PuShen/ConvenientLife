package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.PerpetualCalendar;

import java.util.List;

/**
 * Created by dell on 2016/11/30.
 */

public class PerpetualCalendarAdapter extends BaseAdapter {
    private Context context;
    private List<PerpetualCalendar> perpetualCalendarList;
    public PerpetualCalendarAdapter(Context context,List<PerpetualCalendar> perpetualCalendarList){
        this.context = context;
        this.perpetualCalendarList = perpetualCalendarList;
    }
    @Override
    public int getCount() {
        return perpetualCalendarList.size();
    }

    @Override
    public Object getItem(int position) {
        return perpetualCalendarList.get(position);
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
