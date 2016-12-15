package com.lifeofnothing.wxp.convenientlife.parser;

/**
 * Created by Administrator on 2016/11/29.
 */

public class UrlFixer {
    public static String fix(String originalUrl) {
        String [] fixedUrlStrings = originalUrl.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<fixedUrlStrings.length;i++){
            stringBuilder.append(fixedUrlStrings[i]+"/");
        }
        String fixedUrl = stringBuilder.toString();
        return fixedUrl;
    }
}
