package com.fhj.mymusic.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.doOnLayout
import androidx.core.view.doOnPreDraw
import com.fhj.mymusic.R
import com.fhj.mymusic.animator.AnimatorUtil

/**
 *
 *
 * com.fhj.mymusic.customview
 */
class SplashViewGroup(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    lateinit var mImageView:ImageView

    val ani by lazy {
        val ani =
            AnimatorUtil.createAnimatorOfFloat(mImageView, "translationX", 2000L, -this.width.toFloat(), this.width.toFloat(), repeatCont = 0) {
                (this.parent as ViewGroup).removeView(this)
            }
        ani
    }

    init {
        mImageView = ImageView(context)
        mImageView.setImageDrawable(resources.getDrawable(R.mipmap.mine, null))
        mImageView.layoutParams =
            LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER)
        addView(mImageView)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if(!ani.isStarted)
        {
            ani.start()
        }
    }

}