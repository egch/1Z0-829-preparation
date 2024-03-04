package org.enricogiurin.ocp17.book.ch7.sealed.classes.p1;

//Class is not allowed to extend sealed class from another package


//All the classes which extend Pet need to be within the same package
//that's why Puma (different package) cannot extend Pet
public sealed class Pet permits Cat, Dog, Rabbit
    /*, Puma */ {

}

//Cat - non-sealed: public non-sealed class Cat extends Pet {}
//Dog - final: public final class Dog extends Pet {}
//Rabbit - sealed: public sealed class Rabbit extends Pet permits Flemish {}