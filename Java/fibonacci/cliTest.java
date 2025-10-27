public class cliTest {
    public static void main(String[] args) {
        for (String string : args) {
            System.err.println(string);
        }



        // switch (args) {
        //     case ...:
                
        //         break;
        
        //     default:
        //         break;
        // }        
    }



    private static void printUsage() {
        System.out.println("""
            Usage:
              java Fibonacci.java -generateF <n>       Fast generation
              java Fibonacci.java -generateS <n>       Safe generation (flush each loop)
              java Fibonacci.java -read <file>         Read saved Fibonacci data
            """);
        }
}