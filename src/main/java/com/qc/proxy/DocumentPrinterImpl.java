package com.qc.proxy;

import java.nio.file.Path;

public class DocumentPrinterImpl implements DocumentPrinter {

    public String print(Path path) {
        System.out.println("DocumentPrinterImpl");
        return path.toString();
    }
}
