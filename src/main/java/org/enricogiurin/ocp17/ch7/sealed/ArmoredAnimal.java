package org.enricogiurin.ocp17.ch7.sealed;

public sealed class ArmoredAnimal permits Armadillo {
    public ArmoredAnimal(int size) {
    }

    @Override
    public String toString() {
        return "Strong";
    }

    public static void main(String[] a) {
        var c = new Armadillo(10, null);
        System.out.println(c);
    }
}
//sealed, non-sealed or final modifiers expected
final class Armadillo extends ArmoredAnimal {
    @Override
    public String toString() {
        return "Cute";
    }

    public Armadillo(int size, String name) {
        super(size);
    }
}