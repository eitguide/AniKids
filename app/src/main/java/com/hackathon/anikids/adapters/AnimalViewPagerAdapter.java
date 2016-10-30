package com.hackathon.anikids.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hackathon.anikids.fragments.AnimalFragment;
import com.hackathon.anikids.model.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyennghia on 10/29/16.
 */
public class AnimalViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragment;

    public AnimalViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragment = new ArrayList<>();
    }

    public void addFragment(Fragment fragment) {
        if (mFragment != null) {
            mFragment.add(fragment);
        }
    }

    public void addAllAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            mFragment.add(AnimalFragment.newInstance(animal));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
