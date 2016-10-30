package com.hackathon.anikids.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hackathon.anikids.R;
import com.hackathon.anikids.adapters.AnimalViewPagerAdapter;
import com.hackathon.anikids.database.DatabaseManager;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private ViewPager vpAnimals;
    private int mCurrentIndex;

    private AnimalViewPagerAdapter mAnimalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        vpAnimals = (ViewPager) findViewById(R.id.vp_animals);
        mCurrentIndex = getIntent().getIntExtra("currentIndex", 0);
        mAnimalViewPager = new AnimalViewPagerAdapter(getSupportFragmentManager());
        mAnimalViewPager.addAllAnimals(DatabaseManager.getInstance(this).getAllAnimals());
        vpAnimals.setAdapter(mAnimalViewPager);

        vpAnimals.setCurrentItem(mCurrentIndex);
    }
}
