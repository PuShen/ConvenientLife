package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by a on 2016/11/26.
 */

public class NewscontentActivity extends Activity {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscontent);
    }

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
}
