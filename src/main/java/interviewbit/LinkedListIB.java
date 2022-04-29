package interviewbit;

import lombok.Getter;
import lombok.Setter;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems on LinkedLists.
 */
public class LinkedListIB {

    public static class ListNode {
        @Getter @Setter
        private int val;

        @Getter
        private ListNode next;

        @Getter @Setter
        private int downstreamCount;

        ListNode(int val) {
            this.val = val;
            next = null;
            downstreamCount = 0;
        }
        ListNode(int val, ListNode next) {
            this(val);
            setNext(next);
        }

        public void setNext(ListNode next) {
            if (this.next!=null) {
                downstreamCount -= (1 + next.getDownstreamCount());
            }

            this.next = next;

            if (this.next!=null) {
                downstreamCount += (1 + next.getDownstreamCount());
            }
        }

        int[] getNodeArray() {
            int downstreamCount = 0;
            ListNode thisNode = this;
            while(thisNode != null) {
                downstreamCount++;
                thisNode = thisNode.getNext();
            }
            thisNode = this;
            int[] returnArray = new int[downstreamCount];
            for (int i = 0; i < downstreamCount; i++) {
                returnArray[i] = thisNode.getVal();
                thisNode = thisNode.getNext();
            }
            return returnArray;
        }

    }

    /**
     * Swaps adjacent node pairs in a list, returning the head of the new list. Answers problem
     * <a href="https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/">Swap List Nodes</a>.
     * @param head The head of the list to swap.
     * @return The new head of the swapped list.
     */
    public ListNode swapList(ListNode head) {
        return head;
    }
}
