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
            Integer[] minJumps = new Integer[inputArray.length];

            minJumps[inputArray.length-1] = 0;

            for (int i = inputArray.length - 2; i >= 0; i--) {
                Integer shortestJumps = null;
                for (int j = i+1; j <= Math.min(inputArray.length-1, i+inputArray[i]); j++) {
                    if (minJumps[j]!=null && (shortestJumps==null || minJumps[j]<shortestJumps)) {
                        shortestJumps = minJumps[j]+1;
                    }
                }
                minJumps[i] = shortestJumps;
            }

            return (minJumps[0]!=null) ? minJumps[0] : -1;
        }
        return 0;
    }
}
