package com.lifeofnothing.wxp.convenientlife.utils;

import android.content.Context;
import android.widget.ImageView;

import com.lifeofnothing.wxp.convenientlife.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * 图片的异步加载与缓存
 * Created by 王晓普 on 2016/12/15.
 */

public class ImageLoaderUtils {
    /**
     * 初始化一些配置信息
     * @param context 上下文环境
     * @return 配置对象
     */
    private static ImageLoaderConfiguration init(Context  context){
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.image_default)
                .showImageForEmptyUri(R.drawable.image_default)
                .showImageOnFail(R.drawable.image_default)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        return config;
    }

    /**
     * 进行图片的异步加载
     * @param url 图片的网络地址
     * @param imageView 图片控件
     * @param context 上下文环境
     */
    public static void displayImage(String url, ImageView imageView,Context context){
        ImageLoader loader=ImageLoader.getInstance();
        loader.init(init(context));
        loader.displayImage(url,imageView);
    }
}
