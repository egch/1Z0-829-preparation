# Beyond Classes

## Interface

```java
public abstract interface Run { //abstract implicit modifiers

  public abstract void run();  //public abstract implicit modifiers
}
```

Concise form:

```java
public interface Run {

  public void run();
}
```

An interface cannot be marked as final

```java
//does not compile
public final interface Walk {}

```

Interface variables are implicitly public, static, final.

```java
public interface Weight {
  int max_weight = 5;
  public static final int max_height = 50;  
}  

```

### Override

_@Override_ annotation informs the compiler that the element is meant to override an element declared
in a superclass. While **it is not required** to use this annotation when overriding a method, it helps
to prevent errors.

## Sealed

### Sealed interfaces

A sealed interface restricts which subclasses may implement it.
```java
public sealed interface SealedInterface permits SealedInterfaceImpl {}

//other file
public final class SealedInterfaceImpl implements SealedInterface {}

```

### Sealed Classes

The permits clause is optional if the subclass is nested or declared in the same file.

## Default Methods

First, if a class or interface inherits two interfaces containing default methods with the same
signature, it must override the method with its own implementation. 