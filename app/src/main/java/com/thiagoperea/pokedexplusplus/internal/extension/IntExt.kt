package com.thiagoperea.pokedexplusplus.internal.extension

import android.content.res.Resources

fun Int.dpToPx() = (this * Resources.getSystem().displayMetrics.density).toInt()
