package exercise11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeNumbers {

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;           // gibt keine Primzahl <2
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;       // keine Primzahl wenn es einen Teiler für n gibt
            }
        }
        return true;    // keine Teilbarkeit fur n -> Primzahl
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


        // Non-parallel execution
        List<Integer> primes;
        primes = Stream.iterate(2, n -> n + 1)
                .filter(PrimeNumbers::isPrime)
                .limit(30000)
                .collect(Collectors.toList());

        long nonParallelTime = System.currentTimeMillis() - startTime;


        System.out.printf("Non-parallel Duration: %.3fs%n", (System.currentTimeMillis() - startTime) / 1000.0); //2,456s

        System.out.println(primes.subList(0, 100) + "...");           //first 100 and last 10 primenumbers
        System.out.println("..." + primes.subList(primes.size() - 10, primes.size()));




        // Parallel execution
        startTime = System.currentTimeMillis();
        primes = Stream.iterate(2, n -> n + 1)
                .parallel() // Convert to parallel stream
                .filter(PrimeNumbers::isPrime)  //parallele Ausführung auf die Elemente
                .limit(30000)
                .collect(Collectors.toList());
        long parallelTime = System.currentTimeMillis() - startTime;


        System.out.printf("Parallel Duration: %.3fs%n", (System.currentTimeMillis() - startTime) / 1000.0); //1,264s

        System.out.println(primes.subList(0, 100) + "...");           //first 100 and last 10 primenumbers
        System.out.println("..." + primes.subList(primes.size() - 10, primes.size()));

    }
}
