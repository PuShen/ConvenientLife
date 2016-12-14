package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.BusLineAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.http.BusLineTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/12/6.
 */

public class BusLineActivity extends Activity {
    private String mCity;
    private Animation[] mAnimation=new Animation[2];
    private ImageView mIvBack;
    private TextView mTvCity;
    private ImageView mIvAdd;
    private ImageView mIvSearch;
    private View mLlaySearch;
    private ImageView mIvBanner;
    private EditText mEtSearch;
    private ProgressBar mPbLoad;
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
                case R.id.IvBuslineAdd:
                    Intent intent=new Intent(BusLineActivity.this,BuscityActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    private AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(BusLineActivity.this,BuscontentActivity.class);
            intent.putExtra("bus",mList.get(position));
            startActivity(intent);
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
            mPbLoad.setVisibility(View.VISIBLE);
            new BusLineTask(mCity,s.toString(),handler,mList).Bus_run();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    mAdapter.notifyDataSetChanged();
                    break;
                case 2:
                    Toast.makeText(BusLineActivity.this,R.string.tip_error_net,Toast.LENGTH_SHORT).show();
                    break;
            }
            mPbLoad.setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busline);
        mList=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCity=getSharedPreferences("ConvenientLife", Context.MODE_PRIVATE).getString("bus_city","北京");
        mAnimation[0]= AnimationUtils.loadAnimation(this,R.anim.bus_banner_out);
        mAnimation[1]=AnimationUtils.loadAnimation(this,R.anim.bus_banner_alpha);
        mIvBack= (ImageView) findViewById(R.id.IvBuslineBack);
        mTvCity= (TextView) findViewById(R.id.TvBuslineCity);
        mIvAdd= (ImageView) findViewById(R.id.IvBuslineAdd);
        mIvSearch= (ImageView) findViewById(R.id.IvBuslineSearch);
        mLlaySearch=findViewById(R.id.LlayBuslineSearch);
        mIvBanner= (ImageView) findViewById(R.id.IvBuslineBanner);
        mEtSearch= (EditText) findViewById(R.id.EtBuslineSearch);
        mPbLoad= (ProgressBar) findViewById(R.id.PbBuslineLoad);
        mLvList= (ListView) findViewById(R.id.LvBuslineList);
        mAdapter=new BusLineAdapter(this,mList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTvCity.setText("【"+mCity+"】");
        mLvList.setAdapter(mAdapter);
        mLvList.setOnItemClickListener(itemClickListener);
        mIvBack.setOnClickListener(listener);
        mIvAdd.setOnClickListener(listener);
        mEtSearch.setOnTouchListener(touchListener);
        mEtSearch.addTextChangedListener(watcher);

    }
}
