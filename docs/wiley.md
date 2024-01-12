- abstract class which implements 2 interfaces with the same default method is forced 
to implement the method! [DONE]
- increasing levels of operator precedence
- refresh Locale creation: builder/new [DONE]
- Future<Object> even when it's Future<Double> [DONE]
- number of classes extending sealed class
- double check this List<?>  [DONE]
- [module] ServiceLoader.load(Mouse.class)  [DONE]
- methods of Deque [DONE]
- pattern matching [DONE]
- DoubleToLongFunction [DONE]
- Comparator thenComparing reversed [DONE]

- class with a generic method [DONE]
- jlink --output ( no abbreviation) [DONE]
- LocalTime with 4 parameters [DONE]
- StringBuilder.insert() but NOT ~~String.insert()~  [DONE]

- In an unnamed module, a sealed class must include all its subclasses within the same package.
- I/O - Files.createDirectories and not Path.createDirectories [DONE]
- refresh function mapToInt [DONE]
- HashSet support null values/ and TreeSet does not [DONE]
- UnaryOperator<T> apply() method not accept() [DONE]
- increase order operators!!!!!!!!
- Stream<T>.flatMapToInt()  [DONE]
- blocktext trailing whitespace. [DONE]
- ios.readObject() [DONE]
- throws Throwable
- Autocloseable is in java.lang / Closable is in java.io; [DONE]
- findFirst() method always returns the first element on an ordered stream, regardless if it is serial or parallel, 
is free to return any element if the stream is unordered. [DONE]
- creation of Period. Period.of(x,y,z)  [DONE]


- refresh -D java/jar [DONE]
- Stream.concat(s1, s2): s1, s2 should be Stream, not IntStream [DONE]
-  t.scheduleAtFixedRate(() 4 args [DONE]
- review switch expression, yield [DONE]
- review accumulator, associative etc [DONE]
- check throws multi catch error [DONE]
- review reduce parallel stream [DONE]
- Optional.ofNullable() [DONE]
- LongStream.mapToInt(n->n) //does not compile, I cannot cast [DONE]
- check this:
-  final var javaVersions = List.of(17,11,8);
   4: var names = List.of("JDK", "Java");
   5: V: for (var e1 : javaVersions) {
   6:    E: for (String e2 : names)
   7:       System.out.println(e1 + "_" + e2);
   8:       break;
   9: }


: module com.mammal {
2:    exports com.mammal.cat;
3:    exports com.mammal.mouse to com.mice;
4:    uses com.animal;
5: }