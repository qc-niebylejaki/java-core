package com.qc.lambdas;

import java.util.function.BiFunction;

// TODO: poćwiczyć
public class FunctionalInterfaces {

    public static void main(String[] args) {
        BiFunction<String, String, Integer> comp =
                (first, second) -> first.length() - second.length();

        System.out.println(comp.apply("hello ", "world"));

        Printer printer = String::valueOf;
        printer.print(123);
    }
}

@FunctionalInterface
interface Printer {

    String print(int i);
}
