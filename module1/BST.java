package module1;

import java.util.*;

/**
 * BST - Binary Search Tree for storing locations
 */
public class BST {
    
    class Node {
        String data;
        Node left, right;
        
        Node(String data) {
            this.data = data;
        }
    }
    
    private Node root;
    
    public BST() {
        this.root = null;
    }
    
    // Insert
    public void insert(String data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node node, String data) {
        if (node == null) return new Node(data);
        if (data.compareTo(node.data) < 0)
            node.left = insertRec(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insertRec(node.right, data);
        return node;
    }
    
    // Search
    public boolean search(String data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node node, String data) {
        if (node == null) return false;
        if (node.data.equals(data)) return true;
        if (data.compareTo(node.data) < 0) return searchRec(node.left, data);
        return searchRec(node.right, data);
    }
    
    // Delete
    public void delete(String data) {
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node node, String data) {
        if (node == null) return null;
        if (data.compareTo(node.data) < 0) {
            node.left = deleteRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }
    
    private String minValue(Node node) {
        String min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
    
    // Inorder traversal (for display)
    public void inorder() {
        inorderRec(root);
    }
    
    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println("  - " + node.data);
            inorderRec(node.right);
        }
    }
    
    // Get all as list
    public List<String> getAll() {
        List<String> list = new ArrayList<>();
        inorderToList(root, list);
        return list;
    }
    
    private void inorderToList(Node node, List<String> list) {
        if (node != null) {
            inorderToList(node.left, list);
            list.add(node.data);
            inorderToList(node.right, list);
        }
    }
}
