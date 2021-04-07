package com.modernjava.lambda;

public class HelloWorldLambda {
    public static void main(String[] args) {
        //abstract method implementation
        HelloWorldInterface helloWorldInterface=() -> "Hello World";

        System.out.println(helloWorldInterface.sayHelloWorld());
    }
}
