package com.thiagoperea.pokedexplusplus.internal.extension

import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.thiagoperea.pokedexplusplus.R

fun Snackbar.setErrorStyle(): Snackbar = apply {
    val errorBgColor = ContextCompat.getColor(context, R.color.fighting)
    setBackgroundTint(errorBgColor)
}