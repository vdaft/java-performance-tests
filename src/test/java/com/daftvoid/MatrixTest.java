package com.daftvoid;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    public void shouldBeTrue() {
        assertTrue(true);
    }

    @Test
    public void addOneToMatrixSpeed() {
        int[][] matrix = new int[10000][10000];

        IntStream.range(0, matrix.length).forEach(i -> Arrays.fill(matrix[i], 1));

        long now = System.nanoTime();
        Matrix.addOneToMatrix(matrix);
        long time1 = System.nanoTime() - now;


        now = System.nanoTime();
        Matrix.addOneToMatrix2(matrix);
        long time2 = System.nanoTime() - now;

        System.out.println();
        System.out.println("=== RESULTS ===");
        System.out.println("1 took " + time1 / 1_000_000 + " ms");
        System.out.println("2 took " + time2 / 1_000_000 + " ms");
        System.out.println("Difference: " + (time2 - time1) / 1_000_000 + " ms");
        System.out.println("1 was " + time2 / time1 + "x faster than 2");

        assertTrue(time1 < time2);
    }
}