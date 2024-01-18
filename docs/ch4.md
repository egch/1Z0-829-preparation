# Core APIs
## String Methods
### String concatenation
1. If both operands are numeric, `+` means numeric addition. 
2. If either operand is a String, `+` means concatenation. 
3. The expression is evaluated left to right.
### String strip
Whitespace consists of spaces along with the `\t` (tab) and `\n` (newline) characters.
```java
String s = "  01234   ";
//remove leading & trailing spaces
var s1 = s.strip();  // "01234" 

//remove leading spaces
var s2=s.stripLeading();  // "01234   "

//remove trailing spaces
var s3 = s.stripTrailing(); // "  01234"
```
### CharSequence
Both **String** and **StringBuilder** implement _CharSequence_.
### formatted
```jshelllanguage
jshell> var name = "John"
name ==> "John"

jshell> var age = 30
age ==> 30

jshell> var s = "%s is %d years old".formatted(name, age)
s ==> "John is 30 years old"

```

## String pool
```jshelllanguage
jshell> String s1 = "ab"
s1 ==> "ab"

jshell> String s2 = "a"+"b"
s2 ==> "ab"

jshell> s1==s2
$18 ==> true

jshell> String s3 = "a"
s3 ==> "a"

jshell> s3 +="b"
$20 ==> "ab"

jshell> s1==s3
$21 ==> false
```
## StringBuilder
### setLength
```java
    var sb = new StringBuilder("0123456789");
    sb.setLength(5);
    System.out.println(sb);  //01234
```
[StringBuilder Methods](../src/main/java/org/enricogiurin/ocp17/book/ch4/UsageOfStringBuilder.java)

## Arrays
```jshelllanguage
jshell> int[] array = new int[]{1,2,3}
array ==> int[3] { 1, 2, 3 }

jshell> int[] array = {1,2,3}  //anonymous array
array ==> int[3] { 1, 2, 3 }

```
### Arrays declaration/creation
```java
java.util.Date[] dates[] = new java.util.Date[2][];
```
```java
int[] array = new int[3];  //here I specify the dimenstion
int[] array2 = new int[]{1, 4}; //here I specify the values
    
// array creation with both dimension expression and initialization is illegal
//int[] array3 = new int[2]{1,2}; //does not compile!
```

#### Multi dimensional array
```java
    int[][] a3D[], a2D;
    a3D = new int[2][2][2];  //3D array
    a2D = new int[3][3];  //2D array
```

```java
int[][] matrix = new int[][]{{1,2}, {3}};
int[][] matrix2 = new int[2][1];
int[][] matrix3 = {{1,2}, {3}};

//int[][] matrix4 = new int[2][1]{{1,2}, {3}};  //does not compile
```
[Multi Dimensional Array](../src/main/java/org/enricogiurin/ocp17/book/ch4/array/MultiDimensionalArray.java)

### mismatch
```java
    String[] s1 = {"Camel", "Peacock", "Llama"};
    String[] s2 = {"Camel", "Llama", "Peacock"};
    String[] s3 = {"Camel", "Llama", "Peacock"};
    int position = Arrays.mismatch(s1, s2); //first element to differ is at position 1
    System.out.println(position);     //1
    position = Arrays.mismatch(s2, s3); //they are identical then return -1
    System.out.println(position);     //-1
```
### compare
```java
    int[] array1 = {1, 3, 5};
    int[] array2 = {1, 3, 5};
    int[] array3 = {1, 5, 5};
    int result = Arrays.compare(array1, array2);
    System.out.println(result);  //0  (the 2 arrays are identical)

    //the first element which they differ is the 2nd position (3 vs 5)
    //In this case, we get a negative number because 3 is smaller than 5
    result = Arrays.compare(array1, array3);
    System.out.println(result);  //-1
```
### Arrays Sort String (natural order)
1. Numbers
2. Uppercase
3. Lowercase
### Binary Search
```java
var arr = new String[]{"PIG", "pig", "123"};
//Numbers sort before letters and uppercase sorts before lowercase.
Arrays.sort(arr);  //"123", "PIG", "pig"
int position = Arrays.binarySearch(arr, "Pippa");
//result : -insertionPoint -1
//insertionPoint (ideally) would be 2 (after "PIG")
//-> result = -2 -1 = -3
System.out.println(position);  //-3
```
## Math
### floor & ceil
```java
double floor = Math.floor(3.8); // 3.0
double ceil = Math.ceil(3.8); // 8.0
```

### round
Note that return type of `round()` is `long`
```java
long round = Math.round(5.2D); //5
```

### pow
```java
double pow = Math.pow(4.0, 2.0); //16.0
```
## Dates & Times
```java
LocalDateTime.now(); //2023-05-14T19:56:29.738748
ZonedDateTime.now(); //2023-05-14T19:56:46.627004+02:00[Europe/Zurich]
```
### ZonedDateTime
```shell
2021–10–25T09:13:07.769–05:00[America/New_York]

2023-12-16T14:30:00.000-05:00[America/New_York]
```
### GMT vs UTC
- GMT - Greenwich Mean Time
- UTC - Coordinated Universal Time

### Duration
```jshelllanguage
jshell> java.time.Duration.ofSeconds(758768437)
$54 ==> PT210769H37S
```
#### toString
PT24H : starts with **PT**


I can't use `Duration` with `LocalDate`!
```java
var date = LocalDate.of(2023, 1, 21);
var days = Duration.ofDays(1);
// Unsupported unit: Seconds
//I can NOT use Duration with LocalDate
//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds    
System.out.println(date.plus(days));    
```
### Period
```java
//Period does not chain. Only the last method is considered!
Period period = Period.ofYears(1).ofMonths(2).ofDays(1);
System.out.println(period);  //P1D
```
The `Period` class does not have methods such as `getSeconds()`, `getMinutes()`, `getHours()`.

#### toString
P1D : starts with **P**


### Instant
The Instant class represents a specific moment in time in the GMT time zone.
#### Format
```java
YYYY-MM-DDTHH:mm:ss.SSSZ
```
#### Creation
```java
//from ZonedDateTime
Instant instantZRH = zdtZurich.toInstant();
//with now()
Instant now = Instant.now();  //2024-01-18T11:02:16.628552400Z
```
[Instant](../src/main/java/org/enricogiurin/ocp17/book/ch4/time/UsageOfInstant.java)

#### plus
While an Instant represents a specific moment in time using GMT, Java only allows adding or removing units of DAYS or smaller.
```java
    Instant now = Instant.now();
    Instant then = now.plus(1, ChronoUnit.DAYS); //    //2024-01-08T07:47:52.101744Z

    //adding a year - throws an exception
    //Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Years
    Instant inOneYear = now.plus(1, ChronoUnit.YEARS);
```

## Converting String to number
```java 
//  this method returns a primitive long
var aLongPrimitive = Long.parseLong("123");

//this method returns a Long object
var aLong = Long.valueOf("123");
sout.println(aLong.toString());
```

## Manipulating String
### indent
However, indent() also normalizes whitespace characters. 
First, a line break is added to the end of the string if not already there. 
Second, any line breaks are converted to the `\n` format.

```java
    var name = "1234 \n567";
    var indent1 = name.indent(1);
    System.out.println("#%s#".formatted(indent1));
```
It prints:
```shell
# 1234 
 567
#
```

### translateEscapes
`\n` - new line
```java
String source = "Today is\\nSaturday";
System.out.println(source); //Today is\nSaturday

//Today is
//Saturday
System.out.println(source.translateEscapes());
```
`\t` - tab
```java
String source = "1\\t2";
//  1\t2
System.out.println(source);
//  1 2
System.out.println(source.translateEscapes());
```
[translateEscapes](../src/main/java/org/enricogiurin/ocp17/book/ch4/string/TranslatingEscapes.java)