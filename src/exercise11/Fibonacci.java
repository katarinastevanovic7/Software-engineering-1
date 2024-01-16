package exercise11;

public class Fibonacci {

    public static long fibonacci(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 45;

        System.out.println("Sequential execution:");
        //startTime = aktuelle Millisekunden
        long startTime = System.currentTimeMillis();

        System.out.printf("%d. fibonacci number is %d%n", n, fibonacci(n));
        System.out.printf("%d. fibonacci number is %d%n", n + 1, fibonacci(n + 1));

        System.out.printf("Duration: %.3fs%n", (System.currentTimeMillis() - startTime) / 1000.0); // 6,887s

        //TODO: parallel execution

        System.out.println("\nParallel execution");
        startTime = System.currentTimeMillis();

        // Thread = Runnable-Instanzen parallel auszuführen
        // Dazu übergeben wir sie der Klasse Thread im Konstruktur als Lambda-Ausdruck
        Thread thread1 = new Thread(() -> {
            long fibonacciN = fibonacci(n);
            System.out.printf("%d. fibonacci number is %d%n", n, fibonacciN);
        });

        Thread thread2 = new Thread(() -> {
            long fibonacciNPlus1 = fibonacci(n + 1);
            System.out.printf("%d. fibonacci number is %d%n", n + 1, fibonacciNPlus1);
        });


        thread1.start();    // start() = Threads starten
        thread2.start();

        thread1.join();     //join() = aktiv warten in der main-Methode, bis ein Thread beendet wurde
        thread2.join();     // -> ohne join() wäre main-Methode schon fertig, Ausgabe von Z.45 vor den Ausgaben der Threads

        System.out.printf("Duration: %.3fs%n", (System.currentTimeMillis() - startTime) / 1000.0);  //4,239s ->
        // Zeitersparnis von 2,648s mit paralleler Ausführung
    }
}

