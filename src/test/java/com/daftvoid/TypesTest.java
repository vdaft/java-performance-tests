package com.daftvoid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypesTest {
    @Test
    public void shortVsInt() {
        long start = System.nanoTime();

        short shortNumber = 0;
        for (long i = 0; i < 1_000_000_000L; i++) {
            shortNumber++;
        }

        long time1 = System.nanoTime() - start;

        start = System.nanoTime();

        int intNumber = 0;
        for (long i = 0; i < 1_000_000_000L; i++) {
            intNumber++;
        }

        long time2 = System.nanoTime() - start;

        int time1ms = (int) (time1 / 1_000_000);
        int time2ms = (int) (time2 / 1_000_000);

        System.out.println();
        System.out.println("=== RESULTS ===");
        System.out.println("Short took: " + time1ms + " ms");
        System.out.println("Int took: " + time2ms + " ms");

        assertTrue(time1 > time2);
    }
}
