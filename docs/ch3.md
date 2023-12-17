# Making Decision

## Pattern Matching
```java
void compare(Number number) {
   if(number instanceof Integer data) {
      System.out.print(data.compareTo(5));
   }
}
```

### Pattern Matching - edge cases
```java
  void notCompatible(Throwable t) {
    //type not compatible - t cannot be a string
    /*
    if(t instanceof String s) {
      
    }
    */
    //strange behaviour for interface!
    if(t instanceof List list) {
      System.out.println("that's weird");
    }
  }
```
## Switch
The value of a case statement must be one of these:
* a constant;
* a literal value;
* a final variable.
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

