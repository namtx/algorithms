package dev.namtx.geeksforgeeks.graph.dfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <a href="https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/">https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/</a>
 */
class Graph {
    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                dfsUtil(n, visited);
            }
        }
    }

    public void dfs(int w) {
        boolean[] visited = new boolean[this.v];
        dfsUtil(w, visited);
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

        g.dfs(2);
    }
}
