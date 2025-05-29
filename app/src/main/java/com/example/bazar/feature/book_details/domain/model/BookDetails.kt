package com.example.bazar.feature.book_details.domain.model

data class BookDetails(
    val authors: List<String>,
    val canonicalVolumeLink: String,
    val contentVersion: String,
    val description: String,
    val bookImages: BookImages,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val pageCount: Int,
    val previewLink: String,
    val printType: String,
    val publishedDate: String,
    val publisher: String,
    val subtitle: String,
    val title: String
)
data class BookImages(
    val smallThumbnail: String,
    val thumbnail: String,
)
