package dev.namtx.geeksforgeeks.graph.detectcycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/detect-cycle-in-a-graph/">https://www.geeksforgeeks.org/detect-cycle-in-a-graph/</a>
 */
class Graph {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[i]) {
            return true;
        }

        if (visited[i]) {
            return true;
        }

        visited[i] = true;

        recursionStack[i] = true;
        List<Integer> adjacent = adj.get(i);

        for (int a : adjacent) {
            if (isCyclicUtil(a, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[i] = false;

        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if (g.isCyclic()) {
            System.out.println("Graph contains cycle!");
        } else {
            System.out.println("Graph doesn't contain cycle!");
        }
    }
}
