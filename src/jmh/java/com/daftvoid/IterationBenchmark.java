package com.daftvoid;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(2)
@State(Scope.Thread)
public class IterationBenchmark {
    private int[] arr = new int[1000];
    private List<Integer> list;
    private static volatile int sink;

    @Setup
    public void setup() {
        list = new ArrayList<>(arr.length);

        for (int x : arr) {
            list.add(x);
        }
    }


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

    @Benchmark
    public void iterateByList() {
        list.forEach(i -> sink = i);
    }
}
