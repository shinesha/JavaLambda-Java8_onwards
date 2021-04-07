package com.modernjava.lambda;

import java.sql.SQLOutput;

public class HelloWordTraditionalWay implements HelloWorldInterface{
    @Override
    public String sayHelloWorld() {
        return "Hello World";
    }

    public static void main(String[] args) {
        HelloWordTraditionalWay helloWordTraditionalWay = new HelloWordTraditionalWay();
        System.out.println(helloWordTraditionalWay.sayHelloWorld());
    }
}
