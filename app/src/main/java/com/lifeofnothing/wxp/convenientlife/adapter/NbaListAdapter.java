package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.NbaList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/28.
 */

public class NbaListAdapter extends BaseAdapter {
    private Context context;
    private List<NbaList> nbaListList=new ArrayList<>();
    public NbaListAdapter(Context context,ArrayList<NbaList> nll){
        this.context=context;
        this.nbaListList=nll;
    }
    @Override
    public int getCount() {
        return nbaListList.size();
    }

    @Override
    public Object getItem(int position) {
        return nbaListList.get(position);
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
