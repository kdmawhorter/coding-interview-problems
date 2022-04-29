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

    /**
     * Right circle shifts an input list in place. Answers problem
     * <a href="https://www.interviewbit.com/problems/rotate-list/">Right Circle Shift</a>.
     * @param head The head of the list to be shifted
     * @param k The amount to be right shifted.
     * @return The new head of the list.
     */
    public ListNode rotateK(ListNode head, int k) {
        k = k % head.getDownstreamCount();
        ListNode thisNode = head;
        ListNode newHead = head;
        if (k>0) {
            for (int i = 0; i < k - 1; i++) {
                thisNode = thisNode.getNext();
            }
            newHead = thisNode.getNext();
            ListNode endNode = thisNode.getNext();
            thisNode.setNext(null);
            while(endNode.getNext()!=null) {
                endNode = endNode.getNext();
            }
            endNode.setNext(head);
        }
        return newHead;
    }

    /**
     * Shuffles an n element list by taking each ith element making its next the n-i element, and taking that n-1-i
     * element and making its next the i+1 element. L0-L1-L2-...-L(n-3)-L(n-2)-L(n-1) produces
     * L0-L(n-1)-L1-L(n-2)-L2L(n-3)-...<br>
     * Answers the problem <a href="https://www.interviewbit.com/problems/reorder-list/">Reorder List</a>
     * @param head The head of the list to shuffle
     * @return The head of the shuffled list.
     */
    public ListNode reorderList(ListNode head) {
        ListNode thisNode = head;
        ListNode secondToEndNode, tempNode;
        while (thisNode.getNext()!=null && thisNode.getNext().getNext()!=null) {
            secondToEndNode = thisNode;
            while (secondToEndNode.getNext().getNext()!=null) { secondToEndNode = secondToEndNode.getNext(); }
            tempNode = thisNode.getNext();
            thisNode.setNext(secondToEndNode.getNext());
            secondToEndNode.getNext().setNext(tempNode);
            secondToEndNode.setNext(null);
            thisNode = tempNode;
        }
        return head;
    }
}
