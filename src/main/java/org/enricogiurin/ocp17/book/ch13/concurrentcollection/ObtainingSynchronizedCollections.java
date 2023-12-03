package org.enricogiurin.ocp17.book.ch13.concurrentcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObtainingSynchronizedCollections {

  public static void main(String[] args) {
    new ObtainingSynchronizedCollections().synchronizedList();
  }

  void synchronizedList() {
    List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> synchList = Collections.synchronizedList(list);
    //java.util.Collections$SynchronizedRandomAccessList up to the JDK
    System.out.println(synchList.getClass().getName());
    //Exception in thread "main" java.util.ConcurrentModificationException
    addDuringIteration(synchList);  //failing here!
    //we do not reach here!
    System.out.println("list size: "+synchList.size());
  }

  void synchronizedWithCopyOnWriteArrayList() {
    List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> synchList = new CopyOnWriteArrayList<>(list);
    addDuringIteration(synchList);
    System.out.println("list size: "+synchList.size()); //list size: 6
  }

  void addDuringIteration(List<Integer> list) {
//TODO - check why there is this
    //Exception in thread "main" java.util.ConcurrentModificationException
    for (int value : list) {
      list.add(value + 2);
    }
  }

  //ChatGPT's explanation:

  //In contrast, the Collections.synchronizedList() method provides synchronized access to the
  // list's methods but doesn't change the behavior of iterators, leading to concurrent
  // modification issues if you modify the list during iteration. CopyOnWriteArrayList
  // is specifically designed to address this issue in a thread-safe manner.

}
