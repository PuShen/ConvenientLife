package com.lifeofnothing.wxp.convenientlife.ui;

/**
 * Created by Acer on 2016/12/13.
 */

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeofnothing.wxp.convenientlife.R;

public class movie extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
        ImageView img =(ImageView)findViewById(R.id.huanyin);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.movieset);
        img.startAnimation(animation);
        //-----
        ImageView img2 =(ImageView) findViewById(R.id.text);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.movieset);
        img2.startAnimation(animation2);

    }
}
