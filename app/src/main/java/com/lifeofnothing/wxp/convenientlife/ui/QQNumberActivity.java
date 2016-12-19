package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

public class QQNumberActivity extends Activity {
    private ImageView mQqJi;
    private ImageView mQqXiong;
    private ImageView mQqBack;
    private Button mQqSure;

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
                    break;
                case R.id.IvQqBack:
                    QQNumberActivity.this.finish();
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        mQqJi=(ImageView) findViewById(R.id.Imqqji);
        mQqXiong=(ImageView) findViewById(R.id.Imqqxong);
        mQqBack = (ImageView)findViewById(R.id.IvQqBack);
        mQqSure = (Button)findViewById(R.id.Ivqqbtn);
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
