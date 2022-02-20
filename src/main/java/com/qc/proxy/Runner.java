package com.qc.proxy;

import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) {
        DocumentPrinter documentPrinter = new DynamicProxy().getProxy(DocumentPrinter.class);
        documentPrinter.print(Paths.get("test"));
    }
}
