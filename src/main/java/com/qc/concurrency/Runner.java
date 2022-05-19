package com.qc.concurrency;

import java.util.stream.IntStream;

public class Runner {

    public static void main(String[] args) {
        Runnable r = () -> IntStream.range(0, 100).forEach(i -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + i);
//                    if (Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000L);
//                  }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        //t1.interrupt();
        t2.start();
    }
}
