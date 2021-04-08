package com.modernjava.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {


        //print the numbers, normally done with for loop
        IntStream numbers = IntStream.of(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);

        // print the range
        IntStream numbers2 = IntStream.rangeClosed(1, 5);
        numbers2.forEach(System.out::println);

        //sum the numbers , normally sum the numbers with a for loop
        int sum = IntStream.of(1, 2, 3, 4, 5).sum();
        System.out.println("sum=" + sum);

        //sum the range
        int sum1 = IntStream.rangeClosed(1, 5).sum();
        System.out.println("sum1=" + sum1);

        // minimum number normally, done by checking if numbers is less than number save in a for loop
        List<Integer> numbers3 = Arrays.asList(-6, 1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(numbers3.stream().min(Integer::compareTo));

    }

}