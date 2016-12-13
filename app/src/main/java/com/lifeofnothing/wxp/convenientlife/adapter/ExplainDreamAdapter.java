package com.lifeofnothing.wxp.convenientlife.adapter;
import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.ExplainDream;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class ExplainDreamAdapter extends BaseAdapter {
    private Context context;
    private List<ExplainDream> ExplainDreamlist;

    public ExplainDreamAdapter(Context context, List<ExplainDream> ExplainDreamlist) {
        this.context = context;
        this.ExplainDreamlist = ExplainDreamlist;
    }

    @Override
    public int getCount() {
        return ExplainDreamlist.size();
    }

    @Override
    public Object getItem(int position) {
        return ExplainDreamlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.item_explaindream,null);
        TextView TvItemExplainDreamtitle=(TextView)convertView.findViewById(R.id.TvItemExplainDreamtitle);
         TvItemExplainDreamtitle.setText(ExplainDreamlist.get(position).getTitle());
        TextView TvItemExplainDreamdes=(TextView)convertView.findViewById(R.id.TvItemExplainDreamdes);
        TvItemExplainDreamdes.setText(ExplainDreamlist.get(position).getDes());

        return convertView;
    }
}
