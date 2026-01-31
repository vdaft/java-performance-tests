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

        long start = System.nanoTime();
        Matrix.addOneToMatrix(matrix);
        long speed1 = System.nanoTime() - start;


        start = System.nanoTime();
        Matrix.addOneToMatrix2(matrix);
        long speed2 = System.nanoTime() - start;

        System.out.println();
        System.out.println("=== RESULTS ===");
        System.out.println("1 took " + speed1 / 1_000_000 + " ms");
        System.out.println("2 took " + speed2 / 1_000_000 + " ms");
        System.out.println("Difference: " + (speed2 - speed1) / 1_000_000 + " ms");
        System.out.println("1 was " + speed2 / speed1 + "x faster than 2");

        assertTrue(speed1 < speed2);
    }
}