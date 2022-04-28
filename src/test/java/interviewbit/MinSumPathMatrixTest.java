package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinSumPathMatrixTest {

    private static final int[][] TEST_1_ONE_ELEM = {{1}};
    private static final int[][] TEST_2_ALL_SAME = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
    private static final int[][] TEST_3_FULL_TEST = {{1, 1, 2, 2}, {2, 1, 2, 2}, {2, 1, 1, 1}, {2, 2, 2, 1}};
    private static final int[][] TEST_4_INTERNET_TEST = {{1, 3, 2}, {4, 3, 1}, {5, 6, 1}};

    private MinSumPathMatrix minSumPathMatrix;

    @BeforeEach
    void init() {
        minSumPathMatrix = new MinSumPathMatrix();
    }

    @Test
    void minSumPathInMatrixTest() {
        assertEquals(1, minSumPathMatrix.minSumPathInMatrix(TEST_1_ONE_ELEM),"Test 1: One Element");
        assertEquals(7, minSumPathMatrix.minSumPathInMatrix(TEST_2_ALL_SAME),"Test 2: All Same");
        assertEquals(7, minSumPathMatrix.minSumPathInMatrix(TEST_3_FULL_TEST),"Test 3: Full Test");
        assertEquals(8, minSumPathMatrix.minSumPathInMatrix(TEST_4_INTERNET_TEST),"Test 4: Internet Test");
    }
}
