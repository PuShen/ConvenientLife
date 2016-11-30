package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.WeChat;
import com.lifeofnothing.wxp.convenientlife.http.AsyncImageLoad;
import com.lifeofnothing.wxp.convenientlife.http.BackgroundLoadTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by dell on 2016/11/28.
 */

public class WeChatAdapter extends BaseAdapter {
    private Context context;
    private List<WeChat> weChatList;
    //创建自己的构建方法
    public WeChatAdapter(Context context,List<WeChat> weChatList){
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
            if (position % 6 == 0){
                convertView = LayoutInflater.from(context).inflate(R.layout.item_wechat_big, null);
                TextView TvItemwechatbigTitle=(TextView)convertView.findViewById(R.id. TvItemwechatbigTitle);
                TvItemwechatbigTitle.setText(weChatList.get(position).getTitle());
                TextView TvItemwechatbigAuthor=(TextView)convertView.findViewById(R.id. TvItemwechatbigAuthor);
                TvItemwechatbigAuthor.setText(weChatList.get(position).getSource());
                ImageView IvItemwechatbigHead=(ImageView)convertView.findViewById(R.id.IvItemwechatbigHead);
                BackgroundLoadTask task=new BackgroundLoadTask(IvItemwechatbigHead);
                try {
                    task.execute(new URL(weChatList.get(position).getFirstImg()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else{
                convertView = LayoutInflater.from(context).inflate(R.layout.item_wechat, null);
                TextView TvItemwechatTitle = (TextView) convertView.findViewById(R.id.TvItemwechatTitle);
                Log.e("list",weChatList.size()+"");
                TvItemwechatTitle.setText(weChatList.get(position).getTitle());
                TextView TvItemwechatAuthor = (TextView) convertView.findViewById(R.id.TvItemwechatAuthor);
                TvItemwechatAuthor.setText(weChatList.get(position).getSource());
                ImageView IvItemwechatHead = (ImageView) convertView.findViewById(R.id.IvItemwechatHead);
                BackgroundLoadTask task=new BackgroundLoadTask(IvItemwechatHead);
                try {
                    task.execute(new URL(weChatList.get(position).getFirstImg()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        return convertView;
    }
}
