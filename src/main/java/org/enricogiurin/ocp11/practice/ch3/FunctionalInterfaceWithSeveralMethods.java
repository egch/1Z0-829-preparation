package org.enricogiurin.ocp11.practice.ch3;

//38 pag 43
@FunctionalInterface
public interface FunctionalInterfaceWithSeveralMethods {
    String home = "666-444";

    static int call() {
        return 1;
    }

    default void dial() {
    }

    /**
     * this is the only method needed to be the interface annotated as {@link FunctionalInterface}
     */
    long answer();

}
