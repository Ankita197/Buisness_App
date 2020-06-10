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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        setClickOfBottomBar();
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
                        switchFragment(new HomeFragment(),"home Fragment");
                        return true;
                    case R.id.page_2:
                        switchFragment(new MainJobFragment(),"MainJob Fragment");
                        return true;
                    case R.id.page_3:
                        switchFragment(new MainAdsFragment(),"Main Ads Fragment");
                        return true;
                    case R.id.page_4:
                        switchFragment(new ProfileFragment(),"profile Fragment");
                        return true;
                }
                return false;
            }
        });
    }


}
