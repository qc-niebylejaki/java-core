package com.qc.core;

public class DataTypes {

    @SuppressWarnings("all")
    public static void main(String[] args) {
       typesAndVariables();
    }

    private static void typesAndVariables() {
        // Integer types
        int intNumber = 1;          // 4 bytes, range –2,147,483,648 to 2,147,483, 647 (just over 2 billion)
        short shortNumber = 2;      // 2 bytes, range –32,768 to 32,767
        long longNumber = 3L;       // 8 bytes, range –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        byte byteNumber = 4;        // 1 byte, range –128 to 127

        // Floating-point types
        float floatNumber = 1F;     // 4 bytes, range approximately ±3.40282347E+38F (6–7 significant decimal digits)
        double doubleNumber = 2;    // 8 bytes, range approximately ±1.79769313486231570E+308 (15 significant decimal digits)

        double naN = Double.NaN;// not a number;
        double maxValue = Double.MAX_VALUE;
        double minValue = Double.MIN_VALUE;
        double negativeInfinity = Double.NEGATIVE_INFINITY;
        double positiveInfinity = Double.POSITIVE_INFINITY;

        double numberWithUnderline = 233_000_000;

        // char type
        char a = 'a';
        System.out.println("The square root of \u03C0 is " + Math.sqrt(3.14));

        // CONSTATS
        final String CONSTANT = "This is constant string";

        // Math class
        double d = Math.pow(23.0, 2.0);
    }
}
