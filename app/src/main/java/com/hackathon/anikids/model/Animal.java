package com.hackathon.anikids.model;

/**
 * Created by nguyennghia on 10/28/16.
 */
public class Animal {
    private int mId;
    private String mNameVN;
    private String mNamveUS;
    private String mAudioUrl;
    private String mImageUrl;
    private String mStory;
    private String mQuestion;
    private String mStatus;
    public Animal() {
    }

    public Animal(int mId, String mNameVN, String mNamveUS, String mAudioUrl, String mImageUrl, String mStory, String mQuestion, String mStatus) {
        this.mId = mId;
        this.mNameVN = mNameVN;
        this.mNamveUS = mNamveUS;
        this.mAudioUrl = mAudioUrl;
        this.mImageUrl = mImageUrl;
        this.mStory = mStory;
        this.mQuestion = mQuestion;
        this.mStatus = mStatus;
    }

    public Animal(String mNameVN, String mNamveUS, String mAudioUrl, String mImageUrl, String mStory, String mQuestion) {
        this.mNameVN = mNameVN;
        this.mNamveUS = mNamveUS;
        this.mAudioUrl = mAudioUrl;
        this.mImageUrl = mImageUrl;
        this.mStory = mStory;
        this.mQuestion = mQuestion;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getNameVN() {
        return mNameVN;
    }

    public void setNameVN(String mNameVN) {
        this.mNameVN = mNameVN;
    }

    public String getNamveUS() {
        return mNamveUS;
    }

    public void setNamveUS(String mNamveUS) {
        this.mNamveUS = mNamveUS;
    }

    public String getAudioUrl() {
        return mAudioUrl;
    }

    public void setmAudioUrl(String mAudioUrl) {
        this.mAudioUrl = mAudioUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getStory() {
        return mStory;
    }

    public void setmStory(String mStory) {
        this.mStory = mStory;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}

