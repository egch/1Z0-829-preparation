package org.enricogiurin.ocp17.ch9;

import java.util.List;
import java.util.Objects;

public class MethodsOfList {

    public static void main(String[] args) {
        new MethodsOfList().contains();
    }

    void contains() {
        List<Data> list = List.of(new Data("a"), new Data("b"), new Data("c"));
        boolean contains = list.contains(new Data("c"));
        System.out.println(contains);
    }
}

class Data {
    String value;

    public Data(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(value, data.value);
    }
}
