public class T3_Exercise11  {
    public static void main(String[] args) {

        long factoriali = factorialI(5);
        long factorialr = factorialR(5);
        System.out.println("Iteration " + factoriali);
        System.out.println("Recursive " + factorialr);
    }

    public static long factorialI(long n) {
        long factorial = 1;
        for(long i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static long factorialR(long n) {
        if(n == 0) {
            return 1;
        }
        return n*factorialR(n-1);
    }
}
