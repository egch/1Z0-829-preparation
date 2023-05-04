package org.enricogiurin.ocp17.varie;

public class ReThrowException {

    public static void main(String[] args) {
        new ReThrowException().handleException();
    }

    void handleException(){
        try {
            throw new RuntimeException("error");

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
