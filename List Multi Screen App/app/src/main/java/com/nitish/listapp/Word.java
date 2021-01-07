package com.nitish.listapp;

public class Word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mAudioResorceId;

    public Word(String defaultTranslation, String miwokTranslation,int audioResorceId ) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResorceId=audioResorceId;
    }



    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResorceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResorceId=audioResorceId;
    }

    public int getImageResourceId() { return mImageResourceId; }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public boolean hasImage() { return mImageResourceId != NO_IMAGE_PROVIDED; }

    public int getAudioResorceId() { return mAudioResorceId; }
}
