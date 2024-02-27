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

-  modules supplied by the JDK [DONE]
- all variables within interfaces are implicitly static and final,
so they must be initialized with a value when they are declared.  [DONE]

- Which class has a getSeconds() method? Period/Duration [DONE]
- sequential: from parallel() to serial [DONE]

- verify chain of var date2 = date1.plusDays(2).minusDays(1).minusDays(1); [DONE]
- resources: check if for some keys it follows both the std and the default locale [DONE]
- stripTrailing and stripLeaders and stripIndent [DONE]
- refresh iterator.next() [DONE]

- The code does not compile because two of the constructors contain a cyclic reference to each other. [DONE]

- module service locator [DONE]
- reduce check the types [DONE] 
- instantiate nested static class [DONE]
- review textblock and backslash [PARTIALLY DONE]
- review -g vars NPE  [DONE]
- NIO refresh resolve/relativize [DONE]
- In an unnamed module, a sealed class must include all its subclasses within the same package [DONE]
- doubt: long method(int x){return x;} [DONE]
- review method primitive vararg call [DONE]
- invokeAny(List<Callable<T>> list) returns T (not future) [DONE]

- ToDoubleBiFunction [DONE]
- Character.valueOf('x').byteValue();  [DONE]

- java --show-module-resolution (module) [DONE]

- prctice with textblocks
- Instant can only add days or smaller [DONE]
- refresh indent, stripIndent, strip [DONE BUT NOT CLEAR]
- BufferedWriter [DONE]

- refresh javac command options [DONE]

- Set.copyOf(list) [DONE]

- refresh findAny() : [DONE]

- toAbsolutePath() does not throw a checked exception 

- NumberFormat.getCurrencyInstance()   category.FORMAT [DONE]
- overloading of `List.remove()` [DONE]
- Duration with LocalDate [DONE]
- translateEscapes() [DONE]
- review enum [DONE]

- jdeps -jdkinternals [PARTIALLY DONE]
- console methods [DONE]
- Jdeps requires mandate Java.base [REVIEW]

- check mutual assignment float and double [DONE]
- UnaryOperator [DONE]

- stored procedure out parameter/execute: registerOutParameter [DONE]
- parallel stream and ordered 
- method static there is not polymorphism [DONE]
- Comparator.comparing((String s) -˃ s.charAt(0)).reversed() NOT reverse [DONE]
- Queue.poll() returns null if no element are present,/ removeFirst throws an exception [DONE]

- BooleanSupplier: `getAsBoolean()` NOT ~~get()~~   [DONE]
- refresh collect 3 arg [DONE]
- jlink --output  [DONE]
- jdeps !!!!  [DONE]
- .forEach(Files::isDirectory); is a consumer? [DONE]
- Callable must define a call() [DONE]
- javac --add-exports [DONE]
- modules provided by jdk!!!! [DONE]

- The addFirst() and addLast() are in the Queue interface, not Deque [DONE]

- NumberFormat.getCurrencyInstance(Locale.UK) [DONE]
-  The first line contains trailing whitespace. [DONE]
- modules jmod: create, list, extract, describe [DONE]


- stripIndent()
####
- lambda
####
review this: ˂NullPointerException˃printException(new NullPointerException ("D") [DONE]
- immutable collections v.removeIf(String::isEmpty); 
    also if no line is removed, they throw java.lang.UnsupportedOperationException [DONE]
- refresh: Comparator.reverseOrder()/ Comparator.naturalOrder() [DONE]
- -Comparator.thenComparing [DONE]
- review generics needed or not for this: var thirdCopy = new ArrayList˂˃(copyOfCopy); [DONE]
- overwrite record constructor [DONE]
- keySet()  not keys()!!!) [DONE]
- map merge with null values  [DONE]

####
 - List.of() -> empty list [DONE]
###
 - NumberFormatException inherits from IllegalArgumentException [DONE]
###
- modules: --add-exports [DONE]
- refresh jdeps commands [DONE]
- show-module-resolution [DONE]
- java -d / jar -d
- jmod
###
- fairness ReentrantLock [DONE]
###
- review Files copy buffer (question 7) [DONE]
- review 10 [DONE]
- review write / read buffer  [DONE]
- refresh: is.read(new byte[2]); [DONE]
###
- review flatMap [DONE]
- The com.4apple and com.apple-four modules are invalid because identifier or identifier segments may not start with a digit nor contain a dash. [DONE]
- escape character definition and text blocks [DONE]
- trylock method [DONE]
- case in the switch!!! [DONE]
- overloading: promotion, unboxing, vararag!! [DONE]
- offset [DONE]