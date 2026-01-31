package com.daftvoid;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Thread)
public class TypesComparisonBenchmark {

    private short s = 0;
    private int i = 0;
    private long l = 0;
    private double d = 0;
    private float f = 0;
    private byte b = 0;

    @Benchmark
    public short incShort() {
        s++;
        return s;
    }

    @Benchmark
    public int incInt() {
        i++;
        return i;
    }

    @Benchmark
    public long incLong() {
        l++;
        return l;
    }

    @Benchmark
    public byte incByte() {
        b++;
        return b;
    }

    @Benchmark
    public double incDouble() {
        d++;
        return d;
    }

    @Benchmark
    public float incFloat() {
        f++;
        return f;
    }
}
