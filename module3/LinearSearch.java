package module3;

/**
 * Linear Search Implementation
 * Time Complexity: O(n)
 */
public class LinearSearch {
    
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static long searchWithTime(int[] arr, int target) {
        long start = System.nanoTime();
        search(arr, target);
        return System.nanoTime() - start;
    }
}
