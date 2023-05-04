# Operators
## Compound operators
Convert the result of the binary operation to the type of the left-hand variable (implicit casting).
Example
```java
long aLong = 2;
//aLong = 2 - 1.0;  //THIS FAILS! -incompatible types: possible lossy conversion from double to long

//compound operator applies casting automatically
aLong -=1.0;  //THIS works

```

## Arithmetic operators
_+ - / *_

The arithmetic operands are cast to int before to proceed
```java
short s=5, t=6;
//fails because s*t is an int
short result = s * t;//fails!

```