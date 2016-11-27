package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.entity.Joke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/27.
 */

public class JokeAdapter extends BaseAdapter{
    private Context context;
    private List<Joke> jokeList=new ArrayList<>();
    //创建自己的类
    public JokeAdapter(Context context,ArrayList<Joke> jl){
        this.jokeList=jl;
        this.context=context;
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
        return convertView;
    }
}
