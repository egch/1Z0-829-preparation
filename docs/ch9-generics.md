# Generics
````java
public class Money<T> {
    private T currency;
    public T createT() {
        //Type parameter 'T' cannot be instantiated directly
        // return new T();
    }
}
````
## Class and Methods with generics
```java
class Ball<X>{
  //this does not compile because X cannot be referenced from a static context
 // public static <T> void catchBall(T t, X x) {}  DOES NOT COMPILE

  //this is how we can fix it, basically we re-define X
  public static <T, X> void catchBall(T t, X x) {}

  //or make the method instance, not static:
  public <T> void catchBall2(T t, X x) {}

  //here we redefine X so the type on Ball is hidden. 
  public <X extends Number> void inflateBall(X t, X x) {}

}
```
[Class and methods with generics](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/ClassAndMethodsWithGenerics.java)

## Diamond Operator
```java
List<String> list = new ArrayList<>();
```
The diamond operator `<>` cannot be used on the left side of the assignment.

```java
HashSet<> set = new HashSet<Object>();  //does not compile!
```

## Methods with generics
### Static Methods
```java
  public static <T extends Number> void calculate(T t){}
```
WRONG: static needs to be defined before generics declaration!
```java
  public  <T extends Number> static void calculate(T t){} //does NOT compile
```

```java
private static <U extends Exception> void printMessage(U u) {
    System.out.println(u.getMessage());
}

public static void invokePrintMessage() {
    printMessage(new FileNotFoundException("not found"));
    //optional syntax for invoking a generic method
    StaticMethodGenerics.<NullPointerException>printMessage(new NullPointerException
    ("D"));
}
```
[Static Methods Generics](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/StaticMethodGenerics.java)
### Instance Methods
```java
 public <T> T getFirstElement(T[] array) {/*...*/}
```

[GenericsInClassAndMethods](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/GenericsInClassAndMethods.java)
## Instantiate with generics
[Example](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/InstantiateClassWithGenerics.java)
## Bounding Generic Types
### Upper-Bounded wildcards

```java
List<? extends Number> listOfInteger = new ArrayList<>();
//does not compile...what if it's a list of AtomicInteger
//listOfInteger.add(new Integer(3));  

//does not compile...what if it's a list of Integer
//listOfInteger.add(new AtomicInteger(2)); 
```
We cannot add an element to a list declared s upper bounded wildcards!

### Lower-Bounded wildcards
```java
List<? super IOException> exceptions = new ArrayList<Exception>();
exceptions.add(new IOException("error"));// yes we can add it
exceptions.add(new FileNotFoundException("error"));// yes we can add it

//we cannot add an Exception as it could be a list of IOException and Exception is not an IOException
//exceptions.add(new Exception("error"));
```
On the right side, the element should be a type whose super-class is defined as super at left side.

```java
//List<? super IOException> ioExceptions = new ArrayList<FileNotFoundException>();  //does NOT compile
List<? super IOException> ioExceptions = new ArrayList<Exception>();  //compiles

```

#### wildcards mutable and immutable collections
- wildcardList is immutable
- listExtends is immutable
- listSuper is mutable
```java
    List<?> wildcardList = new ArrayList<String>();  
    List<? extends IOException> listExtends = new ArrayList<FileNotFoundException>();
    List<? super IOException> listSuper = new ArrayList<Object>();
```

[Example wildcard](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/CollectionsOfGenericsWithWildcard.java)

### Bounded with Classes (not collections)
```java
  class Cage<T extends Pet> {}
  class Pet {}
  class Dog extends Pet{}
    
    
  //Cage<Pet> cagePets = new Cage<Dog>();  //DOES NOT Compile

    //upper-bounded cases
  Cage<? extends Pet> upperBounded = new Cage<Pet>();
  Cage<? extends Pet> upperBounded2 = new Cage<Dog>();
  
  //lower-bounded
  Cage<? super Pet> lowerBounded2 = new Cage<Pet>(); 
```
[Classes With Lower and Upper Bounded](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/ClassesWithWildcards.java)

## Inheritance of methods with generics
[Generic Methods](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/ComplexInheritanceWithGenerics.java)
