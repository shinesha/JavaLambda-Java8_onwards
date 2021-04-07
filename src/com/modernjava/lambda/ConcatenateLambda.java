package com.modernjava.lambda;

public class ConcatenateLambda {
    public static void main(String[] args) {
        //abstract method implementation
        ConcatenateInterface concatenateInterface= (a , b)->a + "" + b;



        System.out.println(concatenateInterface.sconcat("howdy", "world"));
    }
}
