package dev.namtx.leetcode.miniumnumberofdaystodisconnectisland;

public class Solution {
    private static final int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int numberOfIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] move : moves) {
            int di = i + move[0];
            int dj = j + move[1];
            if (di < 0 || di >= grid.length || dj < 0 || dj >= grid[0].length || visited[di][dj] || grid[di][dj] == 0) {
            } else {
                dfs(grid, di, dj, visited);
            }
        }
    }

    public int minDays(int[][] grid) {
        if (numberOfIslands(grid) != 1) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (numberOfIslands(grid) != 1) {
                        return 1;
                    } else {
                        grid[i][j] = 1;
                    }
                }
            }
        }

        return 2;
    }
}
