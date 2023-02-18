package com.fhj.mymusic.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fhj.mymusic.fragment.interf.IInitFragmentViewCallBack

/**
 *
 *
 * com.fhj.mymusic.fragment.base
 */
abstract class BaseFragment():Fragment() {

    private var mRelease = arrayListOf<Function0<Unit>>()
    private val MAXRELEASE = 5
    private lateinit var mInitViewHelper:IInitFragmentViewCallBack
    private val viewModelProvider by lazy {
        ViewModelProvider(this)
    }

    @LayoutRes
    abstract fun getLayoutId():Int



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(object: DefaultLifecycleObserver{
            override fun onDestroy(owner: LifecycleOwner) {
                mRelease.forEach{
                    it()
                }
                lifecycle.removeObserver(this)
                mRelease.clear()
            }
        })
        mInitViewHelper = createdInitViewCallback()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(getLayoutId(),container,false)
        mInitViewHelper.initView(view,this)
        return  view
    }

    abstract fun createdInitViewCallback(): IInitFragmentViewCallBack

    override fun onDestroy() {
        super.onDestroy()
    }

    fun addDetachFromFrag(f:()->Unit):Boolean
    {
        if(mRelease.size<MAXRELEASE)
        {
            mRelease.add(f)
            return true
        }
        return false
    }

    fun <T: ViewModel> createViewModel(viewModel:Class<T>):T{
        return viewModelProvider.get(viewModel)
    }

}