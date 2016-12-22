package com.lifeofnothing.wxp.convenientlife.ui;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private ImageView IvExplainDreammaotouying;
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
    public void rotateImpl(){
    Animation animation= AnimationUtils.loadAnimation(ExplainDreamActivity.this,R.anim.explaindream_foot_rotate);
        IvExplainDreammaotouying.startAnimation(animation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaindream);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IvExplainDreamBack=(ImageView)findViewById(R.id.IvExplainDreamBack);
        IvExplainDreammaotouying=(ImageView)findViewById(R.id.IvExplainDreammaotouying);
        LlayExplainDreamSearch=(LinearLayout) findViewById(R.id.LlayExplainDreamSearch);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IvExplainDreamBack.setOnClickListener(listener);
        LlayExplainDreamSearch.setOnClickListener(listener);
        rotateImpl();

    }
}
