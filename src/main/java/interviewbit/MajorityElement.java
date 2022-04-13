package interviewbit;

import java.util.HashMap;

public class MajorityElement {

    /**
     * Given an input array, returns the majority element (meaning more than half), else 0 if it doesn't exist.
     *
     * @param inputArray - an int array
     * @return the majority element
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
