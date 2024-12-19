package Leetcode.Graph.General;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {

        // Create a simple graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedGraph = cloneGraph.cloneGraph(node1);

        // Print the original and cloned graph to verify
        System.out.println("Original Leetcode.Graph:");
        printGraph(node1);

        System.out.println("\nCloned Leetcode.Graph:");
        printGraph(clonedGraph);
    }

    private static void printGraph(Node node) {
        Map<Node, Boolean> visited = new HashMap<>();
        printGraphHelper(node, visited);
    }

    private static void printGraphHelper(Node node, Map<Node, Boolean> visited) {
        if (node == null || visited.containsKey(node)) return;

        visited.put(node, true);
        System.out.print("Node " + node.val + " neighbors: ");

        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraphHelper(neighbor, visited);
        }
    }
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNewMap=new HashMap<>();
        return dfs(node, oldToNewMap);


    }

    private Node dfs(Node node, Map<Node, Node> oldToNewMap) {
        if(node==null)
            return node;

        if(oldToNewMap.containsKey(node))
            return oldToNewMap.get(node);

        Node copy=new Node(node.val);
        oldToNewMap.put(node, copy);

        //for neighbours
        for(Node neighbour: node.neighbors){
            copy.neighbors.add(dfs(neighbour, oldToNewMap));
        }

        return copy;
    }
}
