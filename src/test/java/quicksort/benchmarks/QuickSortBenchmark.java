package quicksort.benchmarks;

import org.openjdk.jmh.annotations.*;
import quicksort.QuickSort;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class QuickSortBenchmark {

    private static final int NUMBER = 123456789;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    public void testSortDesc() {
        QuickSort.sortDesc(NUMBER);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    public void testSortDescInJava() {
        QuickSort.sortDescInJava(NUMBER);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}