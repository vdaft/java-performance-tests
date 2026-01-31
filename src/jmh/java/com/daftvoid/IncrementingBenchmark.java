package com.daftvoid;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Thread)
public class IncrementingBenchmark {

    private int i = 0;

    @Benchmark
    public int incrementViaDoublePlus() {
        i++;
        return i;
    }

    @Benchmark
    public int incrementViaPlusOne() {
        i += 1;
        return i;
    }

    @Benchmark
    public int decrementViaDoubleMinus() {
        i--;
        return i;
    }

    @Benchmark
    public int decrementViaMinusOne() {
        i -= 1;
        return i;
    }
}
