package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by dell on 2016/11/28.
 */

public class WechatActivity extends Activity {
    private SwipeRefreshLayout mSwrRefresh;
    private ImageView mIvBack;
    private ListView mLvList;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvWechatBack:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvBack= (ImageView) findViewById(R.id.IvWechatBack);
        mLvList= (ListView) findViewById(R.id.LvWechatList);
        mSwrRefresh= (SwipeRefreshLayout) findViewById(R.id.SrlWechatRefresh);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
    }
}
