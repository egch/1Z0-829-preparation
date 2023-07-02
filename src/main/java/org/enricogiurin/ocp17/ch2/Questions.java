package org.enricogiurin.ocp17.ch2;

public class Questions {
    public static void main(String[] args) {
        new Questions().overflow();
    }

    void rightType() {
        byte apples = 5;
        short oranges = 10;
        int sumInt = apples + oranges;
        long sumLong = apples + oranges;
        double sumDouble = apples + oranges;
        double sumFloat = apples + oranges;

        //error:  incompatible types: possible lossy conversion from int to short
        //short sumShort = apples + oranges;
    }

    void increaseRank() {
        //+,*,%,--
        int a = 5, b = 6, c = 50, d = 31;
        int result = a + b * c % d;  // -> a + (b * c)%d

        System.out.println(result); //26
    }

    void compoundOperator() {
        long aLong = 2;
        //error: incompatible types: possible lossy conversion from double to long
        //aLong = 2 - 1.0;

        //compound operator applies casting automatically
        aLong -= 1.0;
    }

    void explicitCastOperator() {
        short s1 = 3, s2 = 5;
        //|  incompatible types: possible lossy conversion from int to short
        //short result = s1 * s2;
        //the operator * cast botho of the operands to int before proceed
    }

    void overflow() {

        //max value for byte is +127...127+1 = -128
        byte x = (byte) (Byte.MAX_VALUE + 1);
        System.out.println(x); //-128

    }


}
