package ru.skilbranch.devintensive.extensions

import ru.skilbranch.devintensive.models.User
import ru.skilbranch.devintensive.models.UserView
import ru.skilbranch.devintensive.utils.Utils

fun User.toUserView():UserView{

    val nickname =Utils.transliteration("$firstName $lastName"," ")
    val initials =Utils.toInitials(firstName,lastName)
    val status =if (lastVisit==null) "Ещё ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
    fullName = "$firstName $lastName",
        nickName = nickname,
        initials = initials,
        avatar = avatar,
        status = status

        )
}


