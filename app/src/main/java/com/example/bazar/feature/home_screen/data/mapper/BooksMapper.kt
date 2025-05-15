package com.example.bazar.feature.home_screen.data.mapper

import com.example.bazar.feature.home_screen.data.model.Result
import com.example.bazar.feature.home_screen.domain.model.Books


fun Result.toBooks(): Books {
    return Books(
        bookshelves = this.bookshelves,
        copyright = this.copyright,
        downloadCount = this.download_count,
        id = id,
        languages = this.languages,
        mediaType = this.media_type,
        subjects = this.subjects,
        title = this.title,
        bookImage = this.formats.image.orEmpty()
    )
}