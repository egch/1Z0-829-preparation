package org.enricogiurin.ocp17.crashcourse.unqualified;

public class Identifiers {
    public static void main(String[] args) {
//    Thing.showIt();
    }
}

class PThing {
    static int x = 99;
}

class Thing extends PThing {
    int x = 99;
//  static int x = 99;

    void showIt() {
//    int x = 98;
//    Thing t = new Thing();
        System.out.println("x is " + x);
    }
}

/*
Unqualified resolution:
- local item
- (if no local)
- for each level of class hierarchy until successful
-- if instance scope (i.e. there is a "this" available)
  -- try implied this. prefix
-- try THIS classname implied prefix

 */
