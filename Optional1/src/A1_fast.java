import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class A1_fast {
    /**
     * Solution to optional exercise A1:
     * For this solution we use some more advanced concepts: This is out of the scope of this course but if you are
     * generally interested in Computer Science, it might be interesting
     * We use the property from the medium solution but here we will also keep track of additional fields that we encounter
     * in the chain and store them. This is a sort of dynamical approach where we use the solutions that we found from the
     * prior numbers
     * Going for 10,000,000,000 still takes quite some time but this is the fastest approach I can come up with
     *
     * If you don't understand the code, try to debug it before contacting me
     * @author Daniel Kaestner
     */
    public static void main(String [] args) {
        //We use this to keep track of the longest sequence that we encounter
        int longestSequence = 0;
        //The highest n that we want to check
        long maxN = 1000000;
        /* This is a datatype which we won't cover in the course.
         * A Map links two datatypes (indicated in the <>) in a key value fashion. The key is a number n and the
         * value is the sequence length to 1 from that number. For every step, we check if we have a key of the
         * current n. If so, we can stop since we know how long the sequence is from that n.
         */
        Map<Long, Integer> sequenceLengthFromNumber = new HashMap<>();


        for(int i = 1; i <= maxN; i++) {
            //We set n to the current value of i
            long n = i;
            //An array list is just a more performant way to store an array (we will cover this later)
            ArrayList<Long> sequence = new ArrayList();
            //We want to keep track of the sequence length for the current n
            int sequenceLength = 1;
            while (n > 1) {
                //In this approach we want to store the sequence again
                sequence.add(n);
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

                if(sequenceLengthFromNumber.containsKey(n)) {
                    sequenceLength += sequenceLengthFromNumber.get(n);
                    break;
                }

                //We use the property which is explained above
                if(Math.log(n)%2==0) {
                    sequenceLength += Math.log(n);
                    break;
                }
            }
            if(i%(maxN/100) == 0) {
                System.out.println((double)(100*i/maxN) + "%");
            }
            //Update the longest sequence if the current sequence length is longer than what we encountered so far
            if(sequenceLength > longestSequence) {
                longestSequence = sequenceLength;
            }

            //After we reached 1, we want to fill up our map with the values that we found from this sequence
            for(int j = 0; j<sequence.size(); j++) {
                sequenceLength--;
                sequenceLengthFromNumber.put(sequence.get(j), sequenceLength);
            }
        }
        System.out.println("Longest sequence: " + longestSequence);
    }
}
