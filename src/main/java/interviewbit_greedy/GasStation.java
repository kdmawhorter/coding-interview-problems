package interviewbit_greedy;

public class GasStation {
    public int minimumCycleIndex(int[] fuelReplenishment, int[] fuelCostToMove) {
        if (fuelReplenishment.length == fuelCostToMove.length) {
            return 1;
        }
        return -1;
    }
}
