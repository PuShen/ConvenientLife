package com.lifeofnothing.wxp.convenientlife.ui;
import com.lifeofnothing.wxp.convenientlife.adapter.ExplainDreamAdapter;
import com.lifeofnothing.wxp.convenientlife.entity.ExplainDream;
import android.app.Activity;
import android.app.ProgressDialog;
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
import com.lifeofnothing.wxp.convenientlife.utils.ObjectCacheUtils;

import java.io.Serializable;
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
    private ProgressDialog Dialog;
    private List<ExplainDream> list;
    private  ExplainDreamAdapter adapter;
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
                            Dialog.show();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

        }
    };

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Dialog.dismiss();
                    list=(List<ExplainDream>) msg.obj;
                  //  Log.e("result",list.toString());
                     adapter=new ExplainDreamAdapter(ExplainDreamtypeActivity.this,list);
                    LvExplainDreamList.setAdapter(adapter);
                    LvExplainDreamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(ExplainDreamtypeActivity.this,ExplainDreamContentActivity.class);
                               intent.putExtra("title",list.get(position).getTitle());

                          //  1 Log.e("result", String.valueOf(list.get(position).getLs()));
                               intent.putExtra("ls", (Serializable) list.get(position).getLs());
                            startActivity(intent);

                        }
                    });
                    ObjectCacheUtils.setCache("ExplainDream",list);
                    break;
                case 1:
                    Dialog.dismiss();
                    Toast.makeText(ExplainDreamtypeActivity.this,"亲，你所查找的梦不存在！",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Dialog.dismiss();
                    if (ObjectCacheUtils.exists("ExplainDream")){
                        list=(List<ExplainDream>) ObjectCacheUtils.getCache("ExplainDream");
                        adapter=new ExplainDreamAdapter(ExplainDreamtypeActivity.this,list);
                        LvExplainDreamList.setAdapter(adapter);
                    }
                    Log.e("result", String.valueOf(list));
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
        Dialog=new ProgressDialog(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDreamtypeBack.setOnClickListener(listener);
        IvExplainDreamSearch.setOnClickListener(listener);
        Dialog.setMessage("系统正在加载中，请稍后！");

    }
}
