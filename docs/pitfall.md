# Pitfalls and Tips
## Watch out
- **case** is a reserved keyword in java
- mind the **IOException** when you use t*ry with resources*
- JDBC: PreparedStatement will use the existing parameter set if you don’t replace it.
- Mind the type used in lambda, there ain't auto boxing. Options D and E are incorrect because the type is Integer in the predicate and int in the lambda.

## I/O
- mind the checked exception within lambda, example: toRealPath()
- mark, check if the stream supports mark: inputStream.markSupported()
- What I/O classes to use? Reader/Writer for text, Stream for primitives and String values
- Check if the System.out or System.err is closed within the try-with-resource
- in the try-with-resources check curly parenthesis is used, not brackets

## Concurrency
- the Concurrent classes order read/write access such that access to the class is consistent 
across all threads and processes, while the synchronized classes do not. 
- Future.get() throws  InterruptedException and a  ExecutionException, and they block execution 
- scheduled methods: newScheduledThreadPool(10)/newSingleThreadScheduledExecutor()

## Stream
-  IntSummaryStatistics, not IntegerSummaryStatistics. 
-  Do not confuse IntStream with Stream<Integer>
- Stream.concat(s1, s2) works only with 2 streams
- Optional.orElseThrow()
- `IntSummaryStatistics` not ~~IntegerSummaryStatistics~~
## Lambda
- `var x = ()->"hello"` does not compile! - you cannot assign a lambda to a var
- check the right symbol! it's -> NOT =>

## Various
- check if a field is final in the code
- `enum`: check if the constructor is private, or protected!
- `switch` expression: You CANNOT use `return`;
- `instanceOf` : a class can always be an instance of an Interface, so the instanceOf in that case is allowed.
- variable names: _ can be allowed but 

## Interfaces
- default method: `Plant.super.leaves()` NOT ~~super.Plant.leaves()~~
## Classes
- if there is an abstract method  makes sure the class is declared `abstract`.
### Nested Classes
- A local class can access only **final** and **effectively final** local variables
- anonymous class needs to have semicolon at the end
## Exception
- Check if the variable for the exception, **e**, is not already defined
- check that main throws the checked exception declared in the method
  - especially with the AutoClosable resources

## JDBC
- ResultSet rs: `rs.next()` NOT ~~rs.hasNext()~~
- ResultSet.getInt(1) NOT ~~ResultSet.getInteger(1)~~
- watch out the overlap of conn.savepoint() and conn.rollback()