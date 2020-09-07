public class A1_medium {
    /**
     * Solution to optional exercise A1:
     * This solution is a bit more efficient and uses the property that if we reach a value which is a power of 2, then
     * we know that the all the remaining numbers will be divided by two. The amount of how often we have to do that is
     * the log2(n).
     * E.g. n=16 sqrt(16)=4  16,8,4,2,1
     * If you don't understand the code, try to debug it before contacting me
     * @author Daniel Kaestner
     */
        public static void main(String [] args) {
            //We use this to keep track of the longest sequence that we encounter
            int longestSequence = 0;
            //The highest n that we want to check
            long maxN = 100;

            for(int i = 1; i <= maxN; i++) {
                //We set n to the current value of i
                long n = i;
                //We want to keep track of the sequence length for the current n
                int sequenceLength = 1;
                while (n > 1) {
                    //Since we entered the while block, it means that n is not 1 and we have at least one more number in our iteration
                    sequenceLength++;
                    //We append n to our sequence string
                    // % is the modulo operator which returns the rest of a division. If n%2=0, then n is even and we divide n by 2
                    if (n % 2 == 0) {
                        n = n / 2;
                        //If n is not even, then n is odd and we set n to n=3*n+1
                    } else {
                        n = 3 * n + 1;
                    }
                    //We use the property which is explained above
                    if(Math.log(n)%2==0) {
                        sequenceLength += Math.log(n);
                        break;
                    }
                }
                System.out.println("n=" + i + " Sequence length - " + sequenceLength);
                if(sequenceLength > longestSequence) {
                    longestSequence = sequenceLength;
                }
            }
            System.out.println("Longest sequence: " + longestSequence);
    }
}
