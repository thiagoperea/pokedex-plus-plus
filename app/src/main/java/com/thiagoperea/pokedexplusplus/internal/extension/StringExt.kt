package com.thiagoperea.pokedexplusplus.internal.extension

import java.util.*

fun String.firstUppercase() = this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }