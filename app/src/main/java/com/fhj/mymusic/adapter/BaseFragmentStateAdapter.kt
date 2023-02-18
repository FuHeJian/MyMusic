package com.fhj.mymusic.adapter

import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fhj.mymusic.adapter.interf.IFragmentAdapterCallback

/**
 *
 *
 * com.fhj.mymusic.adapter
 */
open class BaseFragmentStateAdapter(activity: FragmentActivity,val callback: IFragmentAdapterCallback): FragmentStateAdapter(activity) {

    override fun getItemCount() = callback.getItemCount()

    override fun createFragment(position: Int)=
        callback.createFragment(position)

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    fun getFragmentName(position: Int) =  callback.getFragmentName(position)

}