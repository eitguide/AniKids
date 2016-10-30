package com.hackathon.anikids.utils;

import android.support.annotation.IdRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hackathon.anikids.AniKidsApplication;
import com.hackathon.anikids.R;

/**
 * ImageUtil
 *
 * @author thtuan
 * @since 9:23 AM 29-10-2016
 */
public class ImageUtil {
    public static void loadImage(ImageView imgView, String urlImage) {
        Glide.with(AniKidsApplication.getAppContext()).load(urlImage).asBitmap()
                .placeholder(Utils.getDrawable(R.mipmap.ic_launcher))
                .error(Utils.getDrawable(R.mipmap.ic_launcher)).into(imgView);
    }
    public static void loadImagewithDrawable(ImageView imgView, @IdRes int idRes) {
        Glide.with(AniKidsApplication.getAppContext()).load(idRes).asBitmap()
                .placeholder(Utils.getDrawable(R.mipmap.ic_launcher))
                .error(Utils.getDrawable(R.mipmap.ic_launcher)).into(imgView);
    }
}
