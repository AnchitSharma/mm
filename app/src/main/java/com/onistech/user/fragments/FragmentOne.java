package com.onistech.user.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.onistech.user.adapter.Pageradapter;
import com.onistech.user.moranmandi.R;

/**
 * Created by user on 3/18/2018.
 */

public class FragmentOne extends Fragment implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private TextView tvSearch;
    private ViewPager viewPager;
    private HorizontalScrollView horizontalScrollView;
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_one,container,false);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        toolbar.setLogo(R.drawable.logo);
        tabLayout = (TabLayout)view.findViewById(R.id.frag3Tab);
        viewPager = (ViewPager)view.findViewById(R.id.view_pager);
        horizontalScrollView = new HorizontalScrollView(getActivity());

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.cat1)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.cat2)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.cat3)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.cat4)));
        Pageradapter pageradapter = new Pageradapter(getChildFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageradapter);
        tabLayout.setOnTabSelectedListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }
        });


        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
