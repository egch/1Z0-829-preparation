package org.enricogiurin.ocp17.book.ch7.nested.inner;

public class Car {

  //nested inner class
  public class Engine {

    //intentionally, it has the same name as the outer class
    private final String name;

    //Remember that private constructors can be used by any methods within the outer class.
    private Engine(String name) {
      this.name = name;
    }

    public void start() {
      //this.name refers to name of the inner class (Engine)
      //Car.this.name refers to the name of the Outer class: Car
      System.out.println("Engine " + this.name + " started for car: " + Car.this.name);
    }
  } //end of nested inner class

  private final String name;

  public Car(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    Car ferrari = new Car("Ferrari 812 SuperFast.");
    //Engine turbo v8 started for car: Ferrari 812 SuperFast.
    ferrari.driveCar();

    //I can instantiate directly an engine
    Engine engine = ferrari.new Engine("two cylinders");
    //Engine cannot be referenced from a static context
    //var e = new Engine("invalid")  //does not compile
  }

  public void driveCar() {
    //here I am within an instance of Car
    Engine engine = new Engine("turbo v8");
    engine.start();

    //alternative way
    Engine e2 = this.new Engine("turbo v9");
  }

  //inner class can be private/protected/package/public


}
