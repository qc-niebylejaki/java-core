package com.qc.arrays;

public class Arrays {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        // initialize array with fixed size; initialized with default value for type
        int[] array = new int[10];
        java.util.Arrays.sort(array);
        System.out.println(java.util.Arrays.toString(array));

        java.util.Arrays.fill(array, 23);
        System.out.println(java.util.Arrays.toString(array));

        // multidimensional arrays
        double[][] matrix = new double[10][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = Math.random();
            }
        }
        System.out.println(java.util.Arrays.deepToString(matrix));

        // anonymous arrays
        int[] anonymous1 = {1, 2, 3, 4, 5};
        double[][] anonymous2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println(java.util.Arrays.deepToString(anonymous2));

        // ragged arrays
        int[][] raggedArray = new int[3][];
        raggedArray[0] = new int[]{1};
        raggedArray[1] = new int[]{2, 3, 4};
        raggedArray[2] = new int[]{5, 6, 7, 8, 9};
        System.out.println(java.util.Arrays.deepToString(raggedArray));
    }
}
