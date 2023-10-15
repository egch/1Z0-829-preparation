# Pitfalls and Tips
## Watch out
- **case** is a reserved keyword in java
- mind the **IOException** when you use t*ry with resources*
- JDBC: PreparedStatement will use the existing parameter set if you don’t replace it.
- Mind the type used in lambda, there ain't auto boxing. Options D and E are incorrect because the type is Integer in the predicate and int in the lambda.