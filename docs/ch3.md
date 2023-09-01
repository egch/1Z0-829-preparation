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
## switch

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

