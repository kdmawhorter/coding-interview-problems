package interviewbit_greedy;

public class SubarrayQuestions {

    /**
     * Determines the longest subarray in an input array where all elements of the subarray are non decreasing.
     *
     * @param inputArray - an int array
     * @return the longest subarray as described above
     */

    public int longestSubsequenceDetermination(int[] inputArray) {
        if (inputArray != null && inputArray.length > 0) {
            int[] longestArray = new int[inputArray.length];

            for (int i = longestArray.length - 1; i >= 0; i--) {
                longestArray[i]=1;

                for (int j = i+1; j < longestArray.length; j++) {
                    if (inputArray[i]<=inputArray[j]) {
                        longestArray[i] = Math.max(longestArray[i], longestArray[j]+1);
                    }
                }
            }
            return longestArray[0];
        }
        return 0;

    }
}
