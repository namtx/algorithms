package dev.namtx.geeksforgeeks.graph.bfsshortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[][] moves = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public void shortestPath(Character[][] matrix) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean found = false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] px = new int[matrix.length][matrix[0].length];
        int[][] py = new int[matrix.length][matrix[0].length];
        qx.add(0);
        qy.add(0);

        while (!qx.isEmpty() && !qy.isEmpty() && !found) {
            int x = qx.poll();
            int y = qy.poll();

            visited[x][y] = true;

            for (int[] move : moves) {
                int dx = x + move[0];
                int dy = y + move[1];
                if (dx >= 0 && dx < matrix.length && dy >= 0 && dy < matrix[0].length && !visited[dx][dy] && matrix[dx][dy] != '#') {
                    if (matrix[dx][dy] == 'E') {
                        System.out.println("Found!");
                        px[dx][dy] = x;
                        py[dx][dy] = y;
                        printPath(matrix, px, py, dx, dy);
                        found = true;
                        break;
                    } else {
                        qx.add(dx);
                        qy.add(dy);
                        px[dx][dy] = x;
                        py[dx][dy] = y;
                    }
                }
            }
        }
    }

    private void printPath(Character[][] matrix, int[][] px, int[][] py, int x, int y) {
        int i = x;
        int j = y;
        while (matrix[i][j] != 'S') {
            System.out.println("(" + i + ", " + j + ")");
            int tmp = px[i][j];
            j = py[i][j];
            i = tmp;
        }

        System.out.println("(" + i + ", " + j + ")");
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Character[][] matrix = new Character[][]{
                {'S', '.', '.', '#', '.', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '.'},
                {'.', '.', '#', '#', '.', '.', '.'},
                {'#', '.', '#', 'E', '.', '#', '.'}
        };

        solution.shortestPath(matrix);
    }
}
