public class T3_Exercise10 {
    public static void main(String[] args) {
        printStars(7);
    }

    public static void printStars(int n) {
        //Nested for loop for the upper half
        for(int L = 0; L < n/2; L++) {
            //Since we subtract L at every iteration, we print one less space every time
            for(int j = 0; j < n/2-L; j++) {
                System.out.print(" ");
            }
            //For every iteration we want to print two more *
            for(int j = 0; j <= 2*L; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Nested for loop for the lower half
        for(int L = 0; L <= n/2; L++) {
            //For every iteration we want to print one more space
            for(int j = 0; j < L; j++) {
                System.out.print(" ");
            }
            //For every iteration we want to print one * less
            for(int j = 0; j < n-2*L; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
