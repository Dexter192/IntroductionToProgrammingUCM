import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        int[] sorted = split(a);
        System.out.println("Initial: " + Arrays.toString(a));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }

    public static int[] split(int[] array) {
        if(array.length <= 1) {
            return array;
        }
        int middle = array.length/2;
        int[] leftSubArray = Arrays.copyOfRange(array,0, middle);
        int[] rightSubArray = Arrays.copyOfRange(array, middle, array.length);

        leftSubArray = split(leftSubArray);
        rightSubArray = split(rightSubArray);

        int[] mergedArray = merge(leftSubArray, rightSubArray);
        return mergedArray;
    }

    public static int[] merge(int[] leftSubArray, int[] rightSubArray) {
        int combinedLength = leftSubArray.length + rightSubArray.length;
        int[] mergedArray = new int[combinedLength];
        int leftIterator = 0;
        int rightIterator = 0;
        for(int i = 0; i < combinedLength; i++) {
            if(rightIterator >= rightSubArray.length || leftIterator < leftSubArray.length && leftSubArray[leftIterator] < rightSubArray[rightIterator]) {
                mergedArray[i] = leftSubArray[leftIterator];
                leftIterator++;
            }
            else {
                mergedArray[i] = rightSubArray[rightIterator];
                rightIterator++;
            }
        }
        return mergedArray;
    }
}
