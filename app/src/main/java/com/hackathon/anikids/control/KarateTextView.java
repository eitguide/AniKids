package com.hackathon.anikids.control;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hackathon.anikids.AniKidsApplication;

/**
 * KarateTextView
 *
 * @author thtuan
 * @since 11:15 AM 29-10-2016
 */
public class KarateTextView extends TextView {

    public KarateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public KarateTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/UTM-Karate.ttf"));
    }

}
