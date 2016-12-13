package com.lifeofnothing.wxp.convenientlife.ui;
import com.lifeofnothing.wxp.convenientlife.entity.ExplainDream;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.http.ExplainDreamTask;
import com.lifeofnothing.wxp.convenientlife.prasor.ExplainDreamParser;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */

public class ExplainDreamActivity extends Activity {
    private ImageView IvExplainDream;

    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvExplainDreamBack:
                    finish();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaindream);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IvExplainDream=(ImageView)findViewById(R.id.IvExplainDreamBack);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDream.setOnClickListener(listener);
    }
}
