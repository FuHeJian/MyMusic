package com.fhj.mymusic.activity.factory.impl

import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.fhj.mymusic.R
import com.fhj.mymusic.activity.IInitViewCallback
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

/**
 *
 *
 * com.fhj.mymusic.activity.factory.impl
 */

class MainInitViewCallback : IInitViewCallback {

    override fun initView(view: View, activity: AppCompatActivity) {

        val viewPager2 = view.findViewById<ViewPager2>(R.id.main_view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.main_tabNav)
        val adapter = MainFragmentStateAdapter(activity)
        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = adapter.itemCount - 1

        val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager2) { tab, position ->

            tab.text = adapter.getFragmentName(position)
            when (position) {
                0 -> {
                    tab.icon = activity.resources.getDrawable(R.mipmap.home, null)
                }
                1 -> {
                    tab.icon = activity.resources.getDrawable(R.mipmap.square, null)
                }
                2 -> {
                    tab.icon = activity.resources.getDrawable(R.mipmap.mine, null)
                }
            }
        }

        tabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT)

        tabLayoutMediator.attach()

        activity.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event.targetState == Lifecycle.State.DESTROYED) {
                    tabLayoutMediator.detach()
                    activity.lifecycle.removeObserver(this)
                }
            }
        })

//TODO
/*        viewPager2.setPageTransformer(object : ViewPager2.PageTransformer {

            override fun transformPage(page: View, position: Float) {
                val MIN_SCALE = 0.85f
                val MIN_ALPHA = 0.5f
                view.apply{
                    val pageWidth = width
                    val pageHeight = height
                when {
                    position < -1 -> {

                    }
                    position <0 -> {//(-1,0)
                        val scale = 1-(1-MIN_SCALE) * Math.abs(position)

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scale
                        scaleY = scale

                        // Fade the page relative to its size.
                        alpha = scale

                    }
                    position == 0f -> {//(-1,0)
                        scaleX = 1f
                        scaleY = 1f

                        // Fade the page relative to its size.
                        alpha = 1f
                    }
                    position < 1 -> {//(0,1)
                        val scale = 1-(1-MIN_SCALE) * (1-abs(position))

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scale
                        scaleY = scale

                        // Fade the page relative to its size.
                        alpha = scale
                    }
                    abs(position) == 1f->{
                        scaleX = 1f
                        scaleY = 1f

                        // Fade the page relative to its size.
                        alpha = 1f
                    }
                    else -> {

                    }
                }
                }
            }

        })*/

    }




}