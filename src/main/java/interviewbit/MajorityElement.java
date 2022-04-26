package interviewbit;

import java.util.HashMap;

/**
 * A class designed to answer the problem related to InterviewBit Amazon Problems
 * <a href="https://www.interviewbit.com/problems/majority-element/">Majority Element</a>.
 */
public class MajorityElement {

    /**
     * Given an input array, returns the majority element (meaning more than half), else 0 if it doesn't exist.
     *
     * @param inputArray an integer array
     * @return the majority element of that array
     */
    public int findMajorityElement(int[] inputArray) {
        if (inputArray!=null && inputArray.length>0) {
            HashMap<Integer, Integer> elementCount = new HashMap<>();

            int maxElemCnt = 0;
            int maxElem = 0;
            for (int elem : inputArray) {
                elementCount.putIfAbsent(elem, 0);
                elementCount.put(elem, elementCount.get(elem) + 1);

                if (elementCount.get(elem) > maxElemCnt) {
                    maxElemCnt = elementCount.get(elem);
                    maxElem = elem;
                }
            }
            return (maxElemCnt > Math.floorDiv(inputArray.length, 2)) ? maxElem : 0;
        }
        return 0;
    }
}
