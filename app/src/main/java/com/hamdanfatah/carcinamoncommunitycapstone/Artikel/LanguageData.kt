package com.hamdanfatah.carcinamoncommunitycapstone.Artikel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LanguageData(
    val tittle: String,
    val deskripsi: String,
    val logo: Int
):Parcelable
