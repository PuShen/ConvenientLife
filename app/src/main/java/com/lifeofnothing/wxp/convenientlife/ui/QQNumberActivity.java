package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.QQNumber;
import com.lifeofnothing.wxp.convenientlife.http.QQNumberTask;
import com.lifeofnothing.wxp.convenientlife.parser.QQNumberParser;

public class QQNumberActivity extends Activity {
    private ImageView mQqJi;
    private ImageView mQqXiong;
    private ImageView mQqBack;
    private Button mQqSure;
    private EditText mQQNumber;
    private QQNumber qq;
    private TextView mQQtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqnumber);
    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Ivqqbtn :
                    mQqXiong.setVisibility(View.INVISIBLE);
                    mQqJi.setVisibility(View.INVISIBLE);
                    mQQtv.setVisibility(View.VISIBLE);
                    String mQQ = mQQNumber.getText().toString();
                    new QQNumberTask(mQQ,handler).QQNum_run();
                    break;
                case R.id.IvQqBack:
                    QQNumberActivity.this.finish();
            }
        }
    };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    qq = (QQNumber) msg.obj;
                    String a = "分析：\n"+qq.getAnalysis()+"\n结论：\n"+qq.getConclusion();
                    mQQtv.setText(a);
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        mQqJi=(ImageView) findViewById(R.id.Imqqji);
        mQqXiong=(ImageView) findViewById(R.id.Imqqxong);
        mQqBack = (ImageView)findViewById(R.id.IvQqBack);
        mQqSure = (Button)findViewById(R.id.Ivqqbtn);
        mQQNumber = (EditText)findViewById(R.id.Ivqqnumber);
        mQQtv = (TextView)findViewById(R.id.tvQQInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mQqJi.setOnClickListener(listener);
        mQqXiong.setOnClickListener(listener);
        mQqBack.setOnClickListener(listener);
        mQqSure.setOnClickListener(listener);
    }
}
