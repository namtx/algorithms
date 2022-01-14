package dev.namtx.geeksforgeeks.graph.tarjanstronglyconnectedcomponents;

import java.util.*;

class TarjanStronglyConnectedComponents {
    private final int V;
    private final List<List<Integer>> adj;
    private final int UNVISITED = -1;
    private final int[] ids;
    private final int[] lows;
    private int id = 0;
    private final Stack<Integer> s = new Stack<>();
    private final boolean[] isOnStack;
    public int sccCount = 0;

    public TarjanStronglyConnectedComponents(int V) {
        this.V = V;
        this.adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
        ids = new int[V];
        lows = new int[V];
        isOnStack = new boolean[V];
        Arrays.fill(ids, UNVISITED);
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public void findSCCS() {
        for (int i = 0; i < V; i++) {
            if (ids[i] == UNVISITED) {
                dfs(i);
            }
        }
    }

    public void dfs(int v) {
        s.add(v);
        isOnStack[v] = true;
        ids[v] = lows[v] = id++; // Initialize the id and low value equal to the current id

        for (int w : adj.get(v)) {
            if (ids[w] == UNVISITED) {
                dfs(w);
            }
            if (isOnStack[w]) {
                lows[v] = Math.min(lows[v], lows[w]);
            }
        }

        if (ids[v] == lows[v]) {
            for (int node = s.pop() ;; node = s.pop()) {
                isOnStack[node] = false; // remove node from the stack
                lows[node] = lows[v]; // update the low value
                if (node == v) {
                    break;
                }
            }
            sccCount++;
        }
    }
}

class Main {
    public static void main(String[] args) {
        TarjanStronglyConnectedComponents g = new TarjanStronglyConnectedComponents(8);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(6, 0);
        g.addEdge(6, 2);
        g.addEdge(6, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 0);
        g.addEdge(3, 4);
        g.addEdge(3, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 5);
        g.findSCCS();
        System.out.println(g.sccCount);
    }
}
