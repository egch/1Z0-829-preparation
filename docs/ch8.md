# Lambdas and Functional Interfaces

## Object Methods

If a functional interface includes an abstract method with
the same signature as a public method found in Object, those methods do not count toward the single
abstract method test.

## Lambda

**I can't assign a lambda to a var!!!!**

```java
//  Error:
//  cannot infer type for local variable lambda
//  (lambda expression needs an explicit target-type)

var lambda=s->s+2;
```

### Lambda boxing
```java
//does not compile
Function<Integer, Boolean> function = (int i) -> {return false;}
```
The type is Integer in the Function and int in the lambda.

### Lambda and variables effective final
Lambdas require **local variables** and **method parameters** to be effectively final to use them.
Instance and static variables can be used regardless of whether they are effectively final.
[LambdaEffectiveFinal](src/main/java/org/enricogiurin/ocp17/book/ch8/LambdaEffectiveFinal.java)
#### Rules
When using lambda expressions that access instance variables, local variables, or parameters:
* local variables **must be** effective final
* parameters **must be** effective final
* instance variables **are not subject** to the effective final constraint.

### Deferred execution
Deferred execution means the lambda expression is not evaluated until runtime, but it is compiled.  
In the context of lambdas in Java, deferred execution refers to the delayed execution of the code encapsulated within the lambda expression.

## Function

### Compose

```java
//javadoc
default<V> Function<V, R> compose(Function<? super V,?extends T>before)
```

_Returns a composed function that first applies the **before** function to its input, and then
applies this function to the result.
If evaluation of either function throws an exception, it is relayed to the caller of the composed
function._

```java
    Function<Integer, Integer> after=a->a+4;
    Function<Integer, Integer> before=a->a*3;
    Function<Integer, Integer> compose=after.compose(before);
    System.out.print(compose.apply(2));  // (2*3) + 4 = 10

```
## Functional Interfaces
### BooleanSupplier

```java
BooleanSupplier bs = () -> Math.random() >= 0.5;
boolean result = bs.bs.getAsBoolean();
```

It's _getAsBoolean()_ **NOT** get()