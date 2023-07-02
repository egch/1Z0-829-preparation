package org.enricogiurin.ocp11.practice.ch3;

public class ExtendPrivateMethod {
    class Tool {
        private void repair() {
        }

        ;

        void use() {
        }

        ;
    }

    class Hammer extends Tool {
        //this method has nothing to do with the same method in the parent class as it is private
        private int repair() {
            return 2;
        }
    }
}
