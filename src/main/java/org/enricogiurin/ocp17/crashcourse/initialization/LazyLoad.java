package org.enricogiurin.ocp17.crashcourse.initialization;

class LazyP {

  static {
    System.out.println("loading LazyP");
  }

  int p = getOneHundred();

  int getOneHundred() {
    System.out.println("LazyP getOneHundred");
    return 100;
  }

  int getP() {
    return p;
  }
}

class Lazy extends LazyP {

  static int value = getValue();

  static {
    System.out.println("loading Lazy, value is " + Lazy.value);
  }

  static {
    System.out.println("loading Lazy (step 2), value is " + Lazy.value);
  }

  int x = 100;
  int val = 200;

  {
    System.out.println("running instance init in Lazy (1), x is " + this.x);
  }

  {
    System.out.println("running instance init in Lazy (2), x is " + x);
  }

  public Lazy() {
    super();
    // right here, compiler adds "instance initialization"
    System.out.println("back from super()");
  }

  public Lazy(int x) {
    this();
    // nothing special here... it all happened in and immediately after
    // super() call above
  }

  static int getValue() {
    System.out.println("getting value");
    return 10;
  }

  @Override
  int getOneHundred() {
    return val;
  }
}

public class LazyLoad {

  public static void main(String[] args) {
    System.out.println("step 1");
    Lazy l;
    System.out.println("step 2");
    System.out.println("Class of Lazy is " + Lazy.class);
    System.out.println("step 3a");
    System.out.println(Lazy.value);
    System.out.println("step 3");
    l = new Lazy();
    System.out.println("step 4");
    System.out.println("p value is " + l.p);
  }
}
