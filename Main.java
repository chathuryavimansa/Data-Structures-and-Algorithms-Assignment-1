/**
 * Main Entry Point
 * University Project: Data Structure & Algorithm Tool
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n===================================");
            System.out.println("  DATA SORTER - ALGORITHM TOOL");
            System.out.println("===================================");
            System.out.println("1. Route Planner");
            System.out.println("2. Data Sorter");
            System.out.println("3. Performance Analyzer");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    module1.RoutePlanner.runMenu();
                    break;
                case 2:
                    module2.DataSorter.runMenu();
                    break;
                case 3:
                    module3.PerformanceAnalyzer.runMenu();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid!");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
