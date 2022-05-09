package interviewbit;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A class designed to answer the problem related to InterviewBit Adobe Problems
 * <a href="https://www.interviewbit.com/problems/grid-unique-paths/">Grid Unique Paths</a>.
 */
public class GridUniquePaths {
    private static class Pair {
        @Getter
        private final int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    /**
     * Given an mxn grid, returns the total number of paths from (0,0) to (m-1, n-1) if allowed movement at cell (i,j)
     * is to move to (i+1, j) or (i, j+1).
     * @param m The height of the grid.
     * @param n The width of the grid.
     * @return The total number of paths through the grid.
     */
    public int countUniquePaths(int m, int n) {
        if (m>0 && n>0) {
            int[][] remainingChildren = new int[m][n], uniquePaths = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < m - 1) {
                        remainingChildren[i][j] += 1;
                    }
                    if (j < n - 1) {
                        remainingChildren[i][j] += 1;
                    }
                }
            }
            uniquePaths[m - 1][n - 1] = 1;

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(m - 1, n - 1));
            while (!queue.isEmpty()) {
                Pair thisPair = queue.poll();
                int i = thisPair.getA(), j = thisPair.getB();

                if (i < m - 1) {
                    uniquePaths[i][j] += uniquePaths[i + 1][j];
                }
                if (j < n - 1) {
                    uniquePaths[i][j] += uniquePaths[i][j + 1];
                }

                if (i > 0 && --remainingChildren[i - 1][j] <= 0) {
                    queue.add(new Pair(i - 1, j));
                }
                if (j > 0 && --remainingChildren[i][j - 1] <= 0) {
                    queue.add(new Pair(i, j - 1));
                }
            }

            return uniquePaths[0][0];
        }
        return 0;
    }
}