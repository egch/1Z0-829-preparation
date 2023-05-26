# Class Design
## Abstract
Only instance methods can be marked abstract within a class!
Not variables, constructors, or static methods.
### Abstract & Final
Due to this incompatibility, Java does not permit a class or method to be marked both abstract and final.
```java
public abstract final class Tortoise { // DOES NOT COMPILE 
    public abstract final void walk(); // DOES NOT COMPILE
}

```
### Abstract and private Modifiers
A method cannot be marked as both abstract and private.
```java
public abstract class Whale {
    private abstract void sing(); // DOES NOT COMPILE
}
```
## Creating Immutable Objects
### Declaring an Immutable Class
1. Mark the class as final or make all of the constructors private.
2. Mark all the instance variables private and final.
3. Don’t define any setter methods.
4. Don’t allow referenced mutable objects to be modified.
5. Use a constructor to set all properties of the object, making a copy if needed.

## Override instance vs static methods
Instance method cannot override static method 

### Override/Overload private methods - wrong
There is no override/overload when the method in the parent class is marked private.

```java
//no point to mark a method private & final as private methods cannot be overridden
  private final void sayHello(){
        System.out.println("hello");
    }
```