package com.qc.generics;

import java.util.Collections;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>();
        pair.setFirst(1);
        pair.setSecond(2);
        System.out.println(pair);

        int middle = ArrayAlg.getMiddle(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(middle);

        List<Pair<Integer>> pairs = Collections.singletonList(pair);
    }
}
