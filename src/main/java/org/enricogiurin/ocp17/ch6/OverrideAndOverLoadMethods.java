package org.enricogiurin.ocp17.ch6;

public class OverrideAndOverLoadMethods {

    public static void main(String[] args) {
        Pet jimmy = new Dog();
        jimmy.name = "Jimmy";
        System.out.println(jimmy.name());  //print null

        Dog myDog = new Dog();
        myDog.name = "Jimmy";
        System.out.println(myDog.name());  //print "Jimmy"
    }


}

class Pet {
    String name;

    static CharSequence group() {
        return Pet.class.getSimpleName();
    }

    CharSequence name() {
        return name;
    }

    private void sayHello() {
        System.out.println("Hello");
    }


}

class Dog extends Pet {
    String name;

    //Static methods cannot be annotated with @Override
    //overridden and hidden methods can have covariant return types.
    // @Override
    static String group() {
        return Dog.class.getSimpleName();
    }

    //The sayHello() method in the Pet class is marked private,
    // meaning it is not inherited and therefore is not overridden in the Dog class
    String sayHello() {
        return "Hello";
    }

    //covariant of CharSequence -> String implements CharSequence
    //overridden and hidden methods can have covariant return types
    @Override
    String name() {
        return "name is: " + name;
    }
}
