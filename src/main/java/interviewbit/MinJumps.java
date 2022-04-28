package interviewbit;


/**
 * A class designed to answer the problem related to InterviewBit Amazon Problems
 * <a href="https://www.interviewbit.com/problems/min-jumps-array/">Min Jumps Array</a>.
 */
public class MinJumps {

    /**
     * Returns the minimum number of jumps required to reach the end of an input array of possible max jump lengths.
     * @param inputArray The max jump possible at each index
     * @return The minimum number of jumps needed to reach the end.
     */
    public int minJumpsArray(int[] inputArray) {
        if (inputArray != null && inputArray.length>1) {
            return 0;
        }
        return 0;
    }
}
