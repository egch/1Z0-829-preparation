package org.enricogiurin.ocp17.book.ch7.sealed.interfaces;

//
public sealed interface Pet permits Cat, Dog,  //Cat, Dog are interfaces
    Rabbit, Fish {

} //these 2 are classes

// Interface permitted to extend sealed interface pet
non-sealed interface Rabbit extends Pet {

}

//If I declare a sealed type I need to define at least one permit
sealed interface Fish extends Pet permits Salmon {

}

// Classes permitted to implement sealed interface Pet
final class Cat implements Pet {

}

non-sealed class Dog implements Pet {

}

final class Salmon implements Fish {

}

//I cannot have an interface marked as final
//final interface Fish extends Pet {}
