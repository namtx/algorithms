package dev.namtx.geeksforgeeks.graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <a href="https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph">https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/</a>
 * <br>
 * <p>
 * Time complexity: <b>O(V+E)</b> where <b>V</b> is number of vertices in the graph, and <b>E</b> is number of edges in the graph
 */
class Graph {
    private int v;
    private LinkedList[] adj;

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

    public void bfs(int s) {
        boolean[] visited = new boolean[v];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() > 0) {
            s = queue.poll();
            System.out.println(s + " ");
            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
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

        g.bfs(2);
    }
}
