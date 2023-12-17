# Methods
## Autoboxing
### Failing cases
```shell
jshell> long p = 8
p ==> 8

jshell> Long wrapper = 8
|  Error:
|  incompatible types: int cannot be converted to java.lang.Long
|  Long wrapper = 8;
|                 ^

```
## final
```java
    void varFinal() {
        //legal
        final var x = 5;
    }
```

### Effective final
The test for effectively final is if the final modifier can be added to the local variable and the code still compiles.
## varargs
Two varargs parameters are not allowed in the same method. 

```java
//won't compile
public void bass(String... values, int... nums) {}
```

## Passing data among methods
_Java is a “pass-by-value” language. This means that a copy of the variable is made and the method receives that copy. 
Assignments made in the method do not affect the caller._

## Access to protected method. IMPORTANT!!!
```java
package a;
class A {
  protected void hello(){}
}
```

```java
package b;
class B extends A {

  public static void main(String[] args) {
    B b1 = new B();
    b1.hello(); //fine this compile!
    
    A b2 = new B();
    //THIS DOES NOT COMPILE!
    //b2.hello();  
  }
}
```
In the main method I am in the package **b**, and I am trying to access to a protected method defined in the class A (the type is A, not B)
which is in the package **a**, then a different package.
Then it does not compile!

## String to number
### parseLong
```java
var result = Long.parseLong("17")
//result is a primitive lonn
//System.out.println(result.toString()); //does not compile
```
### valueOf
```java
var result = Long.valueOf("17")
//result is a Long
System.out.println(result.toString()); //does compile!
```
```