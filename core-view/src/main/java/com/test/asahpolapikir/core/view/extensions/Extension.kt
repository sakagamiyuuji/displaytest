package com.test.asahpolapikir.core.view.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.provider.Settings.Secure
import android.text.Html
import android.text.Spanned
import android.util.Base64
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets


/**
 * Created by Kosmas on 04/01/22.
 */
fun Int.hasMinimumSdk() = Build.VERSION.SDK_INT >= this

fun Int.hasMaximumSdk() = Build.VERSION.SDK_INT <= this

fun View.goneView() {
    this.visibility = View.GONE
}

fun View.showView() {
    this.visibility = View.VISIBLE
}

fun View.invisibleView() {
    this.visibility = View.INVISIBLE
}

// View Util
val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()


fun Int?.intToString(): String {
    return this?.toString() ?: ""
}

fun Context.getDrawableFromRes(drawableRes: Int): Drawable? {
    return ContextCompat.getDrawable(this, drawableRes)
}


