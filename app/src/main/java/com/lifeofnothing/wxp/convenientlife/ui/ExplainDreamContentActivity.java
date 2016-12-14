package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by Administrator on 2016/12/14.
 */

public class ExplainDreamContentActivity extends Activity {
    private ImageView IvExplainDreamContentBack;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvExplainDreamContentBack:
                    finish();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaindreamcontent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IvExplainDreamContentBack=(ImageView)findViewById(R.id.IvExplainDreamContentBack);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDreamContentBack.setOnClickListener(listener);

    }
}
