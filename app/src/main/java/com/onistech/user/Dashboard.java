package com.onistech.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.onistech.user.fragments.FragmentOne;
import com.onistech.user.fragments.FragmentProducts;
import com.onistech.user.helper.BottomNavigationHelper;
import com.onistech.user.moranmandi.R;


/**
 * Created by user on 3/16/2018.
 */

public class Dashboard extends AppCompatActivity implements FragmentProducts.OnRecyclerItemClick  {
    private BottomNavigationView navigationView;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        fragmentManager = getSupportFragmentManager();
        navigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationHelper.disableShiftMode(navigationView);
        setNavigationListener(navigationView);
    }

    private void setNavigationListener(BottomNavigationView navigationView) {
        navigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.action_item1:
                        fragment = new FragmentOne();
                        break;
                }

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,fragment);
                fragmentTransaction.commit();

                return true;

            }
        });

        // call homefragment here
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new FragmentOne());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(int position, String proUrl) {

    }

    @Override
    public void onBackPressed() {
        navigationView.setVisibility(View.VISIBLE);
        super.onBackPressed();
    }
}
