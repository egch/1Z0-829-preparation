package org.enricogiurin.ocp11.practice.ch3;

public interface StaticInterface {

    //public redundant but still allowed
    public static String hello(String name) {
        return "Hello " + name;
    }

    /**
     * Yes, we can have private methods or private static methods in an interface in Java 9. We can use these methods to remove the code redundancy.
     * Private methods can be useful or accessible only within that interface only.
     * We can't access or inherit private methods from one interface to another interface or class.
     *
     * @return
     * @see <a href="https://www.tutorialspoint.com/can-we-have-a-private-method-or-private-static-method-in-an-interface-in-java-9</a>
     */
    private static String privateMethod() {
        return "I'm private";
    }
}
