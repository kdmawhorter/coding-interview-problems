package interviewbit;

/**
 * A class designed to answer the problem related to InterviewBit Amazon Problems
 * <a href="https://www.interviewbit.com/problems/palindrome-partitioning-ii/">Palindrome Partitioning II</a>.
 */
public class Palindrome {

    /**
     * Returns the minimum number of cuts needed to produce all palindrome slices.
     * @param inputString The string to be analyzed for palindromes.
     * @return The minimum number of cuts to yield all palindrome slices.
     */
    public int minCutsPalindromePartition(String inputString) {
        if (!inputString.isEmpty()) {
            int numberPalindromes = 0;
            for (int i = 0; i < inputString.length(); i++) {
                int scanJ = inputString.length()-1;

                while(isNotPalindrome(inputString, i, scanJ)) { scanJ--; }
                numberPalindromes++;
                i = scanJ;
            }
            return  numberPalindromes-1;
        }
        return 0;
    }

    private boolean isNotPalindrome(String inputString, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++, endIndex--) {
            if (inputString.charAt(i) != inputString.charAt(endIndex)) {
                return true;
            }
        }
        return false;
    }
}
