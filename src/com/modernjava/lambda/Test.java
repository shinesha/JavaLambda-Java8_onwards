package com.modernjava.lambda;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        int sum = IntStream.of(1,2,3,4,5, 6, 7, 8, 9).sum();
        System.out.println("Runnable Lambda= " + sum);
    }
}
