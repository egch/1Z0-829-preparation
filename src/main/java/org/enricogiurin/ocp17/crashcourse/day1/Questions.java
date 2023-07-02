package org.enricogiurin.ocp17.crashcourse.day1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Questions {

    public static void main(String[] args) {
        new Questions().textBlock();
    }

    //legal
    void duStuff() {
        for (var x = 0; x < 3; x++) {

        }
    }


    //check this - valid
    void tryWithReources() throws FileNotFoundException {
        try (var x = new FileReader("")) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //clarify this !!!
    void typeTernary() {
        var x = true ? "99" : 99;
        var y = false ? "99" : 99;
        System.out.println(x);
        System.out.println(x.getClass());
        System.out.println(y.getClass());

        var var = "";  //legal

    }

    void sb() {
        final StringBuilder sb = new StringBuilder("hello ");
        sb.append("world");
        System.out.println(sb);
    }

    void textBlock() {

        //check trailing whitespace
        //you need to go new line after the first block
        String txt = """  
                Hello               
                    world!""";
        System.out.println(txt);
        System.out.println("done");

    }


    //not vlid
/*    void varInCatch(){
        try {

        }catch (var ex)
    }*/
}


//illegal - 'var' is a restricted identifier and cannot be used for type declarations
//class var {}
