import java.util.Arrays;

public class T4_Exercise5 {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5};
        int[] merged = append(a,b);
        System.out.println(Arrays.toString(merged));
    }

    public static int[] append(int[] a, int[] b) {
        //Create a new array of combined length for both arrays
        int[] merged = new int[a.length+b.length];

        //Copy the first array into the merged array
        for(int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }

        //Copy the second array into the merged one. Note that we add the length of the first array to the index of merged
        for(int i = 0; i < b.length; i++) {
            merged[i+a.length] = b[i];
        }
        return merged;
    }
}
