package module1;

import java.util.*;

/**
 * Graph - Adjacency List representation for roads
 */
public class Graph {
    
    private Map<String, List<String>> adjList;
    
    public Graph() {
        this.adjList = new HashMap<>();
    }
    
    // Add vertex
    public void addVertex(String name) {
        if (!adjList.containsKey(name)) {
            adjList.put(name, new ArrayList<>());
        }
    }
    
    // Remove vertex
    public void removeVertex(String name) {
        if (adjList.containsKey(name)) {
            adjList.remove(name);
            // Remove edges to this vertex
            for (List<String> neighbors : adjList.values()) {
                neighbors.remove(name);
            }
        }
    }
    
    // Add edge (road)
    public void addEdge(String from, String to) {
        addVertex(from);
        addVertex(to);
        
        if (!adjList.get(from).contains(to)) {
            adjList.get(from).add(to);
        }
        if (!adjList.get(to).contains(from)) {
            adjList.get(to).add(from);
        }
    }
    
    // Remove edge
    public void removeEdge(String from, String to) {
        if (adjList.containsKey(from)) {
            adjList.get(from).remove(to);
        }
        if (adjList.containsKey(to)) {
            adjList.get(to).remove(from);
        }
    }
    
    // Check if vertex exists
    public boolean hasVertex(String name) {
        return adjList.containsKey(name);
    }
    
    // Check if edge exists
    public boolean hasEdge(String from, String to) {
        return adjList.containsKey(from) && adjList.get(from).contains(to);
    }
    
    // Get neighbors
    public List<String> getNeighbors(String name) {
        return adjList.getOrDefault(name, new ArrayList<>());
    }
    
    // Get all vertices
    public Set<String> getVertices() {
        return adjList.keySet();
    }
    
    // Display all connections
    public void displayAll() {
        System.out.println("\n=== All Connections ===");
        for (String name : adjList.keySet()) {
            System.out.print(name + " -> ");
            System.out.println(adjList.get(name));
        }
    }
    
    // DFS - Depth First Search using Stack
    public List<String> dfs(String start, String end) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        
        stack.push(start);
        visited.add(start);
        
        while (!stack.isEmpty()) {
            String current = stack.pop();
            
            if (current.equals(end)) {
                // Reconstruct path
                List<String> path = new ArrayList<>();
                String node = end;
                while (node != null) {
                    path.add(0, node);
                    node = parent.get(node);
                }
                return path;
            }
            
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    stack.push(neighbor);
                }
            }
        }
        return null;
    }
    
    // BFS - Breadth First Search using Queue
    public List<String> bfs(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            if (current.equals(end)) {
                List<String> path = new ArrayList<>();
                String node = end;
                while (node != null) {
                    path.add(0, node);
                    node = parent.get(node);
                }
                return path;
            }
            
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }
}
