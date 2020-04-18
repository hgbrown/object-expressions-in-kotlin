# Object Expressions in Kotlin

Sometimes we need to create an object of some class with slight modification, 
without explicitly declaring a new subclass for it. 
In Java, this use-case is handled by creating [Anonymous Inner Class in Java](https://www.geeksforgeeks.org/anonymous-inner-class-java/)
In Kotlin, we use [object expressions](https://kotlinlang.org/docs/reference/object-declarations.html) to achieve the 
the same.

This demonstration shows how we can use object expressions to create an instance from:

- an interface
- an abstract class (with and without non-default constructors)

Finally, it demonstrates that unlike anonymous inner classes in Java where only final variables can be accessed 
from within the inner class, Kotlin object expressions allow us to access and modify non-final variables.

---