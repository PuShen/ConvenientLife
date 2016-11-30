package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by a on 2016/11/30.
 */

public class WechatcontentActivity extends Activity {
    private ImageView mIvBack;
    private WebView mWvContent;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvWechatcontentBack:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechatcontent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvBack= (ImageView) findViewById(R.id.IvWechatcontentBack);
        mWvContent= (WebView) findViewById(R.id.WvWechatcontentContent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
        mWvContent.setWebViewClient(new WebViewClient());
        mWvContent.getSettings().setJavaScriptEnabled(true);
        mWvContent.getSettings().setBlockNetworkImage(false);
        mWvContent.loadUrl(getIntent().getStringExtra("url"));
    }
}
