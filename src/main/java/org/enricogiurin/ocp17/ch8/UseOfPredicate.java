package org.enricogiurin.ocp17.ch8;

import java.awt.*;
import java.util.function.Predicate;

public class UseOfPredicate {

    void predicate() {
        Predicate<String> predicateString = x->true;
        Predicate<String> predicateWIthVar = (var x) -> true;
    }
}
