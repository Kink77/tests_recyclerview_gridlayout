package com.example.testrecyclerview

import android.content.res.Resources
import android.util.TypedValue

fun Int.fromDPToPixel() : Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()
}