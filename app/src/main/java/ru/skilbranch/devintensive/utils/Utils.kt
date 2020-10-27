package ru.skilbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
      return Pair(firstName,lastName)
//        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val parts: List<String> =payload.split(" ")
        val firstName=parts[0]
        val lastName = parts[1]

        val firstNameT= ruToEn(firstName).capitalize()
        val lastNameT= ruToEn(lastName).capitalize()

        return firstNameT+divider+lastNameT
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        val iF:String = firstName?.take(1)?.toUpperCase() ?:""
        val iL:String = lastName?.take(1)?.toUpperCase() ?:""

        if (iF=="" && iL=="")
            return null
        return iF+iL
    }

    fun ruToEn(name:String)=
        name.toLowerCase().replace(Regex("[а-я]")){
            when(it.value){
                "а"-> "a"
                "б"-> "b"
                "в"-> "v"
                "г"-> "g"
                "д"-> "d"
                "е"-> "e"
                "ё"-> "e"
                "ж"-> "zh"
                "з"-> "z"
                "и"-> "i"
                "й"-> "i"
                "к"-> "k"
                "л"-> "l"
                "м"-> "m"
                "н"-> "n"
                "о"-> "o"
                "п"-> "p"
                "р"-> "r"
                "с"-> "s"
                "т"-> "t"
                "у"-> "u"
                "ф"-> "f"
                "х"-> "h"
                "ц"-> "c"
                "ч"-> "ch"
                "ш"-> "sh"
                "щ"-> "sh"
                "ъ"-> ""
                "ы"-> "i"
                "ь"-> ""
                "э"-> "e"
                "ю"-> "yu"
                "я"-> "ya"
                else -> it.value
            }
        }
}
