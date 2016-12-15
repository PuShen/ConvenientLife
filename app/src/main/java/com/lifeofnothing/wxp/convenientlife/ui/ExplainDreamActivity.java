package com.lifeofnothing.wxp.convenientlife.ui;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lifeofnothing.wxp.convenientlife.R;

/**
 * Created by Administrator on 2016/12/12.
 */

public class ExplainDreamActivity extends Activity {
    private ImageView IvExplainDreamBack;
  //
    private LinearLayout LlayExplainDreamSearch;

    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvExplainDreamBack:
                    finish();
                    break;
                case R.id.LlayExplainDreamSearch:
                    Intent intent=new Intent(ExplainDreamActivity.this,ExplainDreamtypeActivity.class);
                    startActivity(intent);
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
        IvExplainDreamBack=(ImageView)findViewById(R.id.IvExplainDreamBack);

        LlayExplainDreamSearch=(LinearLayout) findViewById(R.id.LlayExplainDreamSearch);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDreamBack.setOnClickListener(listener);
        LlayExplainDreamSearch.setOnClickListener(listener);
    }
}
