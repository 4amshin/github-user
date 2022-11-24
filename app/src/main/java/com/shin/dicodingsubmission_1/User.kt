package com.shin.dicodingsubmission_1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val fullName: String?,
    val userName: String?,
    var photo: Int,
    var photoDetail: Int,
    val repo: String?,
    val project: String?,
    val followers: String?,
    val location: String?,
    val company: String?,
    val description: String?
) : Parcelable
