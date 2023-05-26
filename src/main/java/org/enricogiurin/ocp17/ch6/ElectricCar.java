package org.enricogiurin.ocp17.ch6;

public class ElectricCar extends Car {
    public ElectricCar(int n){
        //we need to call explicitly this as the Car class does not define!
        //a default (empty) constructor
        super(n);
    }
}

class Car {
    Car(int n){
    }
}
