package com.thiagoperea.pokedexplusplus.presentation

import android.content.res.Resources

fun Int.dpToPx() = (this * Resources.getSystem().displayMetrics.density).toInt()
