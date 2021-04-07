package com.modernjava.lambda;

import java.util.stream.IntStream;

public class RunnableTraditionalAndLambda {
    public static void main(String[] args) {
        //1/ Runnable Traditional
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i= 0; i < 10; i++)
                    sum += i;
                    System.out.println("Traditional = " + sum);
                }
        };
        new Thread(runnable).start();


        //2/ Implement using lambda
        Runnable runnable1 = () -> {

            // and declarative
            int sum = IntStream.of(1,2,3,4,5, 6, 7, 8, 9).sum();
            System.out.println("Runnable Lambda = " + sum);

        };
        new Thread (runnable1).start();



        //3/ Implement using Thread with Lambda
        new Thread (() -> {
            // and declarative
            int sum = IntStream.of(1,2,3,4,5, 6, 7, 8, 9).sum();
            System.out.println("Runnable Lambda inside thread = " + sum);

        }).start();
    }
}
