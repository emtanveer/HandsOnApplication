package com.tanveer.handsonapplication.ui.dashboard.data.entities

import com.google.gson.annotations.SerializedName

data class QuoteEntity(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("lastItemIndex") val lastItemIndex: Int? = null,
    @SerializedName("page") val page: Int? = null,
    @SerializedName("results") val results: List<ResultEntity>? = null,
    @SerializedName("totalCount") val totalCount: Int? = null,
    @SerializedName("totalPages") val totalPages: Int? = null,
)

data class ResultEntity(
     @SerializedName("_id") val _id: String? = null,
     @SerializedName("author") val author: String? = null,
     @SerializedName("content") val content: String? = null,
     @SerializedName("tag") val tag: List<String>? = null,
     @SerializedName("authorSlug") val authorSlug: String? = null,
     @SerializedName("dateAdded") val dateAdded: String? = null,
     @SerializedName("dateModified") val dateModified: String? = null,
     @SerializedName("length") val length: Int? = null,
)