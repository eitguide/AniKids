package com.hackathon.anikids.control;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * DinhTranTextView
 *
 * @author thtuan
 * @since 11:37 AM 29-10-2016
 */
public class DinhTranTextView extends TextView {

    public DinhTranTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public DinhTranTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/UTM-Dinh-Tran.ttf"));
    }
}
