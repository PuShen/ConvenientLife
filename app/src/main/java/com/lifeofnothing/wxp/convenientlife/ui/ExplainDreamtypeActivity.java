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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
   // private EditText EtExplainDream;
    private AutoCompleteTextView autoCompleteTextView;
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
                     if(0!=autoCompleteTextView.getText().length())
                        try {
                            new ExplainDreamTask(autoCompleteTextView.getText().toString(), mHandler).run();
                            Dialog.show();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    saveHistory("history",autoCompleteTextView);
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
                   // Log.e("result", String.valueOf(list));
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
        autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.auto);
        IvExplainDreamSearch=(ImageView)findViewById(R.id.IvExplainDreamSearch);
        Dialog=new ProgressDialog(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDreamtypeBack.setOnClickListener(listener);
        IvExplainDreamSearch.setOnClickListener(listener);
        Dialog.setMessage("系统正在加载中，请稍后！");
        initAutoComplete("history", autoCompleteTextView);

    }
    private void saveHistory(String field,AutoCompleteTextView autoCompleteTextView){
        String text=autoCompleteTextView.getText().toString();
        SharedPreferences sharedPreferences=getSharedPreferences("ConveninentLife",0);
        String longhistory=sharedPreferences.getString(field,"nothing");
        if(!longhistory.contains(text+",")){
            StringBuilder sb = new StringBuilder(longhistory);
            sb.insert(0, text + ",");
            sharedPreferences.edit().putString("history", sb.toString()).commit();
        }

    }
    private void initAutoComplete(String field,AutoCompleteTextView autoCompleteTextView){
         SharedPreferences sharedPreferences=getSharedPreferences("ConveninentLife",0);
        String longhistory=sharedPreferences.getString(field,"nothing");
        String [] histories=longhistory.split(",");
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(ExplainDreamtypeActivity.this,R.layout.support_simple_spinner_dropdown_item,histories);
        if(histories.length>50){
           String [] newHistories=new String[50];
            System.arraycopy(histories,0,newHistories,0,50);
            adapter1=new ArrayAdapter<String>(ExplainDreamtypeActivity.this,R.layout.support_simple_spinner_dropdown_item,newHistories);

        }
        autoCompleteTextView.setAdapter(adapter1);
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                AutoCompleteTextView view=(AutoCompleteTextView) v;
                if (hasFocus){
                    view.showDropDown();
                }
            }
        });
    }
}
