package interviewbit;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems on Subarrays.
 */
public class SubarrayQuestions {

    /**
     * Determines the longest subarray in an input array, from left-to-right order and not necessarily contiguous,
     * where all elements of the subarray are non-decreasing. Described by
     * <a href="https://www.interviewbit.com/problems/longest-increasing-subsequence/">Longest Increasing
     * Subsequence</a>.
     *
     * @param inputArray an int array
     * @return the longest subarray as described above
     */

    public int longestSubsequenceDetermination(int[] inputArray) {
        if (inputArray != null && inputArray.length > 0) {
            int[] longestArray = new int[inputArray.length];

            int longestSubsequence = 0;

            for (int i = longestArray.length - 1; i >= 0; i--) {
                longestArray[i]=1;

                for (int j = i+1; j < longestArray.length; j++) {
                    if (inputArray[i]<=inputArray[j]) {
                        longestArray[i] = Math.max(longestArray[i], longestArray[j]+1);
                    }
                }

                longestSubsequence = Math.max(longestSubsequence, longestArray[i]);
            }
            return longestSubsequence;
        }
        return 0;
    }

    /**
     * Returns the maximum product of any contiguous subarray of an input array. Described by
     * <a href="https://www.interviewbit.com/problems/max-product-subarray/">Max Product Subarray</a>
     *
     * @param inputArray an int array
     * @return the maximum contiguous subarray product
     */
    public int findMaxProduct(int[] inputArray) {
        if (inputArray!=null && inputArray.length>0) {
            int[] largestPositiveArray = new int[inputArray.length];
            int[] largestNegativeArray = new int[inputArray.length];

            int maxProduct = 0;

            for (int i = largestNegativeArray.length - 1; i >= 0; i--) {
                largestNegativeArray[i] = inputArray[i];
                largestPositiveArray[i] = inputArray[i];

                if (i+1 < largestNegativeArray.length) {
                    largestPositiveArray[i] = Math.max(Math.max(largestPositiveArray[i],
                                                                largestPositiveArray[i]*largestPositiveArray[i+1]),
                                                                largestPositiveArray[i]*largestNegativeArray[i+1]);
                    largestNegativeArray[i] = Math.min(Math.max(largestNegativeArray[i],
                                                                largestNegativeArray[i]*largestPositiveArray[i+1]),
                                                                largestNegativeArray[i]*largestNegativeArray[i+1]);
                }

                maxProduct = Math.max(maxProduct, largestPositiveArray[i]);
            }
            return maxProduct;

        }
        return 0;
    }
}
