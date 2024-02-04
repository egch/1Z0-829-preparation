package org.enricogiurin.ocp17.book.ch7.useofenum;


//Note that if an enum contains an abstract method,
// then every enum value must include an override of this abstract method
enum RGB {
  RED {
    //each enum must implement the abstract method
    @Override
    public String getColorName() {
      return "Red";
    }

    //we can define methods only on specific enum
    public String message() {
      return "hello";
    }
  },

  GREEN {
    @Override
    public String getColorName() {
      return "Green";
    }
  },

  BLUE {
    @Override
    public String getColorName() {
      return "Blue";
    }
  };

  //abstract method
  public abstract String getColorName();
}

public class EnumWithAbstractMethod {

  public static void main(String[] args) {
    RGB red = RGB.RED;
    System.out.println(red.getColorName()); //prints Red

    //does not compile because message is defined only on RED
    //System.out.println(red.message());

  }
}



