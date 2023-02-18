package com.fhj.mymusic.adapter

import android.view.ViewGroup
import android.view.ViewStub
import android.widget.ImageView
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.DiffUtil
import com.fhj.mymusic.R
import com.fhj.mymusic.adapter.holder.BaseViewHolder

/**
 *
 *
 * com.fhj.mymusic.adapter
 */
/*val diffCallback=object : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}*/

class BannerAdapter(diffCallback:DiffUtil.ItemCallback<Int>):BaseListAdapter<Int>(diffCallback) {

    var reverse = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.scaleType = ImageView.ScaleType.FIT_XY
        return BaseViewHolder(imageView)
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        (holder.itemView as ImageView).setImageResource(currentList[position])
    }



}