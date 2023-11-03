package org.enricogiurin.ocp17.book.ch7.sealed;

//Class is not allowed to extend sealed class from another package

//All the classes which extends Pet need to be within the same package
//that's why Puma (different package) cannot extend Pet
public sealed class Pet permits Cat, Dog
    /*, Puma */ {

}
