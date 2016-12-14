package com.lifeofnothing.wxp.convenientlife.ui;
import com.lifeofnothing.wxp.convenientlife.adapter.ExplainDreamAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.ExplainDream;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.ETC1;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.http.ExplainDreamTask;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class ExplainDreamtypeActivity extends Activity{
    private ImageView IvExplainDreamtypeBack;
    private ListView LvExplainDreamList;
    private EditText EtExplainDream;
    private ImageView IvExplainDreamSearch;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvExplainDreamtypeBack:
                    finish();
                    break;
                case R.id.IvExplainDreamSearch:
                    if (0!=EtExplainDream.getText().length()) {
                        try {
                            new ExplainDreamTask(EtExplainDream.getText().toString(), mHandler).run();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
            }

        }
    };

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    List<ExplainDream> list=(List<ExplainDream>) msg.obj;
                  //  Log.e("result",list.toString());
                    ExplainDreamAdapter adapter=new ExplainDreamAdapter(ExplainDreamtypeActivity.this,list);
                    LvExplainDreamList.setAdapter(adapter);
                    LvExplainDreamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(ExplainDreamtypeActivity.this,ExplainDreamContentActivity.class);

                            startActivity(intent);

                        }
                    });
                    break;
                case 1:
                    Toast.makeText(ExplainDreamtypeActivity.this,"亲，你所查找的梦不存在！",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(ExplainDreamtypeActivity.this,"当前网络异常，请稍后再试！",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaindreamtype);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IvExplainDreamtypeBack=(ImageView)findViewById(R.id.IvExplainDreamtypeBack);
        LvExplainDreamList=(ListView)findViewById(R.id.LvExplainDreamList);
        EtExplainDream=(EditText)findViewById(R.id.EtExplainDream);
        IvExplainDreamSearch=(ImageView)findViewById(R.id.IvExplainDreamSearch);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDreamtypeBack.setOnClickListener(listener);
        IvExplainDreamSearch.setOnClickListener(listener);

    }
}