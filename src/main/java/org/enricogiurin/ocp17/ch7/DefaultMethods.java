package org.enricogiurin.ocp17.ch7;

public class DefaultMethods implements MyDefault {
    @Override
    public String message() {
        return "This is the class method's implementation";
    }

    //how to refer to the default method
    public String defaultMessage() {
        return MyDefault.super.message();
    }

    public static void main(String[] args) {
        DefaultMethods defaultMethods = new DefaultMethods();
        String s = defaultMethods.message();
        System.out.println(s);
        s = defaultMethods.defaultMessage();
        System.out.println(s);

    }
}

interface MyDefault {
    default String message(){
        return "This is the default method";
    }
}


