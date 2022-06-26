package com.thiagoperea.pokedexplusplus.data.remote

import com.google.gson.annotations.SerializedName

data class DescriptionResponse(
    @SerializedName("flavor_text_entries") val descriptionList: List<DescriptionInnerResponse>
)

data class DescriptionInnerResponse(
    @SerializedName("flavor_text") val description: String
)
