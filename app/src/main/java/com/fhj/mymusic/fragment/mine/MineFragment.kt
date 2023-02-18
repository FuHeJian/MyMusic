package com.fhj.mymusic.fragment.mine

import android.os.Bundle
import com.fhj.mymusic.R
import com.fhj.mymusic.fragment.ViewInitFactory
import com.fhj.mymusic.fragment.base.BaseFragment
import com.fhj.mymusic.fragment.impl.MineInitFragmentViewCallBack
import com.fhj.mymusic.viewmodel.MineViewModel

/**
 *
 *
 * com.fhj.mymusic.fragment.mine
 */
class MineFragment: BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_mine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun createdInitViewCallback()= ViewInitFactory.create(this,createViewModel(MineViewModel::class.java))

}