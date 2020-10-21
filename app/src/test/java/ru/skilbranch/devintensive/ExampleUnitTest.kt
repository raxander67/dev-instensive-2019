package ru.skilbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skilbranch.devintensive.extensions.TimeUnits
import ru.skilbranch.devintensive.extensions.add
import ru.skilbranch.devintensive.extensions.format
import ru.skilbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
//        val user= User("1")
        val user2= User("2","John", "Cena")
//        val user3= User("3", "John", "Silverhand",null,lastVisit = Date(), isOnline = true)

//        user.printMe()

//        user3.printMe()

        println("$user2 ")
    }

    @Test
    fun test_factory(){
//        val user=User.makeUser("John Cenad")
//        val user1=User.makeUser("John Wick")
        val user=User.makeUser("John Wick")
        val user2=user.copy(id="2",lastName="Cena",lastVisit = Date())
        print("$user \n$user2")
    }
    @Test
    fun test_decomposition(){

        val user=User.makeUser("John Wick")
        fun getUserInfo()=user
        val(id, firstName, lastName)=getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }
    @Test
    fun test_copy(){

        val user=User.makeUser("John Wick")
        val user2=user.copy(lastVisit = Date())
        val user3=user.copy(id = "2",lastVisit = Date().add(-2,TimeUnits.SECOND))
        val user4=user.copy(lastName = "Cena",lastVisit = Date().add(2,TimeUnits.HOUR))

        /*if(user == user2){
            println("equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        }else{
            println("not equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")

        }
        if(user === user2){
            println("equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        }else{
            println("not equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")

        }*/

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())

    }
@Test
fun test_abstract_factory(){
    val user=User.makeUser("John Wick")
    val txtMessage=BaseMessage.makeMessage(user, Chat("0"),payload = "any text message", type="text")
    val imgMessage=BaseMessage.makeMessage(user, Chat("0"),payload = "any image url", type="text")

    println(txtMessage.formatMessage())
    println(imgMessage.formatMessage())



}

}