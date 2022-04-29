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

    private static final LinkedListIB.ListNode TEST_NODE_G = new LinkedListIB.ListNode(7);
    private static final LinkedListIB.ListNode TEST_NODE_F = new LinkedListIB.ListNode(6, TEST_NODE_G);
    private static final LinkedListIB.ListNode TEST_NODE_E = new LinkedListIB.ListNode(5, TEST_NODE_F);
    private static final LinkedListIB.ListNode TEST_NODE_D = new LinkedListIB.ListNode(4, TEST_NODE_E);
    private static final LinkedListIB.ListNode TEST_NODE_C = new LinkedListIB.ListNode(3, TEST_NODE_D);
    private static final LinkedListIB.ListNode TEST_NODE_B = new LinkedListIB.ListNode(2, TEST_NODE_C);
    private static final LinkedListIB.ListNode TEST_NODE_A = new LinkedListIB.ListNode(1, TEST_NODE_B);


    private static final LinkedListIB.ListNode TEST_NODE_X = new LinkedListIB.ListNode(1);

    private static final LinkedListIB.ListNode TEST_NODE_Z = new LinkedListIB.ListNode(2);
    private static final LinkedListIB.ListNode TEST_NODE_Y = new LinkedListIB.ListNode(1, TEST_NODE_Z);

    private static final int[] TEST_SWAP_1 = {1, 2, 3, 4, 5, 6};
    private static final int[] TEST_SWAP_1_S = {2, 1, 4, 3, 6, 5};
    private static final int[] TEST_SWAP_2 = {1, 2, 3, 4, 5, 6, 7};
    private static final int[] TEST_SWAP_2_S = {2, 1, 4, 3, 6, 5, 7};
    private static final int[] TEST_SWAP_3 = {1};


    private static final int[] TEST_ROTATE_0 = {1, 2, 3, 4, 5, 6, 7};
    private static final int[] TEST_ROTATE_1 = {2, 3, 4, 5, 6, 7, 1};
    private static final int[] TEST_ROTATE_2 = {3, 4, 5, 6, 7, 1, 2};
    private static final int[] TEST_ROTATE_3 = {4, 5, 6, 7, 1, 2, 3};
    private static final int[] TEST_ROTATE_4 = {5, 6, 7, 1, 2, 3, 4};
    private static final int[] TEST_ROTATE_5 = {6, 7, 1, 2, 3, 4, 5};
    private static final int[] TEST_ROTATE_6 = {7, 1, 2, 3, 4, 5, 6};

    private static final int[] TEST_REORDER_1 = {1, 6, 2, 5, 3, 4};
    private static final int[] TEST_REORDER_2 = {1, 7, 2, 6, 3, 5, 4};
    private static final int[] TEST_REORDER_3 = {1};
    private static final int[] TEST_REORDER_4 = {1, 2};



    @BeforeEach
    void init() {
        linkedListIb = new LinkedListIB();
    }

    @Test
    void swapListTest() {
        assertArrayEquals(TEST_SWAP_1_S, linkedListIb.swapList(TEST_NODE_1).getNodeArray(), "Test 1 - Even Reversed");
        assertArrayEquals(TEST_SWAP_1, linkedListIb.swapList(TEST_NODE_2).getNodeArray(), "Test 1 - Even Original");

        assertArrayEquals(TEST_SWAP_2_S, linkedListIb.swapList(TEST_NODE_A).getNodeArray(), "Test 2 - Odd Reversed");
        assertArrayEquals(TEST_SWAP_2, linkedListIb.swapList(TEST_NODE_B).getNodeArray(), "Test 2 - Odd Original");

        assertArrayEquals(TEST_SWAP_3, linkedListIb.swapList(TEST_NODE_X).getNodeArray(), "Test 3 - One Elem Reversed");
        assertArrayEquals(TEST_SWAP_3, linkedListIb.swapList(TEST_NODE_X).getNodeArray(), "Test 3 - One Elem Original");
    }

    @Test
    void rotateKTest() {
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_A, 0).getNodeArray(),
                "Test Rotate 0 K");

        assertArrayEquals(TEST_ROTATE_1, linkedListIb.rotateK(TEST_NODE_A, 1).getNodeArray(),
                "Test Rotate 1 K - Shift");
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_B, 6).getNodeArray(),
                "Test Rotate 1 K - Original");

        assertArrayEquals(TEST_ROTATE_2, linkedListIb.rotateK(TEST_NODE_A, 2).getNodeArray(),
                "Test Rotate 2 K - Shift");
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_C, 5).getNodeArray(),
                "Test Rotate 2 K - Original");

        assertArrayEquals(TEST_ROTATE_3, linkedListIb.rotateK(TEST_NODE_A, 3).getNodeArray(),
                "Test Rotate 3 K - Shift");
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_D, 4).getNodeArray(),
                "Test Rotate 3 K - Original");

        assertArrayEquals(TEST_ROTATE_4, linkedListIb.rotateK(TEST_NODE_A, 4).getNodeArray(),
                "Test Rotate 4 K - Shift");
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_E, 3).getNodeArray(),
                "Test Rotate 4 K - Original");

        assertArrayEquals(TEST_ROTATE_5, linkedListIb.rotateK(TEST_NODE_A, 5).getNodeArray(),
                "Test Rotate 5 K - Shift");
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_F, 2).getNodeArray(),
                "Test Rotate 5 K - Original");

        assertArrayEquals(TEST_ROTATE_6, linkedListIb.rotateK(TEST_NODE_A, 6).getNodeArray(),
                "Test Rotate 6 K - Shift");
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_G, 1).getNodeArray(),
                "Test Rotate 6 K - Original");

        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_A, 7).getNodeArray(),
                "Test Rotate 7 K - Shift");

        assertArrayEquals(TEST_ROTATE_1, linkedListIb.rotateK(TEST_NODE_A, 8).getNodeArray(),
                "Test Rotate 8 K - Shift");
        assertArrayEquals(TEST_ROTATE_0, linkedListIb.rotateK(TEST_NODE_B, 6).getNodeArray(),
                "Test Rotate 8 K - Original");
    }

    @Test
    void reorderListTest() {
        assertArrayEquals(TEST_REORDER_1, linkedListIb.reorderList(TEST_NODE_1).getNodeArray(),
                "Test Reorder List 1");
        assertArrayEquals(TEST_REORDER_2, linkedListIb.reorderList(TEST_NODE_A).getNodeArray(),
                "Test Reorder List 2");
        assertArrayEquals(TEST_REORDER_3, linkedListIb.reorderList(TEST_NODE_X).getNodeArray(),
                "Test Reorder List 3");
        assertArrayEquals(TEST_REORDER_4, linkedListIb.reorderList(TEST_NODE_Y).getNodeArray(),
                "Test Reorder List 4");
    }
}
