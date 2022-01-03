package org.enricogiurin.ocp11.practice.ch3;

public class Dinosaur {
    class Pterodactyl extends Dinosaur {}

    public void roar() {
        var dino = new Dinosaur();
        dino.new Pterodactyl();  //valid
        new Dinosaur.Pterodactyl(); //valid ...Dinosaur prefix is optional
    }
}
