package module3;

import java.util.*;

/**
 * Performance Analyzer - Main controller for Module 3
 * Analyzes time complexity of various algorithms
 */
public class PerformanceAnalyzer {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void runMenu() {
        int choice;
        
        do {
            System.out.println("\n========== Performance Analyzer ==========");
            System.out.println("1. Test Linear Search");
            System.out.println("2. Test Binary Search");
            System.out.println("3. Test Bubble Sort");
            System.out.println("4. Test Quick Sort");
            System.out.println("5. Test Merge Sort");
            System.out.println("6. Compare All");
            System.out.println("7. Back to Main");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1: testLinearSearch(); break;
                case 2: testBinarySearch(); break;
                case 3: testBubbleSort(); break;
                case 4: testQuickSort(); break;
                case 5: testMergeSort(); break;
                case 6: compareAll(); break;
                case 7: break;
                default: System.out.println("Invalid!"); break;
            }
        } while (choice != 7);
    }
    
    // Test Linear Search
    private static void testLinearSearch() {
        System.out.println("\n=== Linear Search (O(n)) ===");
        int[] sizes = {100, 500, 1000, 5000, 10000};
        
        System.out.println("+-----------+------------------+");
        System.out.println("| Size      | Time (ns)        |");
        System.out.println("+-----------+------------------+");
        
        for (int size : sizes) {
            int[] arr = generateRandom(size);
            long time = LinearSearch.searchWithTime(arr, -1); // worst case
            System.out.printf("| %,9d | %,16d |%n", size, time);
        }
        System.out.println("+-----------+------------------+");
    }
    
    // Test Binary Search
    private static void testBinarySearch() {
        System.out.println("\n=== Binary Search (O(log n)) ===");
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        
        System.out.println("+-----------+------------------+");
        System.out.println("| Size      | Time (ns)        |");
        System.out.println("+-----------+------------------+");
        
        for (int size : sizes) {
            int[] arr = generateSorted(size);
            long time = BinarySearch.searchWithTime(arr, -1); // worst case
            System.out.printf("| %,9d | %,16d |%n", size, time);
        }
        System.out.println("+-----------+------------------+");
    }
    
    // Test Bubble Sort
    private static void testBubbleSort() {
        System.out.println("\n=== Bubble Sort (O(n^2)) ===");
        int[] sizes = {100, 500, 1000, 2000, 5000};
        
        System.out.println("+-----------+------------------+");
        System.out.println("| Size      | Time (ns)        |");
        System.out.println("+-----------+------------------+");
        
        for (int size : sizes) {
            int[] arr = generateRandom(size);
            long time = module2.BubbleSort.sortWithTime(arr.clone());
            System.out.printf("| %,9d | %,16d |%n", size, time);
        }
        System.out.println("+-----------+------------------+");
    }
    
    // Test Quick Sort
    private static void testQuickSort() {
        System.out.println("\n=== Quick Sort (O(n log n)) ===");
        int[] sizes = {100, 1000, 10000, 50000, 100000};
        
        System.out.println("+-----------+------------------+");
        System.out.println("| Size      | Time (ns)        |");
        System.out.println("+-----------+------------------+");
        
        for (int size : sizes) {
            int[] arr = generateRandom(size);
            long time = module2.QuickSort.sortWithTime(arr.clone());
            System.out.printf("| %,9d | %,16d |%n", size, time);
        }
        System.out.println("+-----------+------------------+");
    }
    
    // Test Merge Sort
    private static void testMergeSort() {
        System.out.println("\n=== Merge Sort (O(n log n)) ===");
        int[] sizes = {100, 1000, 10000, 50000, 100000};
        
        System.out.println("+-----------+------------------+");
        System.out.println("| Size      | Time (ns)        |");
        System.out.println("+-----------+------------------+");
        
        for (int size : sizes) {
            int[] arr = generateRandom(size);
            long time = module2.MergeSort.sortWithTime(arr.clone());
            System.out.printf("| %,9d | %,16d |%n", size, time);
        }
        System.out.println("+-----------+------------------+");
    }
    
    // Compare All
    private static void compareAll() {
        System.out.println("\n=== All Algorithms Comparison ===");
        
        int[] sizes = {100, 1000, 10000};
        
        // Searching
        System.out.println("\n--- Searching ---");
        System.out.println("+-----------+---------------+---------------+");
        System.out.println("| Size      | Linear (ns)   | Binary (ns)   |");
        System.out.println("+-----------+---------------+---------------+");
        
        for (int size : sizes) {
            int[] arr = generateRandom(size);
            int[] sorted = generateSorted(size);
            
            long linear = LinearSearch.searchWithTime(arr, -1);
            long binary = BinarySearch.searchWithTime(sorted, -1);
            
            System.out.printf("| %,9d | %,13d | %,13d |%n", size, linear, binary);
        }
        System.out.println("+-----------+---------------+---------------+");
        
        // Sorting
        System.out.println("\n--- Sorting ---");
        System.out.println("+-----------+---------------+---------------+---------------+");
        System.out.println("| Size      | Bubble (ns)   | Quick (ns)    | Merge (ns)    |");
        System.out.println("+-----------+---------------+---------------+---------------+");
        
        for (int size : sizes) {
            int[] arr = generateRandom(size);
            
            long bubble = module2.BubbleSort.sortWithTime(arr.clone());
            long quick = module2.QuickSort.sortWithTime(arr.clone());
            long merge = module2.MergeSort.sortWithTime(arr.clone());
            
            System.out.printf("| %,9d | %,13d | %,13d | %,13d |%n", size, bubble, quick, merge);
        }
        System.out.println("+-----------+---------------+---------------+---------------+");
        
        // Time Complexity
        System.out.println("\n=== Time Complexity Summary ===");
        System.out.println("+----------------+------------------+------------------+");
        System.out.println("| Algorithm      | Best Case        | Worst Case       |");
        System.out.println("+----------------+------------------+------------------+");
        System.out.println("| Linear Search  | O(1)             | O(n)             |");
        System.out.println("| Binary Search  | O(1)             | O(log n)         |");
        System.out.println("| Bubble Sort    | O(n)             | O(n^2)           |");
        System.out.println("| Quick Sort     | O(n log n)       | O(n^2)           |");
        System.out.println("| Merge Sort     | O(n log n)       | O(n log n)       |");
        System.out.println("+----------------+------------------+------------------+");
    }
    
    // Helpers
    private static int[] generateRandom(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }
    
    private static int[] generateSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i * 10;
        }
        return arr;
    }
}
