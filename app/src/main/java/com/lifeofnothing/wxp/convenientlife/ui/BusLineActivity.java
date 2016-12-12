package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.BusLineAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;

import java.util.List;

/**
 * Created by dell on 2016/12/6.
 */

public class BusLineActivity extends Activity {
    private Animation[] mAnimation=new Animation[2];
    private ImageView mIvBack;
    private TextView mTvCity;
    private ImageView mIvAdd;
    private ImageView mIvSearch;
    private View mLlaySearch;
    private ImageView mIvBanner;
    private EditText mEtSearch;
    private ListView mLvList;
    private BusLineAdapter mAdapter;
    private List<BusLine> mList;
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
    private View.OnTouchListener touchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()){
                case R.id.EtBuslineSearch:
                    if (View.GONE!=mIvBanner.getVisibility()){
                        mAnimation[1].setAnimationListener(animationListener);
                        mIvBanner.startAnimation(mAnimation[1]);
                        mLlaySearch.startAnimation(mAnimation[0]);
                    }
                    break;
            }
            return false;
        }
    };
    private Animation.AnimationListener animationListener=new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            mIvBanner.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
    private TextWatcher watcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Toast.makeText(BusLineActivity.this,s.toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void afterTextChanged(Editable s) {

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
        mAnimation[0]= AnimationUtils.loadAnimation(this,R.anim.bus_banner_out);
        mAnimation[1]=AnimationUtils.loadAnimation(this,R.anim.bus_banner_alpha);
        mIvBack= (ImageView) findViewById(R.id.IvBuslineBack);
        mTvCity= (TextView) findViewById(R.id.TvBuslineCity);
        mIvAdd= (ImageView) findViewById(R.id.IvBuslineAdd);
        mIvSearch= (ImageView) findViewById(R.id.IvBuslineSearch);
        mLlaySearch=findViewById(R.id.LlayBuslineSearch);
        mIvBanner= (ImageView) findViewById(R.id.IvBuslineBanner);
        mEtSearch= (EditText) findViewById(R.id.EtBuslineSearch);
        mLvList= (ListView) findViewById(R.id.LvBuslineList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
        mEtSearch.setOnTouchListener(touchListener);
        mEtSearch.addTextChangedListener(watcher);
    }
}
