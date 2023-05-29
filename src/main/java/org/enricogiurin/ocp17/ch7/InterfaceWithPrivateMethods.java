package org.enricogiurin.ocp17.ch7;

public interface InterfaceWithPrivateMethods {
    void hello(String name);
    private String ciao() {
        return "ciao";
    }
}

class Concrete implements InterfaceWithPrivateMethods {

    @Override
    public void hello(String name) {

    }
}
