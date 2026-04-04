package com.example.foodapp_kotlin.ui.utils

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.foodapp_kotlin.R

@DrawableRes
fun imageResForName(context: Context, name: String): Int {
    if (name.isBlank()) return R.drawable.food_italian
    val res = context.resources.getIdentifier(name, "drawable", context.packageName)
    return if (res != 0) res else R.drawable.food_italian
}
