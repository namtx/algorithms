package dev.namtx.geeksforgeeks.graph.iterativedfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://www.geeksforgeeks.org/iterative-depth-first-traversal/">https://www.geeksforgeeks.org/iterative-depth-first-traversal/</a>
 */
class Graph {
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public void dfs(int source, boolean[] visited) {
        Stack<Integer> s = new Stack<>();
        s.add(source);

        while (!s.isEmpty()) {
            int curr = s.pop();
            visited[curr] = true;
            System.out.println("Visiting " + curr);

            List<Integer> adjacent = adj.get(curr);
            for (int a : adjacent) {
                if (!visited[a]) {
                    s.add(a);
                }
            }
        }
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

        boolean[] visited = new boolean[4];
        g.dfs(2, visited);
    }
}
