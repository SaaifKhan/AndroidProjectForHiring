package com.saifkhan.ripl.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.util.Property
import android.view.Gravity
import android.view.View
import com.mancj.slideup.SlideUp
import com.mancj.slideup.SlideUpBuilder

fun scaleUp(animateView: View, scaleXValue: Float, scaleYValue: Float, animationDuration: Long) {
    val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, scaleXValue)
    val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, scaleYValue)
    val scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(animateView, scaleX, scaleY)
    scaleAnimator.repeatCount = 1
    scaleAnimator.repeatMode = ObjectAnimator.REVERSE
    scaleAnimator.duration = animationDuration
    scaleAnimator.start()
}

public fun rotater(animateView: View, angle: Float, stopAngle: Float, animationDuration: Long) {
    val animator = ObjectAnimator.ofFloat(animateView, View.ROTATION, angle, stopAngle)
    animator.duration = animationDuration
    animator.start()
}

public fun fade(animateView: View, fadeValue: Float, animationDuration: Long) {
    val animator = ObjectAnimator.ofFloat(animateView, View.ALPHA, fadeValue)
    animator.duration = animationDuration
    animator.repeatCount = 1
    animator.repeatMode = ObjectAnimator.REVERSE
    animator.start()
}

public fun translater(
    animateView: View, translator: Property<View, Float>,mode:Int,
    distance:Float,
    animationDuration: Long) {
    val animator = ObjectAnimator.ofFloat(animateView, translator, distance)
    animator.repeatCount = 1
    animator.repeatMode = mode
    animator.duration = animationDuration
    animator.start()
}

public fun progressBar(progress:View,startValue:Int,stopValue:Int){
    val objectAnimator = ObjectAnimator.ofInt(progress,"progress",startValue,stopValue)
    objectAnimator.duration = 1000
    objectAnimator.start()
}

private fun ObjectAnimator.disableViewDuringAnimation(view: View) {
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationStart(animation: Animator?) {
            view.isEnabled = false
        }

        override fun onAnimationEnd(animation: Animator?) {
            view.isEnabled = true
        }
    })
}


fun initialisingAnimateBottomSheetSlider(view: View): SlideUp {
    return SlideUpBuilder(view)
        .withStartState(SlideUp.State.HIDDEN)
        .withStartGravity(Gravity.BOTTOM)
        .withGesturesEnabled(false)
        .withListeners(object : SlideUp.Listener.Events {
            override fun onVisibilityChanged(visibility: Int) {}
            override fun onSlide(percent: Float) {}
        })
        .build()
}