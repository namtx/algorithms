package dev.namtx.geeksforgeeks.graph.findnumberofislands;

/**
 * <a href="https://www.geeksforgeeks.org/find-number-of-islands/">https://www.geeksforgeeks.org/find-number-of-islands/</a>
 */
public class Solution {
    static final int[][] moves = new int[][]{
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };

    public int numberOfIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i, j, matrix, visited);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int[][] matrix, boolean[][] visited) {
        visited[i][j] = true;

        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] == 1) {
                dfs(x, y, matrix, visited);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(solution.numberOfIslands(mat));
    }
}
