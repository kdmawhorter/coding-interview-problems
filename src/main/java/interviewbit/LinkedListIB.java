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

        @Getter @Setter
        private ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
        ListNode(int val, ListNode next) {
            this(val);
            setNext(next);
        }

        int getDownstreamCount() {
            int downstreamCount = 0;
            ListNode thisNode = this;
            while(thisNode != null) {
                downstreamCount++;
                thisNode = thisNode.getNext();
            }
            return downstreamCount;
        }

        int[] getNodeArray() {
            int downstreamCount = getDownstreamCount();
            ListNode thisNode = this;
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
        int downstreamCount = head.getDownstreamCount();
        ListNode newHead = (downstreamCount>1 ? head.getNext() : head);
        for (int i = 0; i < Math.floorDiv(downstreamCount, 2); i++) {
            ListNode tempNode =  head.getNext().getNext();
            head.getNext().setNext(head);
            head.setNext((i+1)*2+1<downstreamCount ? tempNode.getNext() : tempNode);
            head = tempNode;
        }
        return newHead;
    }
}
