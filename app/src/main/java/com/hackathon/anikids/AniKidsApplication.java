package com.hackathon.anikids;

import android.app.Application;
import android.content.Context;

import com.google.android.youtube.player.YouTubePlayerView;

/**
 * AniKidsApplication
 *
 * @author thtuan
 * @since 9:28 AM 29-10-2016
 */
public class AniKidsApplication extends Application {

    private static Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

    }
    public static Context getAppContext(){
        return appContext;
    }
}
