package interview_11APR22;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Problem #2 from Interview on 11APR22.<br>
 * <br>
 * A class designed to answer whether two bits in an integer are equivalent. A BitIndexComparisons object can return
 * whether bits k1 and k2 of bit string n are equivalent by calling {@link #compareBitPositions(String)}.
 */
public class BitIndexComparisons {

    /**
     * Returns whether the k1 and k2 bits, from a one-indexing perspective, are equivalent in some integer n.
     *
     * @param inputLine a String expected to be formatted as "n,k1,k2"
     *
     * @return a boolean representing whether the k1 and k2 bits of the binary string of n are equivalent
     */
    public boolean compareBitPositions(@NotNull String inputLine) {
        return compareBitPositions(parseBitPositionsLine(inputLine));
    }

    /**
     * Parses a comma separated line containing n, k1, and k2 for compareBitPositions. Only integers are
     * expected. Upon splitting the input line string, if more or less than 3 fields are present {0, 0, 0}
     * is returned.
     *
     * @param inputLine a string expected to be formatted as "n,k1,k2"
     *
     * @return an int array containing {n, k1, k2}
     */

    public int[] parseBitPositionsLine(@NotNull String inputLine) {
        int[] intArray = { 0, 0, 0};
        String[] strArray = inputLine.split(",");

        if (strArray.length == 3) {
            intArray = Arrays.stream(strArray).mapToInt(Integer::valueOf).toArray();
        }

        return intArray;
    }

    private boolean compareBitPositions(int[] intArray) {
        if (intArray!=null && intArray.length==3) {
            return getBitOneIndexed(intArray[0], intArray[1]) == getBitOneIndexed(intArray[0], intArray[2]);
        }
        return false;
    }

    /**
     * Returns the value of the kth bit of n, from a one-indexing perspective, as an integer.
     *
     * @param n An integer.
     * @param k The 1-indexed index to be returned.
     * @return The bit value of the kth index of n (1-indexed).
     *
     */
    public int getBitOneIndexed(int n, int k) {
        int bitAtPosK = 0;
        if (k>=1 && k<=Integer.SIZE) {
            bitAtPosK = (n >> (k-1)) & 1;
        }
        return bitAtPosK;
    }
}
