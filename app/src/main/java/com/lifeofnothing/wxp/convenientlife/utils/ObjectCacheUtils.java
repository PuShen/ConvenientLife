package com.lifeofnothing.wxp.convenientlife.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 缓存一个对象的状态，但是该对象必须实现了Serializable或Externalizable接口
 * Created by 王晓普 on 2016/12/15.
 */

public class ObjectCacheUtils {
    private static String mPath="/data/data/com.lifeofnothing.wxp.convenientlife/files/";

    /**
     * 初始化项目缓存路径
     * @param path 缓存路径
     */
    public static void setPath(String path){
        mPath=path;
    }

    /**
     * 判断当前的关键字或者文件名是否存在对应的缓存
     * @param key 缓存的关键字或者文件名
     * @return 如果返回true，则说明存在缓存，反之没有缓存
     */
    public static boolean exists(String key){
        return new File(mPath+key).exists();
    }

    /**
     * 设置缓存
     * @param key 缓存的关键字或者文件名
     * @param object 要缓存的对象
     */
    public static void setCache(String key,Object object){
        File file=new File(mPath+key);
        ObjectOutputStream outputStream=null;
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            outputStream=new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 得到缓存
     * @param key 缓存的关键字或者文件名
     * @return 缓存对象，如果没有缓存将会new一个object类型的对象返回
     */
    public static Object getCache(String key){
        File file=new File(mPath+key);
        ObjectInputStream inputStream=null;
        Object object=null;
        try {
            if (!file.exists()){
                return new Object();
            }
           inputStream=new ObjectInputStream(new FileInputStream(file));
            object=inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    /**
     * 清除对应的缓存
     * @param key 缓存的关键字或者文件名
     */
    public static void clear(String key){
        File file=new File(mPath+key);
        if (file.exists()){
            file.delete();
        }
    }
}
