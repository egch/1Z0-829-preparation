package org.enricogiurin.ocp17.book.ch7.nested;

public class MixedInnerStatic {
  class Cub{}
  static class Mark {}

  static void create() {
    //Mark is a static class no need to create an instance of MixedInnerStatic
    var mark = new Mark();
    //another way to create
    MixedInnerStatic.Mark mark2 = new MixedInnerStatic.Mark();
    //here I need an instance of MixedInnerStatic
    Cub c = new MixedInnerStatic().new Cub();
  }


}
