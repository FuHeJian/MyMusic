package com.fhj.mymusic.fragment.square

import android.os.Bundle
import androidx.lifecycle.viewmodel.viewModelFactory
import com.fhj.mymusic.R
import com.fhj.mymusic.fragment.ViewInitFactory
import com.fhj.mymusic.fragment.base.BaseFragment
import com.fhj.mymusic.fragment.impl.MineInitFragmentViewCallBack
import com.fhj.mymusic.viewmodel.SquareViewModel

/**
 *
 *
 * com.fhj.mymusic.fragment.square
 */
class SquareFragment():BaseFragment() {

//    var viewModel = createViewModel(SquareViewModel::class.java)

    override fun getLayoutId() = R.layout.fragment_square

    override fun createdInitViewCallback() = ViewInitFactory.create(this,createViewModel(SquareViewModel::class.java))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}