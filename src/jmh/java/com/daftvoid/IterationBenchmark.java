package com.daftvoid;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(1)
@State(Scope.Thread)
public class IterationBenchmark {
    private int[] arr = new int[1000];
    private static volatile int sink;

    @Benchmark
    public void iterateByFor() {
        for (int i = 0; i < arr.length; i++) {
            sink = arr[i];
        }
    }

    @Benchmark
    public void iterateByStream() {
        IntStream.of(arr).forEach(i -> sink = i);
    }
}
