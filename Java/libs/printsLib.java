public class universal_lib {
        public static void print(Object value) {
        print(value, 1, true, 1);
    }
    public static void print(Object value, boolean ln) {
        print(value, 1, ln, 1);
    }
    public static void print(Object value, boolean ln, int loopL) {
        print(value, 1, ln, loopL);
    }
    public static void print(Object value, int loopV, boolean ln) {
        print(value, loopV, ln, 1);
    }
    public static void print(Object value, int loopV, boolean ln, int loopL) {
        String val = String.valueOf(value);
        System.out.print(val.repeat(loopV) + (ln ? "\n".repeat(loopL) : ""));
    }
}
