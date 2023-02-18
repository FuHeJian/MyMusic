package com.fhj.mymusic.fragment.impl

import android.view.View
import androidx.cardview.widget.CardView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.fhj.mymusic.R
import com.fhj.mymusic.adapter.BannerAdapter
import com.fhj.mymusic.fragment.interf.IInitFragmentViewCallBack
import com.fhj.mymusic.fragment.base.BaseFragment
import com.fhj.mymusic.viewmodel.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.*

/**
 *
 *
 * com.fhj.mymusic.fragment.impl
 */
class HomeInitFragmentViewCallBack(val viewModel:HomeViewModel) : IInitFragmentViewCallBack {

    private val UPDATEITEM = object : java.lang.Runnable {
        override fun run() {
            runFunc()
        }
    }

    lateinit var runFunc: Function0<Unit>

    override fun initView(view: View, frag: BaseFragment) {

        val viewPager2Banner = view.findViewById<ViewPager2>(R.id.viewPager2Banner)
        val bannerAdapter = BannerAdapter(object : DiffUtil.ItemCallback<Int>() {

            override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem

        })

        val bannerImgList =
            arrayListOf(R.mipmap.banner1, R.mipmap.banner2, R.mipmap.banner3, R.mipmap.banner4)
        viewPager2Banner.offscreenPageLimit = bannerImgList.size - 1
        viewPager2Banner.adapter = bannerAdapter
        bannerAdapter.submitList(bannerImgList)

        //轮播
        runFunc = {
            var index = viewPager2Banner.currentItem
            if(index >= bannerImgList.size-1)
            {
                bannerAdapter.reverse = true
            }
            if(index==0)
            {
                bannerAdapter.reverse = false
            }
            if(bannerAdapter.reverse)
            {
                --index
            }
            else
            {
                ++index
            }
            viewPager2Banner.currentItem = index
        }

        val job = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                if (::runFunc.isInitialized) {
                    viewPager2Banner.post(UPDATEITEM)
                }
                delay(3000)
            }
        }

        //销毁释放
        frag.addDetachFromFrag {
            job.cancel("fragment销毁")
        }
    }

}