package ru.skilbranch.devintensive.models

import ru.skilbranch.devintensive.utils.Utils
import java.util.*

data class User (val id: String,
            var firstName: String?,
            var lastName: String?,
            var avatar: String?,
            var rating: Int = 0,
            var respect: Int = 0,
            val lastVisit: Date? = null,
            val isOnline: Boolean = false,
            var fullNameMy:String="$firstName $lastName !!!"
)

{
//    var introBit:String

    constructor(id: String, firstName: String?,  lastName: String?)   : this(
        id=id,
        firstName=firstName,
        lastName=lastName,
        avatar=null)

    constructor(id:String):this(id,"John","Doe")

    init {
//        introBit=getIntro()
        println("It's Alive!!! \n${if (lastName==="Doe") 
            "His name id $firstName $lastName" else "And his name is $firstName $lastName !!!"}\n ")
    }

   /* private fun getIntro()="""
        tu tu ru tuuuu !!!
         tu tu ru tuuuuuuuuuu ...
         
        $firstName $lastName
    """.trimIndent()*/

    /*fun printMe()=
        println("""
                id: $id:
                firstName: $firstName:
                lastName: $lastName: 
                avatar:  $avatar: 
                rating:  $rating: 
                respect: $respect:
                lastVisit: $lastVisit:
                isOnline: $isOnline: 
        """.trimIndent())*/

    companion object Factory{
        private var lastId : Int=-1
        fun makeUser(fullName: String?):User{
            lastId++

            val (firstName,lastName)=Utils.parseFullName(fullName)

            return User(id = "$lastId",firstName = firstName,lastName =lastName )
        }
    }


}