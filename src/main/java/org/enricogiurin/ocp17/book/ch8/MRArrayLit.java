package org.enricogiurin.ocp17.book.ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MRArrayLit {

  void create() {
    Function<Integer, List<Integer>> create = n -> new ArrayList<>(n);
    Function<Integer, List<Integer>> createMR = ArrayList::new;

    List<Integer> list = createMR.apply(10);

    //but we can also avoid passing it, then in this case it's a Supplier
    Supplier<List<Integer>> supplier = ArrayList::new;
    List<Integer> list1 = supplier.get();

    //so the same MR can be applied to different FI:
    //Function<Integer, List<Integer>>
    // Supplier<List<Integer>> supplier
  }

}
