package parking

fun main() {
    var dog = Dog2("Brown", "Pug")

}

open class Animal2(var color: String = "Black") {
    init {
        println("From Animal Init: $color")
    }
}

class Dog2(color: String, var breed: String) : Animal2(color){
    init {
        println("From Dog Init: $color and $breed")
    }
}
