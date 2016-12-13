package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.adapter.JokeAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.Joke;
import com.lifeofnothing.wxp.convenientlife.http.JokeTask;

import java.util.ArrayList;
import java.util.List;

public class JokeActivity extends Activity {
    private ListView vJokeList;//笑话列表
    private Button vJoke;  //换一换按钮
    private ImageView vBack;//返回键
    private Button vFunnyPicJoke;  //有图笑话按钮
    private String vUrl1 = "http://v.juhe.cn/joke/randJoke.php?key=99955ed34841b72633054903d94dc642";
    private String vUrl2 = "http://v.juhe.cn/joke/randJoke.php?type=pic&key=99955ed34841b72633054903d94dc642" ;

    private  View.OnClickListener listener=new  View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.IvJokeBack:
                    finish();
                    break;
//                case R.id.TvJokeSearch:
//                    Intent intent=new Intent(JokeActivity.this,JokeTimeActivity.class);
//                    startActivityForResult(intent,0);
//                    break;
                case R.id.BtnJokeRefresh:
                    new Thread(new JokeTask(handler,vJoke,vUrl1)).start();
                    break;
                case R.id.BtnJokeFunny:
                    new Thread(new JokeTask(handler,vFunnyPicJoke,vUrl2)).start();
            }
        }
    };
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    List<Joke> list=(List<Joke>) msg.obj;
                    JokeAdapter adapter=new JokeAdapter(JokeActivity.this,list,vFunnyPicJoke);
                    vJokeList=(ListView)findViewById(R.id.LvJokeList);
                    vJokeList.setAdapter(adapter);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // vTime="";

        setContentView(R.layout.activity_joke);
        new Thread(new JokeTask(handler,vUrl1)).start();
        //   new  JokeTask(a,jtime,handler).run();

    }

    @Override
    protected void onStart() {
        super.onStart();
        vJokeList=(ListView)findViewById(R.id.LvJokeList);
        vBack=(ImageView)findViewById(R.id.IvJokeBack);
        vJoke = (Button)findViewById(R.id.BtnJokeRefresh);
        vFunnyPicJoke = (Button)findViewById(R.id.BtnJokeFunny);
    }
    @Override
    protected void onResume() {
        super.onResume();
        vBack.setOnClickListener(listener);
        vJoke.setOnClickListener(listener);
        vFunnyPicJoke.setOnClickListener(listener);
    }

//        @Override
//        protected void onResume() {
//            super.onResume();
//            mTvSearch.setOnClickListener(listener);
//            mIvBack.setOnClickListener(listener);
//            new Thread(new NewsTask(mTime,handler)).start();
//        }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (Activity.RESULT_OK==resultCode){
//            String result=data.getStringExtra("time");
//            if (null!=result){
//                vTime=data.getStringExtra("time");
//            }
//        }
//    }
}
