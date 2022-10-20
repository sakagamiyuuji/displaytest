package com.test.asahpolapikir.core.view.extensions

import android.content.Context
import androidx.core.content.ContextCompat

fun Context.getColorRes(colorResId: Int): Int {
    return ContextCompat.getColor(this, colorResId)
}