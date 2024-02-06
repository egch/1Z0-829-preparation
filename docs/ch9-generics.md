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
## Diamond Operator
```java
List<String> list = new ArrayList<>();
```
The diamond operator `<>` cannot be used on the right side of the assignment.

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
### Instance Methods
```java
 public <T> T getFirstElement(T[] array) {/*...*/}
```
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
On the right side the element should be a type whose super-class is defined as super at left side.

```java
//List<? super IOException> ioExceptions = new ArrayList<FileNotFoundException>();  //does NOT compile
List<? super IOException> ioExceptions = new ArrayList<Exception>();  //compiles
```

[Example wildcard](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/CollectionsOfGenericsWithWildcard.java)

## Inheritance of methods with generics
[Generic Methods](../src/main/java/org/enricogiurin/ocp17/book/ch9/generics/ComplexInheritanceWithGenerics.java)
