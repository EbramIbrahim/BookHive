package com.example.bazar.core.presentation.ui

import java.util.Locale


fun langCodeToLangName(langCode: List<String>): String {
    var languages = ""
    langCode.forEach { langCode ->
        val local = Locale(langCode)
        languages += local.getDisplayLanguage(Locale.ENGLISH)
    }
    return languages
}