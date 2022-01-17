package dev.namtx.geeksforgeeks.graph.primswithpriorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    static class Edge implements Comparable<Edge> {
        static int totalEdges = 0;
        Vertex from;
        Vertex to;
        int cost;

        Edge(Vertex from, Vertex to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    static class Vertex {
        boolean visited;
        List<Edge> edges;
        char name;

        public Vertex(char name) {
            this.name = name;
            this.visited = false;
            this.edges = new ArrayList<>();
        }

        void connect(Vertex to, int cost) {
            edges.add(new Edge(this, to, cost));
            edges.add(new Edge(to, this, cost));
            Edge.totalEdges += 2;
        }

        @Override
        public String toString() {
            return String.valueOf(name);
        }
    }

    static class Prims {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;

        boolean findMST(Vertex s) {
            this.addEdges(s);
            int edgeCount = 0;

            while (!this.pq.isEmpty() && edgeCount != Edge.totalEdges) {
                Edge minEdge = this.pq.peek();
                this.pq.poll();

                if (minEdge.to.visited) {
                    continue;
                }

                edgeCount++;
                this.totalCost += minEdge.cost;
                this.mst.add(minEdge);
                this.addEdges(minEdge.to);
            }

            return edgeCount != Edge.totalEdges;
        }

        void addEdges(Vertex v) {
            v.visited = true;
            for (Edge e : v.edges) {
                if (!e.to.visited) {
                    this.pq.add(e);
                }
            }
        }
    }

    static class Main {
        public static void main(String[] args) {
            //vertices of the graph
            Vertex[] vertices = {
                    new Vertex('A'),
                    new Vertex('B'),
                    new Vertex('C'),
                    new Vertex('D'),
                    new Vertex('E')
            };

            //connecting vertices
            vertices[0].connect(vertices[1], 3);
            vertices[0].connect(vertices[3], 5);
            vertices[1].connect(vertices[2], 2);
            vertices[1].connect(vertices[3], 10);
            vertices[2].connect(vertices[3], 7);
            vertices[2].connect(vertices[4], 8);
            vertices[3].connect(vertices[4], 1);

            //driver code
            Prims prims = new Prims();
            if (prims.findMST(vertices[0])) {
                System.out.println(prims.mst);
                System.out.println("Total Cost: " + prims.totalCost);
            } else {
                System.out.println("MST not possible for given graph");
            }
        }
    }
}
