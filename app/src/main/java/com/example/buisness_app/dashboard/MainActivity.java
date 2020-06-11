package com.example.buisness_app.dashboard;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.buisness_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   private BottomNavigationView bottomNavigationView;
   private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        setClickOfBottomBar();
        fragment=new HomeFragment();
        switchFragment(new HomeFragment(),"home fragment");
    }

    private void switchFragment(Fragment fragment, String home_fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,home_fragment).addToBackStack(null).commit();
    }

    private void setClickOfBottomBar() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.page_1:
                        fragment=new HomeFragment();
                        switchFragment(new HomeFragment(),"home Fragment");
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
       super.onBackPressed();

    }
}
