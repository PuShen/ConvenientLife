package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.ExplainDream;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class ExplainDreamContentActivity extends Activity {
    private ImageView IvExplainDreamContentBack;
    private TextView TvExplainDreamContent;
    private ListView LvExplainDreamContent;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
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
        IvExplainDreamContentBack = (ImageView) findViewById(R.id.IvExplainDreamContentBack);
        TvExplainDreamContent = (TextView) findViewById(R.id.TvExplainDreamContent);
        LvExplainDreamContent = (ListView) findViewById(R.id.LvExplainDreamContent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDreamContentBack.setOnClickListener(listener);
        Intent intent = getIntent();
        TvExplainDreamContent.setText(intent.getStringExtra("title"));

        ;

    }
}
