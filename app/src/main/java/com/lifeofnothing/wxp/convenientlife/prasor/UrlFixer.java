package com.lifeofnothing.wxp.convenientlife.prasor;

/**
 * Created by Administrator on 2016/11/29.
 */

public class UrlFixer {
    public static String fix(String originalUrl) {
        String [] fixedUrlStrings = originalUrl.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        for (String fixedUrlPart:fixedUrlStrings
             ) {
            stringBuilder.append(fixedUrlPart);
        }
        String fixedUrl = stringBuilder.toString();
        return fixedUrl;
    }
}
