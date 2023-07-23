package org.enricogiurin.ocp17.ch13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObtainingSynchronizedCollections {

    public static void main(String[] args) {
        new ObtainingSynchronizedCollections().synchronizedList();
    }
    void synchronizedList() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> synchList = Collections.synchronizedList(list);
        //java.util.Collections$SynchronizedRandomAccessList up to the JDK
        System.out.println(synchList.getClass().getName());

    }

}
