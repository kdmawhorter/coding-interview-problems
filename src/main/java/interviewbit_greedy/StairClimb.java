package interviewbit_greedy;

public class StairClimb {

    /**
     * Returns the number of possible 1 and 2 step paths up a stair of stairCount of steps. Since the number of steps
     * to reach step i is equal to the number of steps to reach step i-2 plus the steps to reach i-1, this is the
     * Fibonacci sequence.
     *
     * @param stairCount = The number of stairs to be traversed
     * @return the total possible 1 and 2 step combinations
     */
    public int waysToClimbStairs(int stairCount) {
        int a=1, b=1, temp;

        while (stairCount-- > 1) {
            temp = a;
            a = b;
            b = a+temp;
        }
        return b;
    }
}
