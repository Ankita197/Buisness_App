package com.example.buisness_app.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.buisness_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   private BottomNavigationView bottomNavigationView;
   private Fragment fragment;
   private int mSelectedItem;
   private boolean isFinish=false;

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
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack("home fragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);

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
                        switchFragment(fragment,"MainJob Fragment");
                        return true;
                    case R.id.page_3:
                        fragment=new MainAdsFragment();
                        switchFragment(fragment,"Main Ads Fragment");
                        return true;
                    case R.id.page_4:
                        fragment=new ProfileFragment();
                        switchFragment(fragment,"profile Fragment");
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        MenuItem homeItem = bottomNavigationView.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            bottomNavigationView.setSelectedItemId(homeItem.getItemId());
            switchFragment(new HomeFragment(),"home fragment");
        }

       else if (getFragmentManager().getBackStackEntryCount() > 1) {
                Log.d("__@__","there is fragemnt");
                getFragmentManager().popBackStack();
            }
        else if (fragments == 1) {
            finish();
        }
       else {
                super.onBackPressed();
       }
    }



}
