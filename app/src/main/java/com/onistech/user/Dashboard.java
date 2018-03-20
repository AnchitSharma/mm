package com.onistech.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onistech.user.adapter.DrawerListAdapter;
import com.onistech.user.fragments.BaseFragment;
import com.onistech.user.model.DataModel;
import com.onistech.user.moranmandi.R;

/**
 * Created by user on 3/16/2018.
 */

public class Dashboard extends AppCompatActivity {

    private String[] navigationMenu;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        navigationMenu = getResources().getStringArray(R.array.navigation_drawer_items_array);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerList = (ListView)findViewById(R.id.left_drawer);
        setUpToolbar();
        fragmentManager = getSupportFragmentManager();
        DataModel[] drawerItem = new DataModel[3];
        drawerItem[0] = new DataModel(R.mipmap.ic_launcher_round,"Order");
        drawerItem[1] = new DataModel(R.mipmap.ic_launcher_round,"iTrack");
        drawerItem[2] = new DataModel(R.mipmap.ic_launcher_round,"Sales Entry");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerListAdapter adapter = new DrawerListAdapter(this,R.layout.list_view_item_row,drawerItem);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        setupDrawerToggle();
        drawerLayout.setDrawerListener(drawerToggle);
        selectItem(0);
    }


    private class DrawerItemClickListener implements  ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    private void selectItem(int position){
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = BaseFragment.getInstance("Home");
                break;
            case 1:
                fragment = BaseFragment.getInstance("iTrack");
                break;
            case 2:
                fragment = BaseFragment.getInstance("Sales Entry");
                break;

        }
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.commit();
        drawerList.setItemChecked(position, true);
        drawerList.setSelection(position);
        setTitle(navigationMenu[position]);
        drawerLayout.closeDrawer(drawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        getSupportActionBar().setTitle(title);
    }

    private void setUpToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setupDrawerToggle(){
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerToggle.syncState();
    }
}
