package interviewbit_greedy;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MajorityElement {

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
            return (maxElemCnt >= Math.floorDiv(inputArray.length+1, 2)) ? maxElem : 0;
        }
        return 0;
    }
}
