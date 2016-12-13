package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.BusLineStationAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;

/**
 * Created by 王晓普 on 2016/12/13.
 */

public class BuscontentActivity extends Activity {
    private ImageView mIvBack;
    private TextView mTvBus;
    private TextView mTvLocation;
    private TextView mTvTime;
    private TextView mTvPrice;
    private ListView mLvList;

    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvBuscontentBack:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscontent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvBack= (ImageView) findViewById(R.id.IvBuscontentBack);
        mTvBus= (TextView) findViewById(R.id.TvBuscontentBus);
        mTvLocation= (TextView) findViewById(R.id.TvBuscontentLocation);
        mTvTime= (TextView) findViewById(R.id.TvBuscontentTime);
        mTvPrice= (TextView) findViewById(R.id.TvBuscontentPrice);
        mLvList= (ListView) findViewById(R.id.LvBuscontentList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
        mIvBack.setOnClickListener(listener);
    }

    public void initData(){
        BusLine busLine= (BusLine) getIntent().getSerializableExtra("bus");
        mTvBus.setText(busLine.getKey_name());
        mTvLocation.setText(busLine.getFront_name()+"-"+busLine.getTerminal_name());
        mTvTime.setText(busLine.getStart_time()+"-"+busLine.getEnd_time());
        mTvPrice.setText(busLine.getTotal_price());
        BusLineStationAdapter adapter=new BusLineStationAdapter(this,busLine.getLb());
        mLvList.setAdapter(adapter);
    }
}
