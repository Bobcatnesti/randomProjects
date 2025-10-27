import java.io.*;
import java.math.BigInteger;
import java.util.zip.GZIPInputStream;

public class FibonacciReader {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                    new GZIPInputStream(
                        new FileInputStream("fibonacci.bin.gz"))))) {

            while (in.available() > 0) {
                int len = in.readShort() & 0xFFFF;
                byte[] bytes = new byte[len];
                in.readFully(bytes);
                BigInteger fib = new BigInteger(bytes);
                System.out.println(fib);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
