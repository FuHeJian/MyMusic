package com.fhj.mymusic.adapter.interf

/**
 *
 *
 * com.fhj.mymusic.adapter.`interface`
 */
interface IBaseListAdapter<T> {

    fun addItem(item:T)

    fun addItem(item:T,index:Int)

    fun addItem(items:List<T>)

    fun removeItem(item: T)

    fun removeAll()

}