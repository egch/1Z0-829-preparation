# I/O - Files Methods

## delete files
### deleteIfExists()
It throws a checked exception. Mind the `IOException`!
```java
public static boolean deleteIfExists(Path path)
                              throws IOException
```
[delete](../src/main/java/org/enricogiurin/ocp17/book/ch14/filesmethods/Delete.java)
### delete()
It throws a checked exception. Mind the `IOException`!
```java
Files.delete(path);
```
[delete](../src/main/java/org/enricogiurin/ocp17/book/ch14/filesmethods/Delete.java)
## Browsing files
[browsing](../src/main/java/org/enricogiurin/ocp17/book/ch14/filesmethods/BrowsingPaths.java)
### list
It provides a simple and flat listing of the files and directories within the specified directory.  
It throws a checked exception. Mind the `IOException`!
```java
try (Stream<Path> stream = Files.list(tmp)) {...}
```

### find
Mind the `maxDepth` parameter!
```java
public static Stream<Path> find(Path start,
 int maxDepth,
 BiPredicate<Path,BasicFileAttributes> matcher,
 FileVisitOption... options)
```
### walk
This method returns a Stream that is a recursive listing of all paths in the directory and its subdirectories.
It traverses the directory tree recursively, including all levels of subdirectories.
```java
public static Stream<Path> walk(Path start,
   FileVisitOption… options) throws IOException
 
public static Stream<Path> walk(Path start, int maxDepth,
   FileVisitOption… options) throws IOException
```

[walk](../src/main/java/org/enricogiurin/ocp17/book/ch14/filesmethods/WalkDirectory.java)

## createDirectories
```java
var dir = Path.of("/flip");
dir = Files.createDirectories(dir);
```
Unlike the `createDirectory()` method, an exception is not thrown if the directory could not be created because it already exists.  
It is _createDirectories()_ and **NOT** _mkdir()_.  
[createDirectories](../src/main/java/org/enricogiurin/ocp17/book/ch14/filesmethods/CreateDirectories.java)
## Read lines
[read lines](../src/main/java/org/enricogiurin/ocp17/book/ch14/filesmethods/ReadLines.java)
### readAllLines
Mind the `IOException` !

```java
//this returns a list, everything is in memory
List<String> listOfLines = Files.readAllLines(path);
```
### lines
Mind the `IOException` !

```java
//this returns a Stream (not in memory)
Stream<String> stream = Files.lines(pom)
```

## isSameFile
[IsSameFile](../src/main/java/org/enricogiurin/ocp17/book/ch14/filesmethods/IsSameFile.java)
```java
boolean result = Files.isSameFile(p1, p2);
```
The system might check if the files really exist if the `p1.equals(p2)` returns false.  
If check is done and one of these two do not exist, after check:
```java
Exception in thread "main" java.nio.file.NoSuchFileException: src/a
```

### Mismatch
Finds and returns the position of the first mismatched byte in the content of two files, or -1L if there is no mismatch.
```java
public static long mismatch(Path path,
 Path path2) throws IOException
```
```java
Path hello = Path.of("/tmp/hello.txt");
long mismatch = Files.mismatch(hello, hello);  //-1
```


## File Attributes
- BasicFileAttributes
- BasicFileAttributeView  
[File Attributes](../src/main/java/org/enricogiurin/ocp17/book/ch14/ReadAttributes.java)
