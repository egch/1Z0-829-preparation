package org.enricogiurin.ocp17.crashcourse.day2;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.function.Predicate;

public class Questions {

    public static void main(String[] args) throws Exception {
        new Questions().checkedExceptions();
    }

    void notStatement(){
        int a=2, b=0;
        //illegal - Not a statement
       // a+b;
    }


    //better than throws Exception
    void checkedExceptions() throws SQLException, FileNotFoundException {

        Predicate<Boolean> booleanPredicate = new Predicate<>() {

            @Override
            public boolean test(Boolean aBoolean) {
                return false;
            }
        };
        try{
            stuff();
            stuff2();

        }catch (SQLException | FileNotFoundException e){
            throw e;
        }

    }

    void stuff() throws SQLException {};
    void stuff2() throws FileNotFoundException {};


    //constructor Day

    enum Day {
        MONDAY(1), TUESDAY;
        Day(){}
        Day(int day){

        }
    }


    //record

}
