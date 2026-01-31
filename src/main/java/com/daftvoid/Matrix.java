package com.daftvoid;

public class Matrix {
    public static int[][] addOneToMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]++;
            }
        }

        return matrix;
    }

    public static int[][] addOneToMatrix2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i]++;
            }
        }

        return matrix;
    }
}