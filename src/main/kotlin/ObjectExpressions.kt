import java.util.concurrent.Callable

interface Audible {
    fun makeSound(): String
}

abstract class Animal: Audible {
    abstract fun canFly(): Boolean
}

abstract class Gun(val silenced: Boolean): Audible {

    override fun makeSound(): String = if(silenced) "pew pew pew" else "BOOM BOOM BOOM"

    abstract fun shoot(): String
}


fun main() {

    // use an object expression to create an anonymous instance of an interface
    val clock = object: Audible {
        override fun makeSound(): String = "tick tock, tick tock"
    }
    println("The clock goes ${clock.makeSound()}")

    // use an object expression to create an anonymous instance of an abstract class
    val cow = object: Animal() {
        override fun canFly(): Boolean = false
        override fun makeSound(): String = "moo moo moo"
    }
    println("cow says ${cow.makeSound()} but can it fly? ${if(cow.canFly()) "Yes!" else "No!"}")

    // use an object expression to create an anonymous instance of an abstract class with a constructor
    val glock = object : Gun(silenced = true) {
        override fun shoot(): String = makeSound()
    }
    println("Shooting my ${if(glock.silenced) "silenced" else ""} gun .... ${glock.shoot()}")

    //  unlike in Java anonymous classes, Kotlin object expressions have access to non-final variables inside the expression
    var counter = 0
    val incrementer = object: Callable<Int> {
        override fun call(): Int = ++counter
    }
    println("Counter is now at: ${incrementer.call()}")

}
