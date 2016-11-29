package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.WeChatAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.WeChat;

import java.util.ArrayList;
import java.util.List;

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
    private SwipeRefreshLayout.OnRefreshListener refreshListener=new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast.makeText(WechatActivity.this,"刷新成功！",Toast.LENGTH_SHORT).show();
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
        WeChatAdapter adapter=new WeChatAdapter(this,getTestData());
        mLvList.setAdapter(adapter);
        mSwrRefresh.setOnRefreshListener(refreshListener);
    }

    List<WeChat> getTestData(){
        List<WeChat> list=new ArrayList<>();
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        list.add(new WeChat("0","微信精选","微信",null,null));
        return list;
    }
}
