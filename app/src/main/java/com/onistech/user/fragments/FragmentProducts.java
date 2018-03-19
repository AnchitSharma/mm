package com.onistech.user.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onistech.user.Dashboard;
import com.onistech.user.adapter.RecyclerAdapter;
import com.onistech.user.adapter.RecyclerTouchListener;
import com.onistech.user.model.CardItem;
import com.onistech.user.moranmandi.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentProducts extends Fragment {


    private RecyclerView productsList;
    private RecyclerAdapter adapter;
    private View view;
    private List<CardItem> itemList;
    private OnRecyclerItemClick itemClick;

    public interface OnRecyclerItemClick{
        public void onClick(int position,String proUrl);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        itemClick = (Dashboard)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products,container,false);
        setBanners();
        initView();
        return view;
    }

    private void initView(){

        productsList = (RecyclerView)view.findViewById(R.id.products_view);

        itemList = new ArrayList<>();


        adapter = new RecyclerAdapter(getActivity(), itemList);
        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(),2);
        productsList.setLayoutManager(lm);
//      productsList.addItemDecoration(new GridSpacingItemDecoration(2, dpTopx(10),true));
        productsList.setItemAnimator(new DefaultItemAnimator());
        productsList.setAdapter(adapter);
        productsList.setNestedScrollingEnabled(false);
        productsList.setFocusable(false);// disables the recycler view to gain focus.


        prepareItems();
        setListener();
    }

    private void setListener(){
        productsList.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), productsList,
                new RecyclerTouchListener.ClickListener(){

                    @Override
                    public void onClick(View view, int position) {
                       itemClick.onClick(position,"");
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
    }
    private void setBanners(){


    }
    private int dpTopx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,r.getDisplayMetrics()));
    }

    private void prepareItems() {
        int [] covers = new int[]{
                R.drawable.item1,
                R.drawable.item2,
                R.drawable.item3,
                R.drawable.item4,R.drawable.item5,
                R.drawable.item6,R.drawable.item7,R.drawable.item8
        };
        CardItem item1 = new CardItem("Ajio.com",covers[0]);
        itemList.add(item1);
        item1 = new CardItem("Sand Block",covers[1]);
        itemList.add(item1);
        item1 = new CardItem("Bricks",covers[2]);
        itemList.add(item1);
        item1 = new CardItem("Steel",covers[3]);
        itemList.add(item1);
        item1 = new CardItem("Gitti",covers[4]);
        itemList.add(item1);
        item1 = new CardItem("Red Sand ",covers[5]);
        itemList.add(item1);
        item1 = new CardItem("Cement",covers[6]);
        itemList.add(item1);
        item1 = new CardItem("Steels",covers[7]);
        itemList.add(item1);
        adapter.notifyDataSetChanged();
    }
}
