package com.fhj.mymusic.theme

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.flow.flow

/**
 *
 *
 * com.fhj.mymusic.theme
 */
object ThemeUtils{

    fun setSystemStatusBar(activity: AppCompatActivity, fullScreen:Boolean, transient: Boolean){
        if(activity.lifecycle.currentState == Lifecycle.State.INITIALIZED)
        {
            var flag = 0
            if(fullScreen)
            {
                activity.window.decorView.fitsSystemWindows = false

                if(Build.VERSION_CODES.R<=Build.VERSION.SDK_INT)
                {
                    activity.window.decorView.windowInsetsController?.run {
//                        hide(WindowInsets.Type.systemBars())
                        hide(WindowInsets.Type.navigationBars())
                    }
                }
                else
                {
                    flag = flag or View.SYSTEM_UI_FLAG_FULLSCREEN

                }
            }

            if(transient)
            {
                activity.window.statusBarColor = Color.TRANSPARENT
                if(Build.VERSION_CODES.R<=Build.VERSION.SDK_INT)
                {
                    activity.window.decorView.windowInsetsController?.run{
                        setSystemBarsAppearance(WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
                        systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                    }
                }
                else
                {
                    flag = flag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }

            if(Build.VERSION_CODES.R>Build.VERSION.SDK_INT)
            {
                activity.window.decorView.systemUiVisibility = flag
            }
        }
    }

    fun setTheme(isDark:Boolean,activity: AppCompatActivity)
    {
        if(isDark)
        {


        }
        else
        {

        }
    }

}
