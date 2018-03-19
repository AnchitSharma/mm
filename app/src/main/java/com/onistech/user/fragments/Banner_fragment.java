package com.onistech.user.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

/**
 * Created by user on 1/5/2018.
 */

public class Banner_fragment extends Fragment {

   /* private SliderLayout sliderLayout;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.banner_fragment, container, false);
        initView();
        return view;
    }

    private void initView() {
        sliderLayout = (SliderLayout) view.findViewById(R.id.slider);
        HashMap<String, Integer> banners = new HashMap<>();
        banners.put("ban_one", R.drawable.ba_one);
        banners.put("ban_two", R.drawable.ban_two);
        banners.put("ban_three", R.drawable.ban_three);
        banners.put("ban_four", R.drawable.ban_four);

        for (String name : banners.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            //intialize a slider layout
            textSliderView.description(name)
                    .image(banners.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sliderLayout.addSlider(textSliderView);
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(4000);
            sliderLayout.requestFocus();
        }
    }*/
}
