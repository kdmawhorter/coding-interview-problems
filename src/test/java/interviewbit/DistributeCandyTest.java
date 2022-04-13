package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistributeCandyTest {

    DistributeCandy dc;

    private final int[] TEST_1 = {1, 1, 1, 1};
    private final int[] TEST_2 = {1};
    private final int[] TEST_3 = {1, 2};
    private final int[] TEST_4 = {2, 1};
    private final int[] TEST_5 = {1, 2, 1, 2, 1};
    private final int[] TEST_6 = {1, 2, 1, 1, 2, 1};
    private final int[] TEST_7 = {1, 2, 2, 1};
    private final int[] TEST_8 = {1, 5, 2, 1, 2, 5, 1};
    private final int[] TEST_9 = {3, 3, 2, 2, 1, 1, 2, 2, 4, 5, 4, 10};

    @BeforeEach
    void init() {
        dc = new DistributeCandy();
    }

    @Test
    void distributeCandyTest() {
        assertEquals(4, dc.determineNeededCandies(TEST_1), "Test 1");
        assertEquals(1, dc.determineNeededCandies(TEST_2), "Test 2");
        assertEquals(3, dc.determineNeededCandies(TEST_3), "Test 3");
        assertEquals(3, dc.determineNeededCandies(TEST_4), "Test 4");
        assertEquals(7, dc.determineNeededCandies(TEST_5), "Test 5");
        assertEquals(8, dc.determineNeededCandies(TEST_6), "Test 6");
        assertEquals(6, dc.determineNeededCandies(TEST_7), "Test 7");
        assertEquals(13, dc.determineNeededCandies(TEST_8), "Test 8");
        assertEquals(26, dc.determineNeededCandies(TEST_9), "Test 9");
    }

}
