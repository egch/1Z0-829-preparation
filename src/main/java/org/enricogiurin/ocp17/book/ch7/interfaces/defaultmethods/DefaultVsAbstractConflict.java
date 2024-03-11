package org.enricogiurin.ocp17.book.ch7.interfaces.defaultmethods;

public class DefaultVsAbstractConflict {

  interface House {

    default void work() {
    }
  }

  interface Office {

    void work();
  }

  //Class 'HomeOffice' must either be declared abstract or implement abstract method 'work()' in 'Office'
  //class HomeOffice implements Office, House { }  //DOES NOT COMPILE!
  class HomeOffice implements Office, House {

    //I am forced to implement work()
    @Override
    public void work() {
    }
  }


}
