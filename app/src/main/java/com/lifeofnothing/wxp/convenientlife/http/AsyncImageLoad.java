package com.lifeofnothing.wxp.convenientlife.http;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by 我需要一枚好辅助丶 on 2016/11/24.
 */

public class AsyncImageLoad extends AsyncTask<Void,Void,Drawable> {
    private String mUrl;
    private Drawable mImage;
    private ImageView mImageview;
    private Boolean flag;//作为判断当前是否处于联网状态的标志位

    public AsyncImageLoad(String mUrl, ImageView mImageview) {
        this.mUrl = mUrl;
        this.mImageview = mImageview;
    }

    @Override
    protected Drawable doInBackground(Void... params) {
        try {
            mImage = Drawable.createFromStream((InputStream)(new URL(mUrl)).openStream(), "test");
            flag=true;
        } catch (IOException e) {
            e.printStackTrace();
            flag=false;
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        if (flag){
            mImageview.setImageDrawable(mImage);
        }
    }


}
