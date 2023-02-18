package com.fhj.mymusic.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
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

class HomeListAdapter(diffCallback:DiffUtil.ItemCallback<String>):BaseListAdapter<String>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return super.onCreateViewHolder(parent, viewType)
    }

}