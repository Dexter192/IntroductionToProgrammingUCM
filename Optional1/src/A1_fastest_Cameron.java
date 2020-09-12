public class A1_fastest_Cameron {
    public static void main(String[] args) {
        int maxN = 10000000;
        int maxSequenceLength = 0;
        for(int i = 1; i <= maxN; i++) {
            int sequenceLength = collatz(i);

            if (sequenceLength > maxSequenceLength) {
                maxSequenceLength = sequenceLength;
            }
        }
        System.out.println(maxSequenceLength);
    }

    public static int collatz(final int n) {
        int iterations = 0;
        for (int m = n; m > 1; m = (m % 2 == 0) ? m/2 : 3*m+1)
            iterations++;
        return iterations;
    }
}
