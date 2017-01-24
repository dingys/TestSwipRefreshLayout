package com.example.dingyasong.testswiprefreshlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/**
 * Created by dingyasong on 2017/1/23.
 */

public class LRecyclerView extends RecyclerView {
    public LRecyclerView(Context context) {
        super(context);
    }

    public LRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        //解决LRecyclerView与CollapsingToolbarLayout滑动冲突的问题
//        AppBarLayout appBarLayout = null;
//        ViewParent p = getParent();
//        while (p != null) {
//            if (p instanceof CoordinatorLayout) {
//                break;
//            }
//            p = p.getParent();
//        }
//        if(p instanceof CoordinatorLayout) {
//            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)p;
//            final int childCount = coordinatorLayout.getChildCount();
//            for (int i = childCount - 1; i >= 0; i--) {
//                final View child = coordinatorLayout.getChildAt(i);
//                if(child instanceof AppBarLayout) {
//                    appBarLayout = (AppBarLayout)child;
//                    break;
//                }
//            }
//            if(appBarLayout != null) {
//                appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
//                    @Override
//                    public void onStateChanged(AppBarLayout appBarLayout, State state) {
//                        appbarState = state;
//                    }
//                });
//            }
//        }
//    }
}
