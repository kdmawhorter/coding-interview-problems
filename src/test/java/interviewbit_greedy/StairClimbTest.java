package interviewbit_greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StairClimbTest {
    StairClimb sc;

    @BeforeEach
    void init() {
        sc = new StairClimb();
    }

    @Test
    void waysToClimbStairsTest() {
        assertEquals(1, sc.waysToClimbStairs(1));
        assertEquals(2, sc.waysToClimbStairs(2));
        assertEquals(3, sc.waysToClimbStairs(3));
        assertEquals(5, sc.waysToClimbStairs(4));
        assertEquals(8, sc.waysToClimbStairs(5));

    }
}
