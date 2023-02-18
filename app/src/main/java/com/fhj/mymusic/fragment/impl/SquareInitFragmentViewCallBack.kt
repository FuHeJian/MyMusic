package com.fhj.mymusic.fragment.impl

import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fhj.mymusic.R
import com.fhj.mymusic.fragment.interf.IInitFragmentViewCallBack
import com.fhj.mymusic.fragment.base.BaseFragment
import com.fhj.mymusic.fragment.impl.adapter.BottomSheetAdapter
import com.fhj.mymusic.pojo.SongsItemData
import com.fhj.mymusic.viewmodel.HomeViewModel
import com.fhj.mymusic.viewmodel.SquareViewModel

/**
 *
 *
 * com.fhj.mymusic.fragment.impl
 */
class SquareInitFragmentViewCallBack(val viewModel: SquareViewModel) : IInitFragmentViewCallBack {
    override fun initView(view: View, frag: BaseFragment) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.bootomsheet)
        val adapter = BottomSheetAdapter(object : DiffUtil.ItemCallback<SongsItemData>() {
            override fun areItemsTheSame(oldItem: SongsItemData, newItem: SongsItemData): Boolean {
                return oldItem.name.get() == newItem.name.get()
            }

            override fun areContentsTheSame(
                oldItem: SongsItemData,
                newItem: SongsItemData
            ): Boolean {
                return oldItem.name.get() == newItem.name.get()
            }
        }, frag.viewLifecycleOwner)

        recyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        //
        adapter.submitList(mutableListOf<SongsItemData>().apply {
            repeat(20) {
                add(SongsItemData())
            }
        })

        viewModel.getRanking()
    }
}