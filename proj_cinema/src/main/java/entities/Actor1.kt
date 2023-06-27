package entities

import java.time.LocalDateTime

class Actor1 {
    var name: String=""
<<<<<<< HEAD
    var lastname: String=""
=======
    lateinit var fnacimiento: LocalDateTime
>>>>>>> 6d28fbb6613758aa620b2acedd9258e3ecd756d2
    fun hello() {
        var str2 = "Geeks"
        for(i in str2.indices){
            print(str2[i]+" ")
        }
    }

    override fun toString(): String {
        return "Actor(name='$name')"
    }


}