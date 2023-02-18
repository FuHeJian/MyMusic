package com.fhj.mymusic.animator

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.animation.addListener
import java.lang.ref.WeakReference

/**
 *
 *
 * com.fhj.mymusic.animator
 */
object AnimatorUtil {


    fun createAnimatorOfFloat(target: View,properties:String,time:Long=3000L,vararg value:Float,repeatCont:Int,onEnd:()->Unit):ObjectAnimator {
        return ObjectAnimator.ofFloat(target, properties, *value).apply {
            interpolator = LinearInterpolator()
            repeatCount = repeatCont
            repeatMode = ValueAnimator.REVERSE
            duration = time
            addListener(onEnd = {
                onEnd()
                this.removeAllListeners()
            })
        }
    }

}