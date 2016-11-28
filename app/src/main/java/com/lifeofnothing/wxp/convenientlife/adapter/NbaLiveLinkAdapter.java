package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.NbaLive;
import com.lifeofnothing.wxp.convenientlife.entity.NbaLiveLink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/28.
 */

public class NbaLiveLinkAdapter extends BaseAdapter {
     private Context context;
     private List<NbaLiveLink> nbaLiveLinks=new ArrayList<>();
    //自己的构造函数
    public NbaLiveLinkAdapter(Context context, ArrayList<NbaLiveLink> nlls){
        this.context=context;
        this.nbaLiveLinks=nlls;
    }
    @Override
    public int getCount() {
        return nbaLiveLinks.size();
    }

    @Override
    public Object getItem(int position) {
        return nbaLiveLinks.get(position);
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
