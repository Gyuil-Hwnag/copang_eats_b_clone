package com.softsquared.template.kotlin.src.mylike.model

import com.google.gson.annotations.SerializedName

data class Resultmylike(
    @SerializedName("Bookmark Store Count") val Bookmark_Store_Count: ArrayList<storecount>,
    @SerializedName("Bookmark Store") val Bookmark_Store: ArrayList<mylike>
)