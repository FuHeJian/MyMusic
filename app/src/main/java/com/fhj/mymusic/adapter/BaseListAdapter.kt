package com.fhj.mymusic.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.fhj.mymusic.adapter.interf.IBaseListAdapter
import com.fhj.mymusic.adapter.holder.BaseViewHolder
import java.util.concurrent.CopyOnWriteArrayList

/**
 *
 *
 * com.fhj.mymusic.adapter
 */
open class BaseListAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>):ListAdapter<T,BaseViewHolder>(diffCallback),
    IBaseListAdapter<T> {

    private val itemsList = CopyOnWriteArrayList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        println()
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun addItem(item:T)
    {
        itemsList.add(item)
    }

    override fun addItem(item:T, index:Int)
    {
        if(index<=currentList.size)
        {
            itemsList.addAll(currentList)
            itemsList.add(index,item)
        }
    }

    override fun addItem(items:List<T>)
    {
        if(items.isNotEmpty())
        {
            itemsList.addAll(items)
        }
    }

    fun removeItem(item: T,clearCache:Boolean)
    {
        if(currentList.contains(item))
        {
            if(clearCache)
            {
                itemsList.clear()
            }
            else
            {
                submit()
                itemsList.clear()
            }
            itemsList.addAll(currentList)
            itemsList.remove(item)
        }
    }

    override fun removeItem(item: T)
    {
        removeItem(item,true)
    }

    fun removeItem(index: Int)
    {
        removeItem(index,true)
    }

    override fun removeAll() {
        itemsList.clear()
        submitList(itemsList)
    }

    fun removeItem(index: Int, clearCache:Boolean)
    {
        if(currentList.size>index)
        {
            if(clearCache)
            {
                itemsList.clear()
            }
            else
            {
                submit()
                itemsList.clear()
            }
            itemsList.addAll(currentList)
            itemsList.removeAt(index)
        }
    }

    fun submit()
    {
        if(itemsList.size>0)
        {
            submitList(itemsList)
            itemsList.clear()
        }
    }

}