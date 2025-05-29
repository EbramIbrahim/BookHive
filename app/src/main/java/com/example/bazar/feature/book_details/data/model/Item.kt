package com.example.bazar.feature.book_details.data.model

data class Item(
    val etag: String,
    val id: String,
    val kind: String,
    val volumeInfo: VolumeInfo
)