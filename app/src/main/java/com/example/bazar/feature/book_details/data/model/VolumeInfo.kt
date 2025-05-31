package com.example.bazar.feature.book_details.data.model

data class VolumeInfo(
    val authors: List<String>? = null,
    val canonicalVolumeLink: String? = null,
    val contentVersion: String? = null,
    val description: String? = null,
    val imageLinks: ImageLinks? = null,
    val infoLink: String? = null,
    val language: String? = null,
    val maturityRating: String? = null,
    val pageCount: Int? = null,
    val previewLink: String? = null,
    val printType: String? = null,
    val publishedDate: String? = null,
    val publisher: String? = null,
    val subtitle: String? = null,
    val title: String? = null
)