# Operators

## Casting
### Dangerous Cast
```java
void dangerousCast() {
    int[][] array = {{1,2,3}, {2}};
    //keep in mind that int[] is an object;
    Object[] arrObj = array;
    //compiles but exception at runtime
    //Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
    arrObj[0] = "hello";
}
```
## Compound operators
Convert the result of the binary operation to the type of the left-hand variable (implicit casting).
Example
```java
long aLong = 2;
//aLong = 2 - 1.0;  //THIS FAILS! -incompatible types: possible lossy conversion from double to long

//compound operator applies casting automatically
aLong -=1.0;  //THIS works

```
### Compound operators — tricky
```jshelllanguage
jshell> long x = 5L
    x ==> 5

    jshell> x = x +3.4
    |  Error:
    |  incompatible types: possible lossy conversion from double to long
    |  x = x +3.4
    |      ^----^

    jshell> x -=3.4
    $20 ==> 1
```

## Arithmetic operators
`+ - / *`

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

`-(x + 1)`

For example, to find the 2's complement of the integer 8, we can use this formula as follows:

`-(8 + 1) = -9`

### Trick for binary
0000  0   
0001  1 

but going back   
0001   1   
0000   0   
1111  -1

## Numeric Promotion Rules

1. If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
2. If one of the values is integral (intero IT) and the other is floating-point, Java will automatically promote the integral value to the floating-point value's data type.
3. Smaller data types, namely, byte, short, and char, are first promoted to int any time they're used with a Java binary arithmetic operator with a variable (as opposed to a value), even if neither of the operands is int.
4. After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands.

## LHS vs RHS
in the statement:  
```java
int x = 5;   
```

the terms "left-hand side" (LHS) and "right-hand side" (RHS) refer to specific parts of the assignment.

Left-hand side (LHS): This refers to the variable that is being assigned a value. In your example, x is the LHS because it's the variable that will store the value.

Right-hand side (RHS): This refers to the value that is being assigned to the variable. In your example, 5 is the RHS because it's the value that is assigned to the variable x.

So, to summarize:

LHS: x
RHS: 5

## Primitive assignment
```java
int x = 5;
//allowed
double d = x;
//not allowed
x = d;
```

## Java Operator Precedence
In increasing order, lowest to the highest

| Operator             | Description                              | Evaluation Order    |
|----------------------|------------------------------------------|---------------------|
| Postfix              | `expr++ expr--`                          | Left to Right       |
| Unary                | `++expr --expr +expr -expr ~ !`          | Right to Left       |
| Cast                 | `(type)`                                 | Right to Left       |
| Multiplicative       | `* / %`                                  | Left to Right       |
| Additive             | `+ -`                                    | Left to Right       |
| Shift                | `<< >> >>>`                              | Left to Right       |
| Relational           | `< > <= >= instanceof`                   | Left to Right       |
| Equality             | `== !=`                                  | Left to Right       |
| Bitwise AND          | `&`                                      | Left to Right       |
| Bitwise XOR          | `^`                                      | Left to Right       |
| Bitwise OR           | `|`                                      | Left to Right       |
| Logical AND          | `&&`                                     | Left to Right       |
| Logical OR           | `||`                                     | Left to Right       |
| Conditional          | `? :`                                    | Right to Left       |
| Assignment           | `= += -= *= /= %= &= ^= |= <<= >>= >>>=` | Right to Left       |
| Comma                | `,`                                      | Left to Right       |


## Instanceof
### null case
null instanceof T: **always false**
```java
//it always returns false
if(null instanceof String){
  System.out.println("It's null");
}
```
T instanceof null: **DOES NOT COMPILE!**
```java
Object object = new String("A");
//this does not compile!
// if(object instanceof null){}
```
## Primitive types (CGPT)
| Primitive Type | Size (in bits) | Signed/Unsigned | Range                                 |
|-----------------|-----------------|------------------|---------------------------------------|
| `byte`          | 8               | Signed           | -128 to 127                           |
| `short`         | 16              | Signed           | -32,768 to 32,767                     |
| `int`           | 32              | Signed           | -2^31 to 2^31 - 1                     |
| `long`          | 64              | Signed           | -2^63 to 2^63 - 1                     |
| `float`         | 32              | Signed           | IEEE 754 single-precision floating-point |
| `double`        | 64              | Signed           | IEEE 754 double-precision floating-point |
| `char`          | 16              | Unsigned         | 0 to 65,535 (Unicode characters)      |
| `boolean`       | Not precisely defined1 | N/A            | `true` or `false`                     |

1. The size of a `boolean` type is not precisely defined in terms of bits, as it depends on the JVM implementation. However, it is typically represented as a single byte.
