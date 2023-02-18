package com.fhj.mymusic.activity.factory.impl

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fhj.mymusic.adapter.BaseFragmentStateAdapter
import com.fhj.mymusic.adapter.interf.IFragmentAdapterCallback
import com.fhj.mymusic.fragment.home.HomeFragment
import com.fhj.mymusic.fragment.mine.MineFragment
import com.fhj.mymusic.fragment.square.SquareFragment

/**
 *
 *
 * com.fhj.mymusic.activity.factory.impl
 */

val callback = object :IFragmentAdapterCallback{

    val mFragmentName = arrayListOf<String>("首页","广场","我的")

    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                HomeFragment()
            }
            1->{
                SquareFragment()
            }
            2->{
                MineFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

    override fun getFragmentName(position: Int) = mFragmentName[position]

}


class MainFragmentStateAdapter(activity: AppCompatActivity):BaseFragmentStateAdapter(activity,callback) {



}