package com.qc.generics;

public class ArrayAlg {

    public static <T> T getMiddle(T[] args) {
        return args[args.length / 2];
    }
}
