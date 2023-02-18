package com.fhj.mymusic.fragment.impl.adapter

import android.opengl.EGLSurface
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import com.fhj.mymusic.R
import com.fhj.mymusic.adapter.BaseBindingAdapter
import com.fhj.mymusic.databinding.SongsitemBinding
import com.fhj.mymusic.pojo.SongsItemData

/**
 *
 *
 * com.fhj.mymusic.fragment.impl.adapter
 */
class BottomSheetAdapter(diffCallback: DiffUtil.ItemCallback<SongsItemData>, private val lifecycleOwner:LifecycleOwner): BaseBindingAdapter<SongsItemData, SongsitemBinding>(diffCallback) {

    override fun getLayoutId(viewType: Int) = R.layout.songsitem

    override fun getLifecycleOwner() = lifecycleOwner

    override fun bindItem(
        binding: SongsitemBinding,
        item: SongsItemData,
        position: Int,
        type: Int
    ) {
        binding.data = getItem(position)
    }

}