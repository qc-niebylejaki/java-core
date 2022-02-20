package com.qc.core;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Strings {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        // concatenation
        String concatenatedString = String.join(",", "one", "two", "three");
        System.out.println(concatenatedString);

        concatenatedString = Arrays.asList("one", "two", "three").stream()
                .collect(Collectors.joining(","));
        System.out.println(concatenatedString);

        System.out.println("one".equals("one"));
        String one1 = "one";
        String one2 = "one";
        System.out.println(one1 == one2);
        System.out.println("one" == "one");

        // building Strings
        StringBuilder stringBuilder = new StringBuilder(); // thread-safe
    }
}
