package dev.namtx.geeksforgeeks.graph.detectcyclicgraphbycolors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {
    static int WHITE = 0, GRAY = 1, BLACK = 2;
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    private boolean isCyclicUtil(int i, int[] colors) {
        colors[i] = GRAY;
        List<Integer> adjacent = adj.get(i);
        for (int a : adjacent) {
            if (colors[a] == GRAY) return true;

            if (colors[a] == WHITE && isCyclicUtil(a, colors)) {
                return true;
            }
        }

        colors[i] = BLACK;

        return false;
    }

    public boolean isCyclic() {
        int[] colors = new int[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, colors)) {
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
        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
