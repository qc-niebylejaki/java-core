package com.qc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryMethods {

    private static final Logger log = LoggerFactory.getLogger(FactoryMethods.class);

    public static void main(String[] args) {
        MagicNumber fromInt = MagicNumber.fromInteger(2);
        MagicNumber fromLong = MagicNumber.fromLong(2L);

        log.info("fromInt = {}, fromLong = {}", fromInt.value, fromLong.value);
    }
}

class MagicNumber {

    public final String value;

    private MagicNumber(Integer number) {
        this.value = number.toString();
    }

    private MagicNumber(Long number) {
        this.value = number.toString();
    }

    public static MagicNumber fromInteger(Integer number) {
        return new MagicNumber(number);
    }

    public static MagicNumber fromLong(Long number) {
        return new MagicNumber(number);
    }
}
