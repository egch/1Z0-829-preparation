package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockSimulation {
    record Person(String name){
        void eatAndDrink(Food food, Drink drink){
            System.out.println(name+" waiting to eat...");
            synchronized (food){
                System.out.println(name+" is eating");
                synchronized (drink){
                    System.out.println(name+" is drinking");
                }
            }
        }

        void drinkAndEat(Food food, Drink drink){
            System.out.println(name+" waiting to drink...");
            synchronized (drink){
                System.out.println(name+" is drinking");
                synchronized (food){
                    System.out.println(name+" is eating");
                }
            }
        }
    }

    public static void main(String[] args) {
        Food food = new Food();
        Drink drink = new Drink();

        Person enrico = new Person("Enrico");
        Person monia = new Person("Monia");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            executorService.submit(()->enrico.drinkAndEat(food, drink));
            executorService.submit(()->monia.eatAndDrink(food, drink));
        }finally {
            executorService.shutdown();
        }

    }
}

class Food{}
class Drink{}

