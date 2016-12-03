package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private final String url="http://v.juhe.cn/weixin/query?pno=";//本模块的信息来源网址
    private final String param="&ps=&dtype=&key=d951919b8102f48eddd8f51b6cae6244";//地址的参数信息
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
                    mLvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Log.e("contentUrl",list.get(position).getUrl());
                            Intent intent=new Intent(WechatActivity.this,WechatcontentActivity.class);
                            intent.putExtra("url",list.get(position).getUrl());
                            startActivity(intent);
                        }
                    });
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
            new Thread(new RefreshTask(url+(int)(Math.random()*25)+param,handler,list)).start();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat);
        new WeChatsTask(handler).WeChats_run();
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
        mIvBack.setOnClickListener(listener);;
        mSwrRefresh.setColorSchemeResources(android.R.color.holo_green_light,android.R.color.holo_orange_light,android.R.color.holo_blue_bright,android.R.color.holo_red_light);
        mSwrRefresh.setProgressBackgroundColorSchemeResource(R.color.colorLightBule);
    }
}
