package com.bobadilla.function;

import java.util.function.Function;

public class Main {

    static Function<String,String> function = (s1) -> {
        return s1.toUpperCase();
    };

    static Function<String,String> concaFunction = (s1) -> s1.toLowerCase().concat(" defaul t");

    public static void main(String[] args) {

        System.out.println("Resultado: "+function.apply("israel java "));
        System.out.println("Resultado: "+function.andThen(concaFunction).apply("israel JAVA "));
         System.out.println("Resultado: "+function.compose(concaFunction).apply("ISRAEL java "));

    }
}