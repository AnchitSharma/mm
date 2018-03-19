package com.onistech.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;



/**
 * Created by user on 10/4/2017.
 */

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private ClickListener clickListener;
    private GestureDetector gestureDetector;
    public interface ClickListener{
        void onClick(View view,int position);
        void onLongClick(View view, int position);
    }

    public RecyclerTouchListener(Context context, final RecyclerView rv, final ClickListener clickListener){

        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context,new
                GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        View child=rv.findChildViewUnder(e.getX(),e.getY());
                        if (child != null && clickListener !=  null){
                            clickListener.onLongClick(child,rv.getChildAdapterPosition(child));
                        }
                    }
                });
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child=rv.findChildViewUnder(e.getX(),e.getY());
        if(child!=null && clickListener!=null && gestureDetector.onTouchEvent(e)){
            clickListener.onClick(child,rv.getChildAdapterPosition(child));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
