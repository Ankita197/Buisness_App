package com.example.buisness_app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.buisness_app.JobsFragment;
import com.example.buisness_app.ListFragMent;
import com.example.buisness_app.MapFragment;

public class TabChangeAdapter extends FragmentStatePagerAdapter {
    int numberOfTabs;
    public TabChangeAdapter(@NonNull FragmentManager fm,int numberOfTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numberOfTabs=numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ListFragMent();
            case 1:
                return new MapFragment();
            case 2:
                return new JobsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
