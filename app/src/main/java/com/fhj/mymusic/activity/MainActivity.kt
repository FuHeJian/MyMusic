package com.fhj.mymusic.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.AttributeSet
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.viewpager2.widget.ViewPager2
import com.fhj.mymusic.BR
import com.fhj.mymusic.R
import com.fhj.mymusic.activity.factory.impl.MainInitViewCallback
import com.fhj.mymusic.adapter.BaseFragmentStateAdapter
import com.fhj.mymusic.service.PlayService
import com.fhj.mymusic.theme.ThemeUtils
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 *
 *
 * com.fhj.mymusic.activity 付和健 音乐项目
 */
class MainActivity:BaseDataBindingActivity() {

    override fun getRootId() = R.layout.layout_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreatedView(view: View) {
        super.onCreatedView(view)
        ThemeUtils.setSystemStatusBar(this,true,true)
    }

    override fun createdInitViewCallback()=MainInitViewCallback()

}