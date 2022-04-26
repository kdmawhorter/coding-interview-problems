package interviewbit;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems
 * <a href="https://www.interviewbit.com/problems/gas-station/">Edit Distance</a>.
 */
public class GasStation {

    /**
     * Given an array of fuel replenishments and fuel costs, calculates the smallest starting index where the arrays
     * can be traversed in a cycle. At an index i, the index can be advanced if the fuel accumulated for the traversal
     * plus the fuel replenished at index i is less the fuel cost at i. The only allowed motion is a left-to-right cycle
     * for the array (i.e. 0->1->2->...->(n-2)->(n-1)->0->1).
     *
     * @param fuelReplenishment an array dictating how much fuel is restored at each index
     * @param fuelCostToMove an array dictating how much fuel is spent to advance from that index
     * @return the smallest index from which a cycle may be completed, or -1 if none.
     */

    public int minimumCycleIndex(int[] fuelReplenishment, int[] fuelCostToMove) {
        if (fuelReplenishment!= null &&
                fuelCostToMove!= null &&
                fuelReplenishment.length == fuelCostToMove.length) {

            for (int startIdx=0; startIdx<fuelReplenishment.length; startIdx++) {
                int currentIdx = startIdx;
                int accumulatedFuel = 0;
                boolean startedRunning = false;

                while (accumulatedFuel>=0) {
                    if (currentIdx==startIdx && startedRunning) {
                        return startIdx;
                    }

                    startedRunning = true;
                    accumulatedFuel += fuelReplenishment[currentIdx] - fuelCostToMove[currentIdx];
                    currentIdx = (currentIdx==fuelReplenishment.length-1) ? 0 : currentIdx+1;
                }
            }

        }
        return -1;
    }
}
