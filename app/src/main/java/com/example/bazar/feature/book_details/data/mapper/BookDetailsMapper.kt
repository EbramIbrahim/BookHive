package com.example.bazar.feature.book_details.data.mapper

import com.example.bazar.feature.book_details.data.model.VolumeInfo
import com.example.bazar.feature.book_details.domain.model.BookDetails


fun VolumeInfo.toBookDetails(): BookDetails {
    return BookDetails(
        authors = this.authors ?: emptyList(),
        canonicalVolumeLink = this.canonicalVolumeLink.orEmpty(),
        contentVersion = this.contentVersion.orEmpty(),
        description = this.description.orEmpty(),
        thumbnail = fixGoogleBooksUrl(this.imageLinks?.thumbnail.orEmpty()),
        infoLink = this.infoLink.orEmpty(),
        language = this.language.orEmpty(),
        maturityRating = this.maturityRating.orEmpty(),
        pageCount = this.pageCount ?: 0,
        previewLink = this.previewLink.orEmpty(),
        printType = this.printType.orEmpty(),
        publishedDate = this.publishedDate.orEmpty(),
        publisher = this.publisher.orEmpty(),
        subtitle = this.subtitle.orEmpty(),
        title = this.title.orEmpty()
    )
}

private fun fixGoogleBooksUrl(url: String): String {
    return url.replace("http://", "https://")
}