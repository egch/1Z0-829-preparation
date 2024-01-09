package org.enricogiurin.ocp17.book.ch7.nested.inner;

import org.enricogiurin.ocp17.book.ch7.nested.inner.Kitchen.Mixer.Spinner;

public class Kitchen {
  class Mixer {
    class Spinner {}
  }
  public void bake() {
    Spinner f = new Kitchen().new Mixer().new Spinner();
  }
}
