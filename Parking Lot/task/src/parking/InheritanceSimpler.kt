package parking

fun main() {
    val dog = Dog()
    dog.eat()
    println(dog.color)

}


open class Animal {
    open var color: String = "White"
    var breed: String = ""
    open fun eat() {
        println("Animal eating")
    }
}

class Dog : Animal() {
    override var color = "Brown"
    fun bark() {
        println("Bark")
    }
    override fun eat() {
        super<Animal>.eat()
        println("Dog is eating")
    }
}

class Cat : Animal() {
    var age: Int = 0
    fun meow() {
        println("Meow")
    }

    override fun eat() {
        println("Cat is eating")
    }
}