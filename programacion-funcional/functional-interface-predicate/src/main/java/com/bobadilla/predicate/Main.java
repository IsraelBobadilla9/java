package com.bobadilla.predicate;

import java.util.function.Predicate;
// esta funcion es muy sencilla de entender 
public class Main {
    public static void main(String[] args) {

        Predicate<Integer> par = (i) -> {
            return i % 2 == 0;
        };
        Predicate<Integer> menor = (i) -> i   < 100;

        System.out.println(par.test(10));
        System.out.println(par.and(menor).test(120));
        System.out.println(par.and(menor).negate().test(20));
    }
}