package com.hackathon.anikids.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.anikids.R;
import com.hackathon.anikids.adapters.AnimalAdapter;
import com.hackathon.anikids.database.DatabaseManager;
import com.hackathon.anikids.model.Animal;

import java.util.List;

public class ListAnimalsActivity extends AppCompatActivity {
    private RecyclerView rvAnimals;
    private DatabaseManager mDatabaseManager;
    private List<Animal> mListAnimals;
    private FrameLayout flFooter;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_animals);
        rvAnimals = (RecyclerView)findViewById(R.id.rv_animals);
        flFooter  = (FrameLayout)findViewById(R.id.fv_footer);

        mDatabaseManager  = DatabaseManager.getInstance(this);
        mListAnimals = mDatabaseManager.getAllAnimals();
        tvTitle = (TextView)findViewById(R.id.tv_title);
//        tvTitle.setTypeface(Typeface.createFromAsset(this.getAssets(), "fonts/VNF-Comic Sans.ttf"));
        tvTitle.setTextColor(Color.parseColor("#1abc9c"));

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (0.4f * com.hackathon.anikids.utils.Utils.getWidth(this)));
        params.gravity = Gravity.BOTTOM;
        flFooter.setLayoutParams(params);


        rvAnimals.setAdapter(new AnimalAdapter(this, mListAnimals));
        rvAnimals.setLayoutManager(new GridLayoutManager(this, 2));

        rvAnimals.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                ImageView imageView = (ImageView)holder.itemView.findViewById(R.id.imv_animal);
                imageView.setBackgroundDrawable(null);
            }
        });
    }
}
