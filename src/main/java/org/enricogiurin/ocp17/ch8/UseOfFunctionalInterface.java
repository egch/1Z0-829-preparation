package org.enricogiurin.ocp17.ch8;

@FunctionalInterface
interface Sprint {
    void sprint();
}

@FunctionalInterface
interface Dog extends Sprint {
}

//it is also a FI as it respects the SAM contract - Single Abstract Method
@FunctionalInterface
interface Cat extends Sprint {
    default void miao() {
        System.out.println("miao");
    }
}

//This is not a FI as it defines two abstract methods: sprint()/run()
//@FunctionalInterface
interface Zebra extends Sprint {
    void run();

}

public class UseOfFunctionalInterface {
}
