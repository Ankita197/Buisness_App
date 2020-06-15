package com.example.buisness_app.dashboard;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.buisness_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   private BottomNavigationView bottomNavigationView;
   private Fragment fragment;
   private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        setClickOfBottomBar();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment(),"home fragment")
                .addToBackStack("home fragment").commit();

    }

    private void switchFragment(Fragment fragment, String home_fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,home_fragment).commit();
    }

    private void setClickOfBottomBar() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mSelectedItem=menuItem.getItemId();
                switch (menuItem.getItemId()){
                    case R.id.page_1:
                       switchFragment(new HomeFragment(),"home fragment");
                       return true;
                    case R.id.page_2:
                        fragment=new MainJobFragment();
                        switchFragment(new MainJobFragment(),"MainJob Fragment");
                        return true;
                    case R.id.page_3:
                        fragment=new MainAdsFragment();
                        switchFragment(new MainAdsFragment(),"Main Ads Fragment");
                        return true;
                    case R.id.page_4:
                        fragment=new ProfileFragment();
                        switchFragment(new ProfileFragment(),"profile Fragment");
                        return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();


        if (fragments == 1) {
            finish();
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 1) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

    private void selectHome() {
        MenuItem homeItem = bottomNavigationView.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {

            switchFragment(new HomeFragment(),"home Fragment");

            // Select home item
            bottomNavigationView.setSelectedItemId(homeItem.getItemId());
        } else {
            super.onBackPressed();
        }
    }

}
