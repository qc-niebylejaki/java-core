package com.qc.objects;

public class OuterClass {

    private static int outerValue;

    public static void main(String[] args) {
        OuterClass.outerValue++;
        OuterClass.InnerClass.printOuterValue();
    }

    class InnerClass {
        public static void printOuterValue() {
            System.out.println(outerValue);
        }
    }
}
