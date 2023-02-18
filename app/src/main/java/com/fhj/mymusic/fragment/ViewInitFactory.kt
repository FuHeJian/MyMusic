package com.fhj.mymusic.fragment

import android.view.View
import androidx.fragment.app.Fragment
import com.fhj.mymusic.fragment.base.BaseFragment
import com.fhj.mymusic.fragment.home.HomeFragment
import com.fhj.mymusic.fragment.impl.HomeInitFragmentViewCallBack
import com.fhj.mymusic.fragment.impl.MineInitFragmentViewCallBack
import com.fhj.mymusic.fragment.impl.SquareInitFragmentViewCallBack
import com.fhj.mymusic.fragment.interf.IInitFragmentViewCallBack
import com.fhj.mymusic.fragment.mine.MineFragment
import com.fhj.mymusic.fragment.square.SquareFragment
import com.fhj.mymusic.viewmodel.BaseViewModel
import com.fhj.mymusic.viewmodel.HomeViewModel
import com.fhj.mymusic.viewmodel.MineViewModel
import com.fhj.mymusic.viewmodel.SquareViewModel

/**
 *
 *
 * com.fhj.mymusic.fragment
 */
object ViewInitFactory {

    fun create(frag:Fragment,viewModel: BaseViewModel):IInitFragmentViewCallBack{
        return when(frag)
        {
            is HomeFragment->{
                HomeInitFragmentViewCallBack(viewModel as HomeViewModel)
            }

            is SquareFragment ->{
                SquareInitFragmentViewCallBack(viewModel as SquareViewModel)
            }

            is MineFragment->{
                MineInitFragmentViewCallBack(viewModel as MineViewModel)
            }
            else->{
                DefaultInitFragmentViewCallBack
            }
        }
    }

    private object DefaultInitFragmentViewCallBack:IInitFragmentViewCallBack{
        override fun initView(view: View, frag: BaseFragment) {

        }
    }



}