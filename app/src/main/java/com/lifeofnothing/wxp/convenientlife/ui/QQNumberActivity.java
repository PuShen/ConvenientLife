package com.lifeofnothing.wxp.convenientlife.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

public class QQNumberActivity extends AppCompatActivity {
    private Button btn;
    private ImageView Imqqji;
    private ImageView Imqqxong;
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
                    Imqqxong.setVisibility(View.INVISIBLE);
                    Imqqji.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        btn=(Button)findViewById(R.id.Ivqqbtn);
        Imqqji=(ImageView) findViewById(R.id.Imqqji);
        Imqqxong=(ImageView) findViewById(R.id.Imqqxong);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(listener);
        Imqqji.setOnClickListener(listener);
        Imqqxong.setOnClickListener(listener);
    }
}
