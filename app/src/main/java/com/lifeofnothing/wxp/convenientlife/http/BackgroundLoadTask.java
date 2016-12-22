package com.lifeofnothing.wxp.convenientlife.http;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

/**
 * Created by a on 2016/11/30.
 */

public class BackgroundLoadTask extends AsyncTask<URL,Integer,Drawable> {
    private ImageView mIvImage;
    private Boolean flag;//作为判断当前是否处于联网状态的标志位

    public BackgroundLoadTask(ImageView mIvImage) {
        this.mIvImage = mIvImage;
    }

    @Override
    protected Drawable doInBackground(URL... params) {
        try {
            Drawable drawable=Drawable.createFromStream(params[0].openStream(),"img");
            flag=true;
            return drawable;
        } catch (IOException e) {
            e.printStackTrace();
            flag=false;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        if (flag){
            mIvImage.setBackground(drawable);
        }
    }
}
