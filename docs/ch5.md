# Methods
## Autoboxing
### Failing cases
```java
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