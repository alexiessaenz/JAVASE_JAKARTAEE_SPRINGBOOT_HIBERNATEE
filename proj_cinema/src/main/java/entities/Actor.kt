package entities

class Actor {
    var name: String=""
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