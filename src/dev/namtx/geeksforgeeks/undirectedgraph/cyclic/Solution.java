package dev.namtx.geeksforgeeks.undirectedgraph.cyclic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/detect-cycle-undirected-graph/">https://www.geeksforgeeks.org/detect-cycle-undirected-graph/</a>
 */
class Graph {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            this.adj.add(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }

    private boolean isCyclicUtil(int i, boolean[] visited, int parent) {
        visited[i] = true;

        List<Integer> adjacent = adj.get(i);

        for (int a : adjacent) {
            if (!visited[a]) {
                if (isCyclicUtil(a, visited, i)) {
                    return true;
                }
            } else if (a != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}
