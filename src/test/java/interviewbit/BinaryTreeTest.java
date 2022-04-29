package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private final static Integer[][] TEST_CASE_1_INTERNET_I = {{0, 1, 1, 2}, {1, 2, null, null}, {2, 3, null, null}};
    private final static Integer[][] TEST_CASE_2_INTERNET_II = {{0, -10, 1, 2}, {1, -20, null, null}, {2, -30, null, null}};
    private final static Integer[][] TEST_CASE_3_FULL_TREE = {{0, -30, 1, 2}, {1, 60, 3, 4}, {2, 20, 5, 6}, {3, 50, 7, 8} ,
            {4, 20, 9, 10}, {5, 8, null, null}, {6, 16, 11, 12}, {7, -6, null, null}, {8, 8, null, null},
            {9, 6, null, null}, {10, 2, null, null}, {11, 1, null, null}, {12, -3, null, null}};
    private final static Integer[][] TEST_CASE_4_SINGLE_NODE = {{0, 8, null, null}};

    private BinaryTree binaryTree;

    @BeforeEach
    void init() {
        binaryTree = new BinaryTree();
    }

    @Test
    void maxSumPathTest() {
        assertEquals(6, binaryTree.maxSumPath(TEST_CASE_1_INTERNET_I),"Test Case 1 - Internet I");
        assertEquals(-10, binaryTree.maxSumPath(TEST_CASE_2_INTERNET_II),"Test Case 2 - Internet II");
        assertEquals(144, binaryTree.maxSumPath(TEST_CASE_3_FULL_TREE),"Test Case 3 - Full");
        assertEquals(8, binaryTree.maxSumPath(TEST_CASE_4_SINGLE_NODE),"Test Case 4 - Single Node");
    }

    @Test
    void uniqueBSTsTest() {
        assertEquals(1, binaryTree.uniqueBSTs(1),"Test Case - 1");
        assertEquals(2, binaryTree.uniqueBSTs(2),"Test Case - 2");
        assertEquals(5, binaryTree.uniqueBSTs(3),"Test Case - 3");
        assertEquals(42, binaryTree.uniqueBSTs( 5),"Test Case - 4");
    }
}
