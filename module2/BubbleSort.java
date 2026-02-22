package module2;

/**
 * Bubble Sort Implementation
 * Time Complexity: O(n^2)
 */
public class BubbleSort {
    
    public static void sort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping, array is sorted
            if (!swapped) break;
        }
    }
    
    public static long sortWithTime(int[] arr) {
        long start = System.nanoTime();
        sort(arr);
        return System.nanoTime() - start;
    }
}
