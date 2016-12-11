package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by dell on 2016/12/6.
 */

public class BusLineActivity extends Activity {
    private ImageView mIvBack;
    private TextView mTvCity;
    private ImageView mIvAdd;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvBuslineBack:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busline);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvBack= (ImageView) findViewById(R.id.IvBuslineBack);
        mTvCity= (TextView) findViewById(R.id.TvBuslineCity);
        mIvAdd= (ImageView) findViewById(R.id.IvBuslineAdd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
    }
}
