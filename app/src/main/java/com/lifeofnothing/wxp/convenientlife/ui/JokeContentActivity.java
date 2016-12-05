package com.lifeofnothing.wxp.convenientlife.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

public class JokeContentActivity extends AppCompatActivity {
    private WebView mWvContent;
    private ImageView mIvBack;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvNewscontentBack:
                    finish();
                    break;
            }
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        mWvContent= (WebView) findViewById(R.id.WvNewscontentContent);
        mIvBack= (ImageView) findViewById(R.id.IvNewscontentBack);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
       mWvContent.loadUrl(getIntent().getStringExtra("url"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_content);
    }
}
