package com.lifeofnothing.wxp.convenientlife.entity;

/**
 * Created by dell on 2016/11/24.
 */

public class News {
    private String mTitle;
    private String mAuthor;
    private  String mUrl;
    private String mImage;
    private int mDate;

    public News(String mTitle, String mAuthor, String mUrl, String mImage, int mDate) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mUrl = mUrl;
        this.mImage = mImage;
        this.mDate = mDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public int getmDate() {
        return mDate;
    }

    public void setmDate(int mDate) {
        this.mDate = mDate;
    }

    @Override
    public String toString() {
        return "News{" +
                "mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mImage='" + mImage + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}
