package com.onistech.user.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onistech.user.moranmandi.R;

/**
 * Created by user on 3/19/2018.
 */

public class BaseFragment extends Fragment {

    private View view;
    private TextView tvLabel;
    public static Fragment getInstance(String label){
        BaseFragment fragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("label",label);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_base,container,false);
        Bundle bundle = getArguments();
//        tvLabel = (TextView)view.findViewById(R.id.label);
//        tvLabel.setText(bundle.getString("label"));
        return view;
    }
}
