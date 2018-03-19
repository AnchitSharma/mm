package com.onistech.user.helper;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by user on 3/18/2018.
 */

public class BottomNavigationHelper {
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView,false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i <menuView.getChildCount() ; i++) {
                BottomNavigationItemView item = (BottomNavigationItemView)menuView.getChildAt(i);
                item.setShiftingMode(false);//no insepection restricted api
                // no inspection restricted api
                item.setChecked(item.getItemData().isChecked());//set once again checked value , so view will be updated
            }
        } catch (NoSuchFieldException noe) {
            noe.printStackTrace();
        }catch (IllegalAccessException ise){
            ise.printStackTrace();
        }
    }
}
