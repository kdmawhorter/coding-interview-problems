package interviewbit_greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GasStationTest {

    GasStation gs;

    int[] MISMATCH_INT_INDS_R = {1, 2, 3};
    int[] MISMATCH_INT_INDS_C = {1, 2};

    int[] TEST_2_R = {1, 1, 1, 1, 1, 1, 1};
    int[] TEST_2_C = {1, 1, 1, 1, 1, 1, 1};

    int[] TEST_3_R = {1, 3, 1, 1, 1, 1, 1};
    int[] TEST_3_C = {3, 1, 1, 1, 1, 1, 1};

    int[] TEST_4_R = {1, 3, 3, 1, 1, 1, 1};
    int[] TEST_4_C = {3, 1, 1, 1, 1, 1, 1};

    int[] TEST_5_R = {1, 1, 1, 1, 1, 1, 1};
    int[] TEST_5_C = {100, 1, 1, 1, 1, 1, 1};

    int[] TEST_6_R = {1, 1, 1, 1, 1, 1, 100};
    int[] TEST_6_C = {2, 2, 2, 2, 2, 2, 2};

    @BeforeEach
    void init() {
        gs = new GasStation();
    }

    @Test
    @DisplayName("Testing minimumCycleIndex functionality.")
    public void minimumCycleIndexTest() {
        assertEquals(-1, gs.minimumCycleIndex(MISMATCH_INT_INDS_R, MISMATCH_INT_INDS_C),
                "Test 1: Mismatched Array Sizes");
        assertEquals(0, gs.minimumCycleIndex(TEST_2_R, TEST_2_C),"Test 2: Full Cycle");
        assertEquals(1, gs.minimumCycleIndex(TEST_3_R, TEST_3_C),"Test 3: First Index Only");
        assertEquals(1, gs.minimumCycleIndex(TEST_4_R, TEST_4_C),"Test 4: First Index Duplicate");
        assertEquals(-1, gs.minimumCycleIndex(TEST_5_R, TEST_5_C),"Test 5: No Path");
        assertEquals(6, gs.minimumCycleIndex(TEST_6_R, TEST_6_C),"Test 6: Last Index");
    }
}
