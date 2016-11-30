package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.WeChatAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.WeChat;
import com.lifeofnothing.wxp.convenientlife.http.RefreshTask;
import com.lifeofnothing.wxp.convenientlife.http.WeChatsTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/11/28.
 */

public class WechatActivity extends Activity {
    private SwipeRefreshLayout mSwrRefresh;
    private ImageView mIvBack;
    private ListView mLvList;
    private List<WeChat> list;
    private WeChatAdapter adapter;
    private final String url="http://v.juhe.cn/weixin/query?pno=";
    private final String param="&ps=&dtype=&key=d951919b8102f48eddd8f51b6cae6244";
    private int i;
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
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    list=(List<WeChat>)msg.obj;
                    adapter=new WeChatAdapter(WechatActivity.this,list);
                    mLvList.setAdapter(adapter);
                    mSwrRefresh.setOnRefreshListener(refreshListener);
                    break;
                case 1:
                    adapter.notifyDataSetChanged();
                    mSwrRefresh.setRefreshing(false);
                    break;
            }
        }
    };
    private SwipeRefreshLayout.OnRefreshListener refreshListener=new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            if (25>++i){
                new Thread(new RefreshTask(url+i+param,handler,list)).start();
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
        i=0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);;
        new WeChatsTask(handler).WeChats_run();
    }
}
