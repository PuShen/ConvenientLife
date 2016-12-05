package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by a on 2016/11/24.
 */

public class NewstypeActivity extends Activity {
    private ImageView mIvBack;
    private TextView mTvTop;
    private TextView mTvSociety;
    private TextView mTvInternal;
    private TextView mTvInternation;
    private TextView mTvEntertainment;
    private TextView mTvSports;
    private TextView mTvMilitary;
    private TextView mTvScience;
    private TextView mTvFinance;
    private TextView mTvFashion;
    private View.OnClickListener listener=  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            switch (v.getId()){
                case R.id.TvNewstypeTop:
                    intent.putExtra("type","top");
                    break;
                case R.id.TvNewstypeSociety:
                    intent.putExtra("type","shehui");
                    break;
                case R.id.TvNewstypeInternal:
                    intent.putExtra("type","guonei");
                    break;
                case R.id.TvNewstypeInternation:
                    intent.putExtra("type","guoji");
                    break;
                case R.id.TvNewstypeEntertainment:
                    intent.putExtra("type","yule");
                    break;
                case R.id.TvNewstypeSports:
                    intent.putExtra("type","tiyu");
                    break;
                case R.id.TvNewstypeMilitary:
                    intent.putExtra("type","junshi");
                    break;
                case R.id.TvNewstypeScience:
                    intent.putExtra("type","keji");
                    break;
                case R.id.TvNewstypeFinance:
                    intent.putExtra("type","caijing");
                    break;
                case R.id.TvNewstypeFashion:
                    intent.putExtra("type","shishang");
                    break;
            }
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_newstype);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvBack= (ImageView) findViewById(R.id.IvNewstypeBack);
        mTvTop= (TextView) findViewById(R.id.TvNewstypeTop);
        mTvSociety= (TextView) findViewById(R.id.TvNewstypeSociety);
        mTvInternal= (TextView) findViewById(R.id.TvNewstypeInternal);
        mTvInternation= (TextView) findViewById(R.id.TvNewstypeInternation);
        mTvEntertainment= (TextView) findViewById(R.id.TvNewstypeEntertainment);
        mTvSports= (TextView) findViewById(R.id.TvNewstypeSports);
        mTvMilitary= (TextView) findViewById(R.id.TvNewstypeMilitary);
        mTvScience= (TextView) findViewById(R.id.TvNewstypeScience);
        mTvFinance= (TextView) findViewById(R.id.TvNewstypeFinance);
        mTvFashion= (TextView) findViewById(R.id.TvNewstypeFashion);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
        mTvTop.setOnClickListener(listener);
        mTvSociety.setOnClickListener(listener);
        mTvInternal.setOnClickListener(listener);
        mTvInternation.setOnClickListener(listener);
        mTvEntertainment.setOnClickListener(listener);
        mTvSports.setOnClickListener(listener);
        mTvMilitary.setOnClickListener(listener);
        mTvScience.setOnClickListener(listener);
        mTvFinance.setOnClickListener(listener);
        mTvFashion.setOnClickListener(listener);
    }
}
