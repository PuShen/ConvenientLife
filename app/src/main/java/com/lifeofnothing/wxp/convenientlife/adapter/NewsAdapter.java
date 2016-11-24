package com.lifeofnothing.wxp.convenientlife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.News;
import com.lifeofnothing.wxp.convenientlife.http.AsyncImageLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘超 on 2016/11/24.
 */

    public class NewsAdapter extends BaseAdapter {
        private Context context;
        private List<News> newslist = new ArrayList<>();

        //自己的构造方法
        public NewsAdapter(Context context, ArrayList<News> nl) {
            this.context = context;
            this.newslist = nl;
        }


        //重写抽象类或接口的抽象方法
        @Override
        public int getCount() {
            return newslist.size();
        }

        @Override
        public Object getItem(int position) {
            return newslist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        //视图的显示的具体内容
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView TvItemnewsTitle =(TextView)convertView.findViewById(R.id. TvItemnewsTitle);
            TvItemnewsTitle.setText(newslist.get(position).getmTitle());
            TextView TvItemnewsAuthor =(TextView)convertView.findViewById(R.id. TvItemnewsAuthor);
            TvItemnewsAuthor.setText(newslist.get(position).getmAuthor());
            TextView TvItemnewsTime =(TextView)convertView.findViewById(R.id. TvItemnewsTime);
            TvItemnewsTime.setText(newslist.get(position).getmDate());
            ImageView IvItemnewsHead=(ImageView)convertView.findViewById(R.id.IvItemnewsHead);
            AsyncImageLoad imageLoad=new AsyncImageLoad
                    (newslist.get(position).getmImage(),IvItemnewsHead);
            imageLoad.execute();
            return convertView;
        }
}
