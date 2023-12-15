# Core APIs
## String Methods
### String concatenation
1. If both operands are numeric, + means numeric addition. 
2. If either operand is a String, + means concatenation. 
3. The expression is evaluated left to right.
### String strip
```jshelllanguage
jshell> String s = "  01234   "
        s ==> "  01234   "
        jshell> var s1 = s.strip()
        s1 ==> "01234"  //remove leading & trailing spaces
        jshell> var s2=s.stripLeading()
        s2 ==> "01234   " //remove leading spaces
        jshell> var s3 = s.stripTrailing()
        s3 ==> "  01234"  //remove trailing spaces
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
## Arrays
```jshelllanguage
jshell> int[] array = new int[]{1,2,3}
array ==> int[3] { 1, 2, 3 }

jshell> int[] array = {1,2,3}  //anonymous array
array ==> int[3] { 1, 2, 3 }

```
### Arrays declaration
```java
java.util.Date[] dates[] = new java.util.Date[2][];

```
```java
int[] array = new int[3];  //here I specify the dimenstion
int[] array2 = new int[]{1, 4}; //here I specify the values
    
// array creation with both dimension expression and initialization is illegal
//int[] array3 = new int[2]{1,2}; //does not compile!
```


### mismatch
```java

jshell> int[] arrayA = {1,2}
arrayA ==> int[2] { 1, 2 }

jshell> int[] arrayB = {1,3}
arrayB ==> int[2] { 1, 3 }

jshell> Arrays.mismatch(arrayA, arrayB)
$35 ==> 1  //1 is the first position in which arrayA & arrayB differs

```
## Math
### floor & ceil
```java
jshell> double floor = Math.floor(3.8)
floor ==> 3.0  //double

jshell> double ceil = Math.ceil(3.8)
ceil ==> 4.0  //double
```
## Dates & Times
```java
jshell> java.time.LocalDateTime.now()
$48 ==> 2023-05-14T19:56:29.738748

jshell> java.time.ZonedDateTime.now()
$49 ==> 2023-05-14T19:56:46.627004+02:00[Europe/Zurich]
```

### GMT vs UTC
- GMT - Greenwich Mean Time
- UTC - Coordinated Universal Time

### Duration
```java
jshell> java.time.Duration.ofSeconds(758768437)
$54 ==> PT210769H37S
```
#### toString
PT24H : starts with **PT**

### Period
```java
//Period does not chain. Only the last method is considered!
Period period = Period.ofYears(1).ofMonths(2).ofDays(1);
System.out.println(period);  //P1D
```
The `Period` class does not have methods such as `getSeconds()`, `getMinutes()`, `getHours()`.
#### toString
P1D : starts with **P**
## Converting String to number
```java 
//  this method returns a primitive long
var aLongPrimitive = Long.parseLong("123");

//this method returns a Long object
var aLong = Long.valueOf("123");
sout.println(aLong.toString());
```