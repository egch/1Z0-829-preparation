package org.enricogiurin.ocp17.book.ch7.sealed.interfaces;

//
public sealed interface Pet
    permits Cat, Dog, Pupy,  //Cat, Dog are classes
    Rabbit, Fish {     //Rabbit, Fish are interfaces

}

/* classes */
non-sealed class Dog implements Pet {

}

final class Salmon implements Fish {

}

//a class which implements a sealed interface need to be either final or sealed or non-sealed
//class Pupy implements Pet {}  //DOES NOT COMPILE!
final class Pupy implements Pet {

}

/* interfaces */

// Interface permitted to extend sealed interface pet
non-sealed interface Rabbit extends Pet {
}

//If I declare a sealed type I need to define at least one permit
sealed interface Fish extends Pet permits Salmon {
}

// Classes permitted to implement sealed interface Pet
final class Cat implements Pet {
}


//I cannot have an interface marked as final
//final interface Fish extends Pet {}
