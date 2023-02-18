package com.fhj.mymusic.fragment.home

import com.fhj.mymusic.R
import com.fhj.mymusic.fragment.ViewInitFactory
import com.fhj.mymusic.fragment.base.BaseFragment
import com.fhj.mymusic.fragment.impl.HomeInitFragmentViewCallBack
import com.fhj.mymusic.viewmodel.HomeViewModel
import com.fhj.mymusic.viewmodel.SquareViewModel

/**
 *
 *
 * com.fhj.mymusic.fragment
 */

class HomeFragment: BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_home

    override fun createdInitViewCallback()= ViewInitFactory.create(this,createViewModel(HomeViewModel::class.java))

}