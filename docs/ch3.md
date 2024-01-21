# Making Decision

## Pattern Matching
```java
void compare(Number number) {
   if(number instanceof Integer data) {
      System.out.print(data.compareTo(5));
   }
}
```

```java
void firstIfFalse(Object object) {
    if(!(object instanceof String s)){
      //here then s is NOT a String
      return;
    }
    //then here it is!. Mind the return first if
    System.out.println("length of string: "+s.length());
}
```
### Pattern Matching - interface
The compiler can't definitively state that t is not a List. 
Some future program could create a subclass of `Throwable` that does implement `List`.
```java
  void notCompatible(Throwable t) {
    //type not compatible - t cannot be a string
    /*
    if(t instanceof String s) {}
    */
    //strange behaviour for interface!
    if(t instanceof List list) {
      System.out.println("that's weird");
    }
  }
```
[Pattern Matching](../src/main/java/org/enricogiurin/ocp17/book/ch3/PatternMatching.java)
## Switch
The value of a case statement must be one of these:
* a constant;
* a literal value;
* a final variable (not just effectively final)
```java
    int aValue = 5;
    final int aConstant = 6;
    switch (x){
        case 2:  //ok - literal
        case aConstant:  //ok - constant
        case aValue: //does not compile, not final
    }
```
WARNING: You always need the `case`, a part in the `default` case.

Multi case
```java
  void workOrChillOut(DayOfWeek day) {
    //with the new switch, I can have multiple cases in the same line
    switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
        System.out.println("You have to work!");
        break;
      default:
        System.out.println("Enjoy your weekend!");
    }
  }
```
### Switch supported types
 - int,byte, short, char
 - Integer, Byte, Short, Character
 - enum
 - String
 - var (if type was previously resolved)
### Switch expression
```java
  void printItalianDayWithDefault(DayOfWeek day) {
    var result = switch (day) {
      case MONDAY -> "lunedi";
      case TUESDAY -> "martedi";
      case WEDNESDAY -> "mercoledi";
      case THURSDAY -> "giovedi";
      case FRIDAY -> "venerdi";
      default -> "weekend";
    };
  }
```
We can have a switch expression even without return value assigned.
```java
    int cnt = 0;
    char c = 'a';
    //there is no return value assigned so the default is not needed!
    switch (c) {
      case 'a' -> cnt++;
      case 'b' -> cnt++;
    }
    System.out.println(cnt); //1
```
#### yield
If the switch expression returns a value, then every branch that isn't an expression must yield a value.

```java
final int score1 = 8, score2 = 3;
char myScore = 7;
var goal = switch (myScore) {
  default -> {
    if (10 > score1) {
      yield "unknown";
    } else {
    {yield "ciao";}  //brackets not needed
    }
}
```
[Switch expression with yield](../src/main/java/org/enricogiurin/ocp17/book/ch3/usageofswitch/SwitchExpressionWithYield.java)