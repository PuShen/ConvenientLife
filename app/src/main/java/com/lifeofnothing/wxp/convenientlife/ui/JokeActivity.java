package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.JokeAdapter;
import com.lifeofnothing.wxp.convenientlife.adapter.NewsAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.Joke;
import com.lifeofnothing.wxp.convenientlife.entity.News;
import com.lifeofnothing.wxp.convenientlife.http.NewsTask;

import java.util.ArrayList;
import java.util.List;

public class JokeActivity extends AppCompatActivity {
    private ListView vJokeList;//笑话列表
    private TextView vJokeSearch;//搜索栏
    private ImageView vBack;//返回键
    private  String vTime;//笑话的选择时间
    private  View.OnClickListener listener=new  View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.IvJokeBack:
                    finish();
                    break;
                case R.id.TvJokeSearch:
                    Intent intent=new Intent(JokeActivity.this,JokeTimeActivity.class);
                    startActivityForResult(intent,0);
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
                    final List<Joke> list=(List<Joke>)msg.obj;
                    JokeAdapter adapter=new JokeAdapter(JokeActivity.this,list);
                    vJokeList=(ListView)findViewById(R.id.LvJokeList);
                    vJokeList.setAdapter(adapter);
                    vJokeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(JokeActivity.this,JokeContentActivity.class);
                            intent.putExtra("url",list.get(position).getmContent());
                        }
                    });
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // vTime="";
        // new Thread(new JokeTask(handler)).start();
        setContentView(R.layout.activity_joke);
        //   new  JokeTask(a,jtime,handler).run();

    }

    @Override
    protected void onStart() {
        super.onStart();
        vJokeList=(ListView)findViewById(R.id.LvJokeList);
        vJokeSearch=(TextView)findViewById(R.id.TvJokeSearch);
        vBack=(ImageView)findViewById(R.id.IvJokeBack);
    }
    @Override
    protected void onResume() {
        super.onResume();
        vJokeSearch.setOnClickListener(listener);
        vBack.setOnClickListener(listener);

    }

//        @Override
//        protected void onResume() {
//            super.onResume();
//            mTvSearch.setOnClickListener(listener);
//            mIvBack.setOnClickListener(listener);
//            new Thread(new NewsTask(mTime,handler)).start();
//        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Activity.RESULT_OK==resultCode){
            String result=data.getStringExtra("time");
            if (null!=result){
                vTime=data.getStringExtra("time");
            }
        }
    }
}
