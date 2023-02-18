package com.fhj.mymusic.activity.factory.`interface`

import android.view.View
import androidx.annotation.LayoutRes

/**
 *
 *
 * com.fhj.mymusic.activity.factory.`interface`
 */
interface IViewProvider {

    abstract fun getRootView(@LayoutRes id:Int): View

}