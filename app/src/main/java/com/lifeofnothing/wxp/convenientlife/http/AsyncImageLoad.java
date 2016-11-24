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

    public AsyncImageLoad(String mUrl, ImageView mImageview) {
        this.mUrl = mUrl;
        this.mImageview = mImageview;
    }

    @Override
    protected Drawable doInBackground(Void... params) {
        try {
            mImage = Drawable.createFromStream((InputStream)(new URL(mUrl)).openStream(), "test");
        } catch (IOException e) {
            e.printStackTrace();
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
        mImageview.setImageDrawable(mImage);
    }


}
