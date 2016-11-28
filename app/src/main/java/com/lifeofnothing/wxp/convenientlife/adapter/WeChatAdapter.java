package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.WeChat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/11/28.
 */

public class WeChatAdapter extends BaseAdapter {
    private Context context;
    private List<WeChat> weChatList=new ArrayList<>();
    //创建自己的构建方法
    public WeChatAdapter(Context context,ArrayList<WeChat> weChatList){
        this.context=context;
        this.weChatList=weChatList;
    }
    @Override
    public int getCount() {
        return weChatList.size();
    }

    @Override
    public Object getItem(int position) {
        return weChatList.get(position);
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
