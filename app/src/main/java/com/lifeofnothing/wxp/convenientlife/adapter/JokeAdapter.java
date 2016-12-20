package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.entity.Joke;
import com.lifeofnothing.wxp.convenientlife.http.AsyncImageLoad;
import com.lifeofnothing.wxp.convenientlife.utils.ImageLoaderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/27.
 */

public class JokeAdapter extends BaseAdapter{
    private Context context;
    private List<Joke> jokeList=new ArrayList<>();
    private Button button;
    //创建自己的类
    public JokeAdapter(Context context, List<Joke> jl,Button button){
        this.jokeList=jl;
        this.context=context;
        this.button =button;
    }
    //重写抽象类或接口的抽象方法
    public int getCount() {
        return jokeList.size();
    }

    @Override
    public Object getItem(int position) {
        return jokeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //视图的显示的具体内容
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (button.getId()==R.id.BtnJokeFunny){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_joke_funnypic,null);
            TextView TvFunnyContent =(TextView)convertView.findViewById(R.id.TvFunnyContent);
            TvFunnyContent.setText(jokeList.get(position).getmContent());
            ImageView Ivfunnypic =(ImageView)convertView.findViewById(R.id.Ivfunnypic);
            ImageLoaderUtils.displayImage(jokeList.get(position).getmImageUrl(),Ivfunnypic,context);
        }
        else{
            convertView= LayoutInflater.from(context).inflate(R.layout.item_joke,null);
            TextView TvItemjokeContent =(TextView)convertView.findViewById(R.id. TvItemjokeContent);
            TvItemjokeContent.setText(jokeList.get(position).getmContent());
        }
//        TextView TvItemjokeUpdateTime =(TextView)convertView.findViewById(R.id. TvItemjokeUpdateTime);
//        TvItemjokeUpdateTime.setText(jokeList.get(position).getmUpdatetime());
        return convertView;
    }
}
