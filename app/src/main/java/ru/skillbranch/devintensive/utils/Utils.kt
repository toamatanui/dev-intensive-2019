package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trim()?.split(" ")
        var firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        if (firstName?.length == 0 ) {
            firstName = null
        }

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val translitData = hashMapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya"
        )

        val words: List<String> = payload.split(" ")
        val resultWords: MutableList<String> = arrayListOf()

        for (word:String in words)
        {
            var currentWord: String = ""
            word.forEach {
                val currentTranslitChars:String = translitData[it.toString().toLowerCase()] ?: it.toString()
                currentWord += if (it.isUpperCase()) currentTranslitChars[0].toUpperCase() else currentTranslitChars[0].toLowerCase()
                currentWord += if (currentTranslitChars.length > 1) currentTranslitChars.substring(1) else ""
            }
            resultWords.add(currentWord)
        }
        return resultWords.joinToString(divider)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstChar = firstName?.trim()?.getOrNull(0)?.toUpperCase()
        val lastChar = lastName?.trim()?.getOrNull(0)?.toUpperCase()
        val initials = "${firstChar ?: ""}${lastChar ?: ""}"

        return initials.ifEmpty { null }
    }
}