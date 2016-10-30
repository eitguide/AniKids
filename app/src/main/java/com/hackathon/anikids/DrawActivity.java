package com.hackathon.anikids;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hackathon.anikids.dialogs.ColorPickerDialog;
import com.hackathon.anikids.utils.Utils;
import com.hackathon.anikids.widget.CanvasView;

public class DrawActivity extends AppCompatActivity {

    private static final String TAG = "DrawActivity";
    private CanvasView cvDrawView;
    private Bitmap mBitmap;
    private Button btnPickColor;
    private LinearLayout llRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        llRootView = (LinearLayout)findViewById(R.id.ll_rootview);
        cvDrawView = (CanvasView) findViewById(R.id.cv_canvas);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_draw);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, Utils.getWidth(this), Utils.getHeight(this) / 2, true);
        cvDrawView.drawBitmap(mBitmap);
        cvDrawView.setPaintStrokeWidth(Utils.dpToPx(10));
//        cvDrawView.setBaseColor(Color.parseColor("#2c3e50"));
        cvDrawView.setPaintFillColor(Color.parseColor("#2c3e50"));
        cvDrawView.setPaintStrokeColor(Color.parseColor("#2c3e50"));

        btnPickColor = (Button) findViewById(R.id.btn_pick_color);
        btnPickColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog(DrawActivity.this, Color.parseColor("#2c3e50"), new ColorPickerDialog.OnColorSelectedListener() {

                    @Override
                    public void onColorSelected(int color) {
                        ;
                        GradientDrawable drawable = (GradientDrawable) btnPickColor.getBackground();
                        drawable.setColor(color);
                        btnPickColor.setBackgroundDrawable(drawable);

                        Log.e(TAG, "onColorSelected: " + btnPickColor.getBackground());
//                        cvDrawView.setBaseColor(color);
                        cvDrawView.setPaintFillColor(color);
                        cvDrawView.setPaintStrokeColor(color);
                    }

                });
                colorPickerDialog.show();
            }
        });
    }



    @Override
    protected void onStop() {

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Thông báo")
                .setMessage("Bạn có muốn lưu hình ảnh hay không")
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                       Bitmap bitmap = Utils.getBitmapFromView(llRootView);
                        dialogInterface.dismiss();
                    }
                })

                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();

//        dialog.show();
        super.onStop();
    }
}
