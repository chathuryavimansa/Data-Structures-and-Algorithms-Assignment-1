package module2;

import java.util.*;

/**
 * Data Sorter - Main controller for Module 2
 * Compares Bubble, Merge, Quick Sort
 */
public class DataSorter {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void runMenu() {
        int[] numbers = null;
        int choice;
        
        do {
            System.out.println("\n========== Data Sorter ==========");
            System.out.println("1. Enter Numbers");
            System.out.println("2. Generate Random Numbers");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Compare All");
            System.out.println("7. Back to Main");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1: numbers = enterNumbers(); break;
                case 2: numbers = generateRandom(); break;
                case 3: 
                    if (numbers != null) {
                        int[] copy = numbers.clone();
                        long time = BubbleSort.sortWithTime(copy);
                        System.out.println("\n=== Bubble Sort ===");
                        printArray(copy);
                        System.out.println("Time: " + time + " ns");
                    } else System.out.println("Enter numbers first!");
                    break;
                case 4:
                    if (numbers != null) {
                        int[] copy = numbers.clone();
                        long time = MergeSort.sortWithTime(copy);
                        System.out.println("\n=== Merge Sort ===");
                        printArray(copy);
                        System.out.println("Time: " + time + " ns");
                    } else System.out.println("Enter numbers first!");
                    break;
                case 5:
                    if (numbers != null) {
                        int[] copy = numbers.clone();
                        long time = QuickSort.sortWithTime(copy);
                        System.out.println("\n=== Quick Sort ===");
                        printArray(copy);
                        System.out.println("Time: " + time + " ns");
                    } else System.out.println("Enter numbers first!");
                    break;
                case 6:
                    if (numbers != null) compareAll(numbers);
                    else System.out.println("Enter numbers first!");
                    break;
                case 7: break;
                default: System.out.println("Invalid!"); break;
            }
        } while (choice != 7);
    }
    
    private static int[] enterNumbers() {
        System.out.print("Enter numbers (space): ");
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        System.out.println("Saved!");
        return arr;
    }
    
    private static int[] generateRandom() {
        System.out.print("How many? ");
        int n = scanner.nextInt();
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
        System.out.println("Generated " + n + " numbers!");
        return arr;
    }
    
    private static void compareAll(int[] original) {
        System.out.println("\n=== Comparison ===");
        
        int[] b = original.clone();
        long bubbleTime = BubbleSort.sortWithTime(b);
        
        int[] m = original.clone();
        long mergeTime = MergeSort.sortWithTime(m);
        
        int[] q = original.clone();
        long quickTime = QuickSort.sortWithTime(q);
        
        System.out.println("+------------+------------------+-------------+");
        System.out.println("| Algorithm  | Time (ns)        | Time (ms)   |");
        System.out.println("+------------+------------------+-------------+");
        System.out.printf("| %-9s | %,16d | %,11f |%n", "Bubble", bubbleTime, bubbleTime/1000000.0);
        System.out.printf("| %-9s | %,16d | %,11f |%n", "Merge", mergeTime, mergeTime/1000000.0);
        System.out.printf("| %-9s | %,16d | %,11f |%n", "Quick", quickTime, quickTime/1000000.0);
        System.out.println("+------------+------------------+-------------+");
        
        long min = Math.min(bubbleTime, Math.min(mergeTime, quickTime));
        System.out.print("Fastest: ");
        if (min == bubbleTime) System.out.println("Bubble");
        else if (min == mergeTime) System.out.println("Merge");
        else System.out.println("Quick");
    }
    
    private static void printArray(int[] arr) {
        for (int i = 0; i < Math.min(20, arr.length); i++) {
            System.out.print(arr[i] + " ");
        }
        if (arr.length > 20) System.out.println("...");
        System.out.println();
    }
}
