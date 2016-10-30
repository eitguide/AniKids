package com.hackathon.anikids.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.hackathon.anikids.R;

import java.util.List;
import java.util.Random;

public class CropActivity extends AppCompatActivity implements View.OnClickListener{
    Bitmap[] bitmaps;
    ImageView ivCrop1;
    ImageView ivCrop2;
    ImageView ivCrop3;
    ImageView ivCrop4;
    ImageView ivPart1;
    ImageView ivPart2;
    ImageView ivPart3;
    ImageView ivPart4;
    GridLayout gridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        Bitmap bitmap = BitmapFactory.decodeFile("assets/images/dolphin.png");
//        Bitmap bitmap = BitmapFactory.decodeFile("font/"+getIntent().getStringExtra("imgUrl"));
        bitmaps = splitBitmap(bitmap);
        gridLayout = (GridLayout) findViewById(R.id.glImage);
        ivCrop1 = (ImageView) findViewById(R.id.ivCrop1);
        ivCrop2 = (ImageView) findViewById(R.id.ivCrop2);
        ivCrop3 = (ImageView) findViewById(R.id.ivCrop3);
        ivCrop4 = (ImageView) findViewById(R.id.ivCrop4);
        ivPart1 = (ImageView) findViewById(R.id.ivPart1);
        ivPart2 = (ImageView) findViewById(R.id.ivPart2);
        ivPart3 = (ImageView) findViewById(R.id.ivPart3);
        ivPart4 = (ImageView) findViewById(R.id.ivPart4);
        ivCrop1.setImageBitmap(bitmaps[2]);
        ivCrop2.setImageBitmap(bitmaps[1]);
        ivCrop3.setImageBitmap(bitmaps[3]);
        ivCrop4.setImageBitmap(bitmaps[0]);
        ivPart1.setImageBitmap(bitmaps[0]);
        ivPart2.setImageBitmap(bitmaps[1]);
        ivPart3.setImageBitmap(bitmaps[2]);
        ivPart4.setImageBitmap(bitmaps[3]);
        ivPart1.setAlpha(0f);
        ivPart2.setAlpha(0f);
        ivPart3.setAlpha(0f);
        ivPart4.setAlpha(0f);
    }

    public Bitmap[] splitBitmap(Bitmap picture)
    {
        Bitmap[] imgs = new Bitmap[4];
        imgs[0] = Bitmap.createBitmap(picture, 0, 0, picture.getWidth()/2 , picture.getHeight()/2);
        imgs[1] = Bitmap.createBitmap(picture, picture.getWidth()/2, 0, picture.getWidth()/2, picture.getHeight()/2);
        imgs[2] = Bitmap.createBitmap(picture,0, picture.getHeight()/2, picture.getWidth()/2,picture.getHeight()/2);
        imgs[3] = Bitmap.createBitmap(picture, picture.getWidth()/2, picture.getHeight()/2, picture.getWidth()/2, picture.getHeight()/2);
        return imgs;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ivCrop1:
                setBitmapToPart(view, 0);
                break;
            case R.id.ivCrop2:
                setBitmapToPart(view, 1);
                break;
            case R.id.ivCrop3:
                setBitmapToPart(view, 2);
                break;
            case R.id.ivCrop4:
                setBitmapToPart(view, 3);
                break;
        }
    }
    private void setBitmapToPart(View view,int pos){
        setFadeOut(view);
        switch (pos){
            case 0:
                setFadeIn(ivPart1);
                break;
            case 1:
                setFadeIn(ivPart2);
                break;
            case 2:
                setFadeIn(ivPart3);
                break;
            case 3:
                setFadeIn(ivPart4);
                break;
        }

    }
    private void setFadeIn(View view){
        ObjectAnimator faceIn = ObjectAnimator.ofFloat(view,View.ALPHA, 0, 1);
        faceIn.setDuration(1000);
        faceIn.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        faceIn.start();
    }
    private void setFadeOut(View view){
        ObjectAnimator faceOut = ObjectAnimator.ofFloat(view,View.ALPHA, 1, 0);
        faceOut.setDuration(1000);
        faceOut.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        faceOut.start();
    }
}
