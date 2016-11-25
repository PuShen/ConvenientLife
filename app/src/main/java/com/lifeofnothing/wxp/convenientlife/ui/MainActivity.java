package com.lifeofnothing.wxp.convenientlife.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

public class MainActivity extends AppCompatActivity {
    private ImageView mIvNews;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvMainNews:
                    Intent intent=new Intent(MainActivity.this,NewsActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试代码
        //new Nba().Nba_run();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvNews= (ImageView) findViewById(R.id.IvMainNews);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvNews.setOnClickListener(listener);
    }

}
