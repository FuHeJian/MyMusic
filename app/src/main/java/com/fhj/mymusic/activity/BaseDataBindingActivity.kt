package com.fhj.mymusic.activity

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.annotation.RawRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory

/**
 *
 *
 * com.fhj.mymusic.Activity
 */
abstract class BaseDataBindingActivity:AppCompatActivity() {

    private lateinit var  viewModelProvider:ViewModelProvider
    private lateinit var initView:IInitViewCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelProvider = ViewModelProvider(this)
        onCreatedView(layoutInflater.inflate(getRootId(),null,false))
    }

    @LayoutRes
    abstract fun getRootId(): Int

    fun <T: ViewModel> createViewModel(viewModel:Class<T>):T{
        return viewModelProvider.get(viewModel)
    }

    fun moveToFront()
    {

    }

    @CallSuper
    open fun onCreatedView(view:View){
        setContentView(view)
        createdInitViewCallback().initView(view,this)
    }

    abstract fun createdInitViewCallback():IInitViewCallback

    override fun onDestroy() {
        super.onDestroy()
    }

}
