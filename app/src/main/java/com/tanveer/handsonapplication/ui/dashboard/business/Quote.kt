package com.tanveer.handsonapplication.ui.dashboard.business

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quote(
    val count: Int? = null,
    val lastItemIndex: Int? = null,
    val page: Int? = null,
    val results: List<Result>? = null,
    val totalCount: Int? = null,
    val totalPages: Int? = null,
) : Parcelable

@Parcelize
data class Result(
    val _id: String? = null,
    val author: String? = null,
    val content: String? = null,
    val tag: List<String>? = null,
    val authorSlug: String? = null,
    val dateAdded: String? = null,
    val dateModified: String? = null,
    val length: Int? = null,
) : Parcelable