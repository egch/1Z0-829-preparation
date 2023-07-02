package org.enricogiurin.ocp17.crashcourse.arrowswitch;

import java.time.LocalDate;

public class Examples {
    public static void main(String[] args) {
        String s = "Hello";
        switch (s) {
            case "Hello":
            case "Goodbye":
                System.out.println("hello");
                System.out.println("really!");
                break;
            default:
                System.out.println("hmm");
                break;
        }
        System.out.println("---------------");
        switch (s) {
//      case "Hello", "Goodbye": // comma works with colon too now :)
            case "Hello", "Goodbye" -> {
                System.out.println("hello");
                System.out.println("really!");
                if (Math.random() > 0.5) break;
                System.out.println("Still here");
            }
            default -> System.out.println("hmm");
        }

        System.out.println("----------------");
        switch (s) {
            case "Hello" -> System.out.println("really!");
            default -> System.out.println("hmm");
        }

    }
}

class MoreExamples {
    public static void main(String[] args) {

        int x = 1;
        // line n1
        // use a switch in a place where an expression is needed...
        // it becomes an expression!!!
        // it MUST cover all input values
        // right side of -> must now be either single *expression*
        // or we yield (NOT RETURN!!!!)
        // CAN do this with colon form, but must use yield always.
        // Take care... Colon form STILL falls through!
        var y = switch (x) {
            case 1 -> {
                int year = 2023;
//        if (Math.random() > 0.5) return; // NOPE!!!!
                yield LocalDate.of(year, x, 1);
            }
            // expressions must not be void (i.e. must not be statements)
//      default -> System.out.println(LocalDate.of(2022, 12, 1));
            default -> LocalDate.of(2022, 12, 1);
        };
        System.out.println("y is " + y);

        // "Statement-expression" expression that is known to have potential
        // side effects
        // boolean expression! java allows us to ignore result of function calls
        // so we can treat it as a statement.
        // statement expressions generally are any expression with side effects
        // function calls
        // constructor calls
        // increment/decrement operators
        // assignment expressions
        // can use these in for loops
//    boolean f = false;
//    for (System.out.println("Hello"), System.out.println("goodbye");
//    f;
//    System.out.println("Loop increment"))
//      ;

//    List<String> ls = null;
//    ls.add("");
        int a = 3, b = 2;
//    a + b; // NOT legal in isolation


        // line n1
        var r2 = switch (x) {
            case 1:
                yield LocalDate.of(2023, x, 1);
            default:
                yield LocalDate.of(2022, 12, 1);
        };
    }

}
