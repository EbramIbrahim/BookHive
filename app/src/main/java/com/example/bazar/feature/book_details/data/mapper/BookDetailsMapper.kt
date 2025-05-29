package com.example.bazar.feature.book_details.data.mapper

import com.example.bazar.feature.book_details.data.model.ImageLinks
import com.example.bazar.feature.book_details.data.model.VolumeInfo
import com.example.bazar.feature.book_details.domain.model.BookDetails
import com.example.bazar.feature.book_details.domain.model.BookImages


fun ImageLinks.toBookImages(): BookImages {
    return BookImages(
        smallThumbnail = this.smallThumbnail,
        thumbnail = this.thumbnail
    )
}

fun VolumeInfo.toBookDetails(): BookDetails {
    return BookDetails(
        authors = this.authors,
        canonicalVolumeLink = this.canonicalVolumeLink,
        contentVersion = this.contentVersion,
        description = this.description,
        bookImages = this.imageLinks.toBookImages(),
        infoLink = this.infoLink,
        language = this.language,
        maturityRating = this.maturityRating,
        pageCount = this.pageCount,
        previewLink = this.previewLink,
        printType = this.printType,
        publishedDate = this.publishedDate,
        publisher = this.publisher,
        subtitle = this.subtitle,
        title = this.title
    )
}

