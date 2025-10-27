import java.math.BigInteger;

public class fibonacci {
    public static void main(String[] args) {
        
    }
    
    // ! need to fix this later
    public static String instructions = """
                fibonacci genarateF <fileName || filePath> --n <iteration number>
                fibonacci genarateS <fileName || filePath> --n <iteration number>
                fibonacci read <fileName || filePath> --n <iteration number>
            """;

    private static void  print_instruction() { 
        print(instructions);   
    }

    public static BigInteger i1 = BigInteger.ZERO;
    public static BigInteger i2 = BigInteger.ONE;
    public static long iteration = 0;

    private static void fibonacciNextSteps() {
        i2 = i2.add(i1); // i2 += i1
        i1 = i2.subtract(i1); // i1 = i2 - i1
        iteration++;
    }

    public static void generate_chunking() {
        fibonacciNextSteps();
    }

    public static void generate_saving() {
        fibonacciNextSteps();
    }

    public static void read() {

    }

    public static BigInteger read(long n) {
        return BigInteger.ONE;
    }
}