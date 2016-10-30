package com.hackathon.anikids.view;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hackathon.anikids.R;
import com.hackathon.anikids.database.DatabaseManager;
import com.hackathon.anikids.utils.Utils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DatabaseManager mDatabaseManager;
    private Button btnCauDo;
    private AnimatorSet mAnimatorSet;
    private Button btnListAnimal;
    private FrameLayout flFooter;
    private Typeface mTypeface;
    private ImageView imvBiglogo;
    private LinearLayout llFeatureButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseManager = DatabaseManager.getInstance(this);

        mTypeface = Typeface.createFromAsset(this.getAssets(), "fonts/VNF-Comic Sans.ttf");
        btnCauDo = (Button) findViewById(R.id.btn_caudo);
        btnListAnimal = (Button) findViewById(R.id.btn_list_animal);
        flFooter = (FrameLayout) findViewById(R.id.fl_footer);
        imvBiglogo = (ImageView)findViewById(R.id.imv_big_logo);
        llFeatureButton  = (LinearLayout)findViewById(R.id.ll_feature_button);

        btnListAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListAnimalsActivity.class));
            }
        });

        btnCauDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuestionActivity.class));
            }
        });

        btnCauDo.setTypeface(mTypeface);
        btnListAnimal.setTypeface(mTypeface);

        FrameLayout.LayoutParams param = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int)(0.3f * Utils.getHeight(this)));
        param.gravity = Gravity.BOTTOM;

        flFooter.setLayoutParams(param);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " + imvBiglogo.getTop());
    }
}

