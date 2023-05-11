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

## Bitwise operator ~
```java
int x = 8;
int y =~x; //-9
```
Alternatively, you can use the following formula to calculate the 2's complement of an integer x:

-(x + 1)

For example, to find the 2's complement of the integer 8, we can use this formula as follows:

-(8 + 1) = -9

### Trick for binary
0000  0   
0001  1 

but going back   
0001   1   
0000   0   
1111  -1