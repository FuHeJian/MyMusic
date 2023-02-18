package com.fhj.mymusic.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

/**
 * com.fhj.mymusic.customview
 */
public class ViewPager2FrameLayoutHost extends FrameLayout {


    public ViewPager2FrameLayoutHost(@NonNull Context context) {
        this(context, null);
    }

    public ViewPager2FrameLayoutHost(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPager2FrameLayoutHost(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ViewPager2FrameLayoutHost(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        handleInterceptTouchEvent(ev);
        return super.onInterceptTouchEvent(ev);
    }

    private void handleInterceptTouchEvent(MotionEvent e) {
        switch (e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                ViewGroup viewPager2 = findViewPager2();
                if(viewPager2!=null)
                {
//                    只在Down中请求就可以
                    viewPager2.requestDisallowInterceptTouchEvent(true);
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {

            }
        }
    }

    private ViewPager2 findViewPager2()
    {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child  = getChildAt(i);
            if(child instanceof ViewPager2)
            {
                return (ViewPager2)child;
            }
        }
        return null;
    }

}
