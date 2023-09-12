# Lambdas and Functional Interfaces

## Object Methods

If a functional interface includes an abstract method with
the same signature as a public method found in Object, those methods do not count toward the single
abstract method test.

## Lambda

I can't assign a lambda to a var!!!!

```java
//  Error:
//  cannot infer type for local variable lambda
//  (lambda expression needs an explicit target-type)

var lambda=s->s+2;
```

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