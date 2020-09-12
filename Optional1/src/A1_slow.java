/**
 * Solution to optional exercise A1:
 * Note that this solution is not very efficient and but it should be your first attempt. Refer to A2_fast for a more
 * efficient solution.
 * It is best to try the problem yourself first and refer to the solution if you are stuck!
 * The excessive use of comments is to provide a more explicit explanation of the code as some concepts which are not yet
 * covered are used.
 * If you don't understand the code, try to debug it before contacting me
 *
 * YOU CAN DRASTICALLY INCREASE THE SPEED BY COMMENTING OUT LINE 47 AND 59 SINCE THE STRINGS ARE NOT GENERATED IN EVERY ITERATION
 * @author Daniel Kaestner
 */
public class A1_slow {
    public static void main(String [] args) {
        //We use this to keep track of the longest sequence that we encounter
        int longestSequence = 0;
        //The highest n that we want to check. If you want to use 10,000,000,000, you have to append the number with
        //a L to tell java that you are defining a long
        long maxN = 10000000;

        /* This is a for loop (coming in lecture 3). The code block surrounded by the {} will be executed multiple times
         * until we reach a terminating condition. It consists of three parts, separated with semicolons
         * The first section initialises a variable and sets a value to the variable. It is executed once.
         * The second section is our condition. Pretty much how long we want to stay in the loop. Here we run the loop
         * as long as i is smaller or equal to maxN
         * The third statement increments i after every execution of the code block (It is short hand notation for i = i+1)
         *
         * In our case we use the loop to compute the sequence length from n=1 to n=
         * More on the for-loop: https://www.w3schools.com/java/java_for_loop.asp
         */
        for(int i = 1; i <= maxN; i++) {
            //We set n to the current value of i
            long n = i;
            //We want to keep track of the sequence length for the current n
            int sequenceLength = 1;
            //We want to store the sequence in a string
            String sequence = "";

            /* A while loop works similar to a for-loop. The code block is executed as long as the condition in the ()
             * is met. We want to do the computation as long a n is not 1 (We could also use n!=1 which means n "notequal" 1)
             * More info on the while-loop: https://www.w3schools.com/java/java_while_loop.asp
             */
            while (n > 1) {
                //Since we entered the while block, it means that n is not 1 and we have at least one more number in our iteration
                sequenceLength++;
                //We append n to our sequence string
                sequence += n + " ";
                // % is the modulo operator which returns the rest of a division. If n%2=0, then n is even and we divide n by 2
                if (n % 2 == 0) {
                    n = n / 2;
                    //If n is not even, then n is odd and we set n to n=3*n+1
                } else {
                    n = 3 * n + 1;
                }
            }
            //Without this, we would miss the 1 at the end of the sequence
            sequence += n;
            //Print the sequence length and the sequence
            System.out.println("n=" + i + "Sequence length - " + sequenceLength + ": " + sequence);
            //Since we want to find the longest sequence, we want to check if the current sequence is longer than the
            //sequence that we have had so far. If so, we update it.
            if(sequenceLength > longestSequence) {
                longestSequence = sequenceLength;
            }
        }
        System.out.println("Longest sequence: " + longestSequence);
    }
}
