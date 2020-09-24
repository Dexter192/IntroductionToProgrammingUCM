public class BinarySearch {
    //Find the index any number in a SORTED array in log(n) time
    public static void main(String[] args) {
        int[] a = {1,2,5,7,9,12,30};
        int index = binarySearch(a, 30, 0, a.length);
        System.out.println(index);
    }

    public static int binarySearch(int[] a, int number, int left, int right) {
        int middle = (right+left)/2;
        if(a[middle] == number) {
            return middle;
        }
        //Edge case if the number is not in the array
        if(middle == left) {
            return -1;
        }
        if(a[middle] > number) {
            return binarySearch(a, number, left, middle);
        }
        if(a[middle] < number) {
            return binarySearch(a, number, middle, right);
        }
        return -1;
    }
}
