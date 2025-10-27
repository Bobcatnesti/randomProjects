import java.io.*;
import java.math.BigInteger;
import java.util.zip.GZIPOutputStream;
import java.util.concurrent.atomic.AtomicLong;

public class fibonacci {
    public static void main(String[] args) {

        AtomicLong iteration = new AtomicLong();

        // --- Progress monitor thread ---
        Thread monitor = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.out.println("Iteration: " + iteration.get());
                }
            } catch (InterruptedException e) {
                // exit thread gracefully
            }
        });
        monitor.setDaemon(true); // auto-stops when main exits or Ctrl+C
        monitor.start();

        long killSwitch = 1_000_000_000L; // how many iterations
        BigInteger i1 = BigInteger.ZERO;
        BigInteger i2 = BigInteger.ONE;
        File file = new File("fibonacci.bin.gz");

        long start = System.nanoTime();

        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                    new GZIPOutputStream(
                        new FileOutputStream(file), 8192)))) {

            while (i1.compareTo(i2) <= 0 && iteration.get() < killSwitch) {
                byte[] bytes = i1.toByteArray();
                out.writeShort(bytes.length);
                out.write(bytes);

                i2 = i2.add(i1); // i2 += i1;
                i1 = i2.subtract(i1); // i1 = i2 - i1;

                iteration.incrementAndGet();
            }

            long end = System.nanoTime();
            double elapsedSec = (end - start) / 1e9;

            System.out.println("\nIteration limit reached, stopping...");
            System.out.println("Saved " + iteration.get() + " Fibonacci numbers to:");
            System.out.println(file.getAbsolutePath());
            System.out.printf("File size: %.2f KB%n", file.length() / 1024.0);
            System.out.printf("Elapsed time: %.2f seconds%n", elapsedSec);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            monitor.interrupt(); // stop progress thread safely
            System.gc();
        }
    }
}
