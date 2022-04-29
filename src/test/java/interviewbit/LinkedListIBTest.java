package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListIBTest {

    private LinkedListIB linkedListIb;

    private static final LinkedListIB.ListNode TEST_NODE_6 = new LinkedListIB.ListNode(6);
    private static final LinkedListIB.ListNode TEST_NODE_5 = new LinkedListIB.ListNode(5, TEST_NODE_6);
    private static final LinkedListIB.ListNode TEST_NODE_4 = new LinkedListIB.ListNode(4, TEST_NODE_5);
    private static final LinkedListIB.ListNode TEST_NODE_3 = new LinkedListIB.ListNode(3, TEST_NODE_4);
    private static final LinkedListIB.ListNode TEST_NODE_2 = new LinkedListIB.ListNode(2, TEST_NODE_3);
    private static final LinkedListIB.ListNode TEST_NODE_1 = new LinkedListIB.ListNode(1, TEST_NODE_2);

    private static final int[] TEST_1 = {1, 2, 3, 4, 5, 6};
    private static final int[] TEST_1_S = {2, 1, 4, 3, 6, 5};

    private static final LinkedListIB.ListNode TEST_NODE_G = new LinkedListIB.ListNode(7);
    private static final LinkedListIB.ListNode TEST_NODE_F = new LinkedListIB.ListNode(6, TEST_NODE_G);
    private static final LinkedListIB.ListNode TEST_NODE_E = new LinkedListIB.ListNode(5, TEST_NODE_F);
    private static final LinkedListIB.ListNode TEST_NODE_D = new LinkedListIB.ListNode(4, TEST_NODE_E);
    private static final LinkedListIB.ListNode TEST_NODE_C = new LinkedListIB.ListNode(3, TEST_NODE_D);
    private static final LinkedListIB.ListNode TEST_NODE_B = new LinkedListIB.ListNode(2, TEST_NODE_C);
    private static final LinkedListIB.ListNode TEST_NODE_A = new LinkedListIB.ListNode(1, TEST_NODE_B);

    private static final int[] TEST_2 = {1, 2, 3, 4, 5, 6, 7};
    private static final int[] TEST_2_S = {2, 1, 4, 3, 6, 5, 7};

    private static final LinkedListIB.ListNode TEST_NODE_X = new LinkedListIB.ListNode(1);

    private static final int[] TEST_3 = {1};

    @BeforeEach
    void init() {
        linkedListIb = new LinkedListIB();
    }

    @Test
    void swapListTest() {
        assertArrayEquals(TEST_1_S, linkedListIb.swapList(TEST_NODE_1).getNodeArray(), "Test 1 - Even Reversed");
        assertArrayEquals(TEST_1, linkedListIb.swapList(TEST_NODE_2).getNodeArray(), "Test 1 - Even Original");

        assertArrayEquals(TEST_2_S, linkedListIb.swapList(TEST_NODE_A).getNodeArray(), "Test 2 - Odd Reversed");
        assertArrayEquals(TEST_2, linkedListIb.swapList(TEST_NODE_B).getNodeArray(), "Test 2 - Odd Original");

        assertArrayEquals(TEST_3, linkedListIb.swapList(TEST_NODE_X).getNodeArray(), "Test 3 - One Elem Reversed");
        assertArrayEquals(TEST_3, linkedListIb.swapList(TEST_NODE_X).getNodeArray(), "Test 3 - One Elem Original");
    }
}
