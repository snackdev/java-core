package parallel;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4g"})
@State(Scope.Benchmark)
public class SideEffectBenchmark {
    public static final long N = 10_000_000L;

    static class Accumulator {
        AtomicLong total = new AtomicLong(0);
        void add(long value) {total.getAndAdd(value);}
    }

    @Benchmark
    public long sideEffectParallelSum() {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, N).parallel().forEach(accumulator::add);
        System.out.println(accumulator.total);
        return accumulator.total.get();
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}
