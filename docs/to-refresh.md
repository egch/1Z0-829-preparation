# Topics to refresh
### java.time
- Period
- Duration
- ZonedDateTime
- Instant

###  String
- strip()
- indent()
- translateEscapes()
- text block, backslash
- text block: essential, incidental whitespace.

### Parallel Stream
- reduce
- accumulator, combiner
### Method reference
- in which case it's possible to move from a lambda to a MR

## Failed
- Intstream average() returns an OptionalDouble whose method is getAsDouble()
- access to variables record
- You cannot assign a var to a lambda, method reference!
- IntSummaryStatistics, not IntegerSummaryStatistics.
- IntStream sum
- Stream<Long> mapToLong
- SplitIterator
- DoubleToLongFunction
- Set.of(1f,2f,3f,4f).stream() reduce() - unordered
- Stream.sorted() NOT .sort()
- BooleanSupplier: getAsBoolean() NOT get()
- Stream.concat() works only with Stream , NOT IntStream

- ConcurrentLinkedQueue
- Future.get() throws  InterruptedException and a  ExecutionException
- Do not exist in Executor: newFixedScheduledThreadPool() / newThreadPool()
- calling Future.get() is blocking
- scheduleAtFixedRate() parameters
- shutdownNow() and awaitTermination

- Path.of() and Paths.get() //do not confuse
- NOT new Console() but System.console();
- Writer abstract class
- mind the checked exception within lambda, example: toRealPath()
- mark, check if the stream supports mark: inputStream.markSupported()
- Files.isSameFile() check if the real file exists
- How to choose what I/O classes to use, i.e. :
    - BufferedReader
    - FileReader
    - ObjectInputStream
    - FileInputStream
    - BufferedInputStream
- stacktrace when the system error stream is closed

- CallableStatement: difference execute/executeQuery

- CompactNumberInstance
- MessageFormat