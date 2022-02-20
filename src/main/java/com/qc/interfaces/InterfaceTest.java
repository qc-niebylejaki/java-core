package com.qc.interfaces;

public class InterfaceTest {

    public static void main(String[] args) {
        new A().run();
    }
}

class A implements I1, I2 {
    @Override
    public void run() {
        System.out.println("run: " + this.getClass());
    }

    @Override
    public void stop() {
        I1.super.stop();
    }
}

interface I1 {
    void run();

    default void stop() {
        System.out.println("I1.stop()");
    }
}

interface I2 {
    void run();

    default void stop() {
        System.out.println("I2.stop()");
    }
}
