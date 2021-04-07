package com.modernjava.lambda;

public class ConcatenateTraditional implements ConcatenateInterface {


    @Override
    public String sconcat(String a, String b) {
        return a+ "" + b;
    }

    public static void main(String[] args) {
        ConcatenateTraditional concatenateTraditional= new ConcatenateTraditional();
        concatenateTraditional.sconcat("hello", "world");
    }
}
