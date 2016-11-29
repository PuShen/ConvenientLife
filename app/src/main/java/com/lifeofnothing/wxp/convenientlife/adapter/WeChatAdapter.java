package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.WeChat;
import com.lifeofnothing.wxp.convenientlife.http.AsyncImageLoad;

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
        if(null==convertView) {
            if (position % 6 == 0){
                convertView = LayoutInflater.from(context).inflate(R.layout.item_wechat_big, null);
                TextView TvItemwechatTitle = (TextView) convertView.findViewById(R.id.TvItemwechatTitle);
                TvItemwechatTitle.setText(weChatList.get(position).getTitle());
                TextView TvItemwechatAuthor = (TextView) convertView.findViewById(R.id.TvItemwechatAuthor);
                TvItemwechatAuthor.setText(weChatList.get(position).getSource());
                ImageView IvItemwechatHead = (ImageView) convertView.findViewById(R.id.IvItemwechatHead);
                AsyncImageLoad imageLoad = new AsyncImageLoad
                    (weChatList.get(position).getFirstImg(), IvItemwechatHead);
                imageLoad.execute();
            }else{
                 convertView = LayoutInflater.from(context).inflate(R.layout.item_wechat, null);
                 TextView TvItemwechatbigTitle=(TextView)convertView.findViewById(R.id. TvItemwechatbigTitle);
                 TvItemwechatbigTitle.setText(weChatList.get(position).getTitle());
                 TextView TvItemwechatbigAuthor=(TextView)convertView.findViewById(R.id. TvItemwechatbigAuthor);
                 TvItemwechatbigAuthor.setText(weChatList.get(position).getSource());
                 ImageView IvItemwechatbigHead=(ImageView)convertView.findViewById(R.id.IvItemwechatbigHead);
                 AsyncImageLoad imageBigLoad = new AsyncImageLoad
                    (weChatList.get(position).getFirstImg(), IvItemwechatbigHead);
                 imageBigLoad.execute();
            }
        }
        return convertView;
    }
}
