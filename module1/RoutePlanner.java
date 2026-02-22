package module1;

import java.util.*;

/**
 * Route Planner - Main controller for Module 1
 * Smart City Route Planner using BST + Graph
 */
public class RoutePlanner {
    
    private BST bst;
    private Graph graph;
    private Scanner scanner;
    
    public RoutePlanner() {
        this.bst = new BST();
        this.graph = new Graph();
        this.scanner = new Scanner(System.in);
        initSampleData();
    }
    
    private void initSampleData() {
        String[] locations = {"City Center", "Airport", "Mall", "University", "Hospital", "Park"};
        for (String loc : locations) {
            bst.insert(loc);
            graph.addVertex(loc);
        }
        
        graph.addEdge("City Center", "Airport");
        graph.addEdge("City Center", "Mall");
        graph.addEdge("City Center", "University");
        graph.addEdge("City Center", "Hospital");
        graph.addEdge("City Center", "Park");
        graph.addEdge("Airport", "Mall");
        graph.addEdge("University", "Park");
    }
    
    public static void runMenu() {
        RoutePlanner rp = new RoutePlanner();
        rp.menu();
    }
    
    private void menu() {
        int choice;
        do {
            System.out.println("\n========== Route Planner ==========");
            System.out.println("1. Add Location");
            System.out.println("2. Remove Location");
            System.out.println("3. Add Road");
            System.out.println("4. Remove Road");
            System.out.println("5. Show All Locations");
            System.out.println("6. Show All Connections");
            System.out.println("7. Find Route (DFS)");
            System.out.println("8. Find Route (BFS)");
            System.out.println("9. Back to Main");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addLocation(); break;
                case 2: removeLocation(); break;
                case 3: addRoad(); break;
                case 4: removeRoad(); break;
                case 5: showLocations(); break;
                case 6: showConnections(); break;
                case 7: findRouteDFS(); break;
                case 8: findRouteBFS(); break;
                case 9: break;
                default: System.out.println("Invalid!"); break;
            }
        } while (choice != 9);
    }
    
    private void addLocation() {
        System.out.print("Location name: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty() && !bst.search(name)) {
            bst.insert(name);
            graph.addVertex(name);
            System.out.println("Added!");
        } else {
            System.out.println("Invalid or exists!");
        }
    }
    
    private void removeLocation() {
        System.out.print("Location name: ");
        String name = scanner.nextLine().trim();
        if (bst.search(name)) {
            bst.delete(name);
            graph.removeVertex(name);
            System.out.println("Removed!");
        } else {
            System.out.println("Not found!");
        }
    }
    
    private void addRoad() {
        System.out.print("From: ");
        String from = scanner.nextLine().trim();
        System.out.print("To: ");
        String to = scanner.nextLine().trim();
        
        if (bst.search(from) && bst.search(to) && !from.equals(to)) {
            graph.addEdge(from, to);
            System.out.println("Road added!");
        } else {
            System.out.println("Invalid locations!");
        }
    }
    
    private void removeRoad() {
        System.out.print("From: ");
        String from = scanner.nextLine().trim();
        System.out.print("To: ");
        String to = scanner.nextLine().trim();
        
        graph.removeEdge(from, to);
        System.out.println("Road removed!");
    }
    
    private void showLocations() {
        System.out.println("\n=== All Locations ===");
        bst.inorder();
    }
    
    private void showConnections() {
        graph.displayAll();
    }
    
    private void findRouteDFS() {
        System.out.print("Start: ");
        String start = scanner.nextLine().trim();
        System.out.print("End: ");
        String end = scanner.nextLine().trim();
        
        List<String> path = graph.dfs(start, end);
        if (path != null) {
            System.out.println("Route: " + String.join(" -> ", path));
        } else {
            System.out.println("No route!");
        }
    }
    
    private void findRouteBFS() {
        System.out.print("Start: ");
        String start = scanner.nextLine().trim();
        System.out.print("End: ");
        String end = scanner.nextLine().trim();
        
        List<String> path = graph.bfs(start, end);
        if (path != null) {
            System.out.println("Route: " + String.join(" -> ", path));
        } else {
            System.out.println("No route!");
        }
    }
}
