# Collections and Generics
## Bounding Generic Types
### Upper-Bounded wildcards

```java
List<? extends Number> listOfInteger = new ArrayList<>();
//does not compile...what if is a list of AtomicInteger
//listOfInteger.add(new Integer(3));  

//does not compile...what if is a list of Integer
//listOfInteger.add(new AtomicInteger(2)); 
```
We cannot add element to a list declared s upper bounded wildcards!


### Lower-Bounded wildcards

```java
List<? super IOException> exceptions = new ArrayList<Exception>();
//
exceptions.add(new IOException("error"));// yes we can add it
exceptions.add(new FileNotFoundException("error"));// yes we can add it

//we cannot add Exception as it could be a list of IOException and Exception is not an IOException
//exceptions.add(new Exception("error"));
```
We can only add element whose type is **IOException** or one of its children.
