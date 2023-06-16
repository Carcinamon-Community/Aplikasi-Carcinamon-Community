package com.hamdanfatah.carcinamoncommunitycapstone.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ArtikelModel(
    val judul: String,
    val deskripsi: String,
    val gambar: Int
): Parcelable
