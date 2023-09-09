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
public final interface Walk {}  //does not compile

```

## Sealed
### Sealed interfaces
A sealed interface restricts which subclasses may implement it.
###  Sealed Classes
The permits clause is optional if the subclass is nested or declared in the same file.

## Default Methods
First, if a class or interface inherits two interfaces containing default methods with the same signature, it must override the method with its own implementation. 