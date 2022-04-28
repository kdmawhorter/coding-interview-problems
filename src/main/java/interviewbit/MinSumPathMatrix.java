package interviewbit;



import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A class designed to answer the problem related to InterviewBit Amazon Problems
 * <a href="https://www.interviewbit.com/problems/min-sum-path-in-matrix/">Min Sum Path in Matrix</a>.
 */
public class MinSumPathMatrix {

    private static class Pair {
        @Getter
        private final int m, n;

        Pair(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }

    /**
     * Returns the smallest path cost to reach (n, m) from (0,0) in NxM matrix inputMatrix.
     * @param inputMatrix The matrix to find the smallest path.
     * @return The minimum sum path cost.
     */
    public int minSumPathInMatrix(int[][] inputMatrix) {
        int m = inputMatrix.length, n = inputMatrix[0].length;

        int[][] remainingChildren = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                remainingChildren[i][j] += ((i<m-1) ? 1 : 0) + ((j<n-1) ? 1 : 0);
            }
        }
        Queue<Pair> matrixElementQueue = new LinkedList<>();

        matrixElementQueue.add(new Pair(m-1, n-1));

        while (!matrixElementQueue.isEmpty()) {
            Pair thisElem = matrixElementQueue.poll();
            if  ((thisElem.getM()<m-1) && (thisElem.getN()<n-1)) {
                inputMatrix[thisElem.getM()][thisElem.getN()] +=
                        Math.min(inputMatrix[thisElem.getM()+1][thisElem.getN()],
                                 inputMatrix[thisElem.getM()][thisElem.getN()+1]);
            } else if (thisElem.getM()<m-1) {
                inputMatrix[thisElem.getM()][thisElem.getN()] += inputMatrix[thisElem.getM()+1][thisElem.getN()];
            } else if (thisElem.getN()<n-1) {
                inputMatrix[thisElem.getM()][thisElem.getN()] += inputMatrix[thisElem.getM()][thisElem.getN()+1];
            }
            if (thisElem.getM()>0) {
                if (--remainingChildren[thisElem.getM()-1][thisElem.getN()] == 0) {
                    matrixElementQueue.add(new Pair(thisElem.getM()-1, thisElem.getN()));
                }
            }
            if (thisElem.getN()>0) {
                if (--remainingChildren[thisElem.getM()][thisElem.getN()-1] == 0) {
                    matrixElementQueue.add(new Pair(thisElem.getM(), thisElem.getN()-1));
                }
            }
        }
        return inputMatrix[0][0];
    }
}
