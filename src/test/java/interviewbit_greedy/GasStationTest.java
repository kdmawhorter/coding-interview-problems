package interviewbit_greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GasStationTest {

    GasStation gs;

    int[] MISMATCH_INT_INDS_R = {1, 2, 3};
    int[] MISMATCH_INT_INDS_C = {1, 2};

    int[] TEST_1_REPLENISH = {};
    int[] TEST_1_COST = {};

    @BeforeEach
    void init() {
        gs = new GasStation();
    }

    @Test
    @DisplayName("Testing minimumCycleIndex functionality.")
    public void minimumCycleIndexTest() {
        assertEquals(-1, gs.minimumCycleIndex(MISMATCH_INT_INDS_R, MISMATCH_INT_INDS_C),
                "Test 1: Mismatched Array Sizes");
    }
}
