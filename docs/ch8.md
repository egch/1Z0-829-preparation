# Lambdas and Functional Interfaces

## Object Methods
If a functional interface includes an abstract method with
the same signature as a public method found in Object, those methods do not count toward the single abstract method test. 
## Lambda
I can't assign a lambda to a var!
```java
//  Error:
//  cannot infer type for local variable lambda
//  (lambda expression needs an explicit target-type)

var lambda = s ->s+2;
```