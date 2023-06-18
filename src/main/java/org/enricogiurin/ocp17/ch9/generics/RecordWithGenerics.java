package org.enricogiurin.ocp17.ch9.generics;

import com.sun.nio.sctp.IllegalReceiveException;

public record RecordWithGenerics<T>(T element) {
    @Override
    public T element(){
        if(element==null){
            throw new IllegalArgumentException("element is null");
        }
        return element;

    }

    public static void main(String[] args) {
        RecordWithGenerics<String> hello = new RecordWithGenerics<>("Hello");
        String result = hello.element();
        System.out.println(result);

        RecordWithGenerics<String> empty = new RecordWithGenerics<>(null);
        //throws RTE
        empty.element();

    }
}
