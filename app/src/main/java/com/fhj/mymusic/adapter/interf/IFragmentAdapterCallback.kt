package com.fhj.mymusic.adapter.interf

import androidx.fragment.app.Fragment

/**
 *
 *
 * com.fhj.mymusic.adapter.`interface`
 */
interface IFragmentAdapterCallback {

    fun getItemCount():Int

    fun createFragment(position: Int): Fragment

    fun getFragmentName(position: Int):String

}