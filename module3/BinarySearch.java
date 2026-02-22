package module3;

/**
 * Binary Search Implementation
 * Time Complexity: O(log n)
 * Note: Array must be sorted
 */
public class BinarySearch {
    
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
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
