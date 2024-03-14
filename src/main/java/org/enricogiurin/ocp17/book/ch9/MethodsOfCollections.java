package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodsOfCollections {

  public static void main(String[] args) {
    new MethodsOfCollections().sortWithNullComparator();
  }

  void binarySearch() {
    //list needs to be sorted
    List<Integer> list = buildList();
    int index = Collections.binarySearch(list, 3);
    System.out.println(index);  //2 - position 2
    index = Collections.binarySearch(list, 1); //1 is not present!
    //index = -pos -1 = -1 -1 = -2
    System.out.println(index);
  }

  void sort_notComparable() {
    List<Wrapper> list = List.of(new Wrapper("a"), new Wrapper("b"));
    ArrayList<Wrapper> wrapperArrayList = new ArrayList<>(list);
    //Wrapper does not implement Comparable
    // Collections.sort(wrapperArrayList);  //DOES NOT COMPILE
  }

  void sort() {
    List<WrapperComparable> list = List.of(new WrapperComparable("b"), new WrapperComparable("a"));
    ArrayList<WrapperComparable> wrapperArrayList = new ArrayList<>(list);
    Collections.sort(wrapperArrayList);
    //[Wrapper{name='a'}, Wrapper{name='b'}]
    System.out.println(wrapperArrayList);
  }

  void sort_comparator() {
    List<Wrapper> list = List.of(new Wrapper("a"), new Wrapper("b"), new Wrapper("3"));
    ArrayList<Wrapper> wrapperArrayList = new ArrayList<>(list);
    Comparator<Wrapper> comparator = Comparator.comparing(c -> c.name);
    Collections.sort(wrapperArrayList, comparator);
    //[Wrapper{name='3'}, Wrapper{name='a'}, Wrapper{name='b'}]
    System.out.println(wrapperArrayList);
  }

  void sortWithNullComparator() {
    List<String> list = Arrays.asList("a", "c", "d", "b");
    Collections.sort(list, null);
    list.forEach(System.out::print);  //abcd

    //it's equivalent to Collections.sort(list)
  }

  void binarySearchWithComparator() {
    //list needs to be sorted ...according to the comparator to be used
    List<Integer> list = Arrays.asList(20, 10, 5, 4, 3, 1);
    int index = Collections.binarySearch(list, 3, (o1, o2) -> o2 - o1);
    System.out.println(index);  //4th position
  }

  List<Integer> buildList() {
    return Arrays.asList(0, 2, 3, 5, 7, 11, 20);
  }

  class Wrapper {

    String name;

    public Wrapper(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Wrapper{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  class WrapperComparable extends Wrapper implements Comparable<Wrapper> {

    public WrapperComparable(String name) {
      super(name);
    }

    @Override
    public int compareTo(Wrapper wrapper) {
      return this.name.compareTo(wrapper.name);
    }
  }
}


