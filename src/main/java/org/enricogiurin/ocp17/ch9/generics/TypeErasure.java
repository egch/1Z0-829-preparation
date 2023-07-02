package org.enricogiurin.ocp17.ch9.generics;

import java.util.List;

public class TypeErasure {
    //handle(List<String>)' clashes with 'handle(List<Integer>)'; both methods have same erasure
    //does not compile, as generics are replaced by the compiler with Object

    //public void handle(List<String> list) {}
    public void handle(List<Integer> list) {
    }
}
