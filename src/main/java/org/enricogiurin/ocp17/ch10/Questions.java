package org.enricogiurin.ocp17.ch10;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Questions {

    public static void main(String[] args) {
        new Questions().noneMatch();
    }
    void iterate() {
        var stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x->x+"2"));
    }

    void noneMatch() {
        Predicate<String> predicate = s -> s.length()>3;
        var stream = Stream.iterate("", s -> !s.isEmpty(), (s) -> s + s);
        var b1 = stream.noneMatch(predicate);
        //stream can't be re-used.
        //this line generates an java.lang.IllegalStateException
        var b2 = stream.anyMatch(predicate);
        System.out.println(b1+" "+b2);
    }
}
