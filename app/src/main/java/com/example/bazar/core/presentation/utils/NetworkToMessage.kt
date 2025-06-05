package com.example.bazar.core.presentation.utils

import android.content.Context
import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.R


fun NetworkError.toMessage(context: Context): String {
    val resID = when (this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUEST -> R.string.error_too_many_requests
        NetworkError.NO_INTERNET -> R.string.error_no_internet
        NetworkError.SERVER_ERROR -> R.string.error_unknown
        NetworkError.SERIALIZATION -> R.string.error_serialization
        NetworkError.UNKNOWN -> R.string.error_unknown
    }
    return context.getString(resID)
}