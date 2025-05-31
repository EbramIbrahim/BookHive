package com.example.bazar.core.presentation.ui

import java.util.Locale


fun langListCodeToLangName(langCode: List<String>): String {
    var languages = ""
    langCode.forEach { langCode ->
        val local = Locale(langCode)
        languages += local.getDisplayLanguage(Locale.ENGLISH)
    }
    return languages
}


fun String.langCodeToLangName(): String {
    val local = Locale(this)
    return local.getDisplayLanguage(Locale.ENGLISH)
}