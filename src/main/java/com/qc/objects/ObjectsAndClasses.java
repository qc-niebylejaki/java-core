package com.qc.objects;

public class ObjectsAndClasses {

    public static void main(String[] args) {

    }
}

class ObjectWithInitializationBlock {

    private long nextId;
    private String name;

    // initialization block - is used before any other contructor
    {
        this.nextId = 10;
    }

    public ObjectWithInitializationBlock() {
        this.name = "none";
    }

    public ObjectWithInitializationBlock(String name) {
        this.name = name;
    }
}
