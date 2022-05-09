package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridUniquePathsTest {

    private GridUniquePaths gridUniquePaths;

    @BeforeEach
    void init() {
        gridUniquePaths = new GridUniquePaths();
    }

    @Test
    void countUniquePathsTest() {
        assertEquals(1, gridUniquePaths.countUniquePaths(1, 1), "Test 1: 1x1");
        assertEquals(1, gridUniquePaths.countUniquePaths(1, 2), "Test 1: 1x2");
        assertEquals(1, gridUniquePaths.countUniquePaths(2, 1), "Test 3: 2x1");
        assertEquals(2, gridUniquePaths.countUniquePaths(2, 2), "Test 4: 2x2");
        assertEquals(6, gridUniquePaths.countUniquePaths(3, 3), "Test 5: 3x3");
        assertEquals(0, gridUniquePaths.countUniquePaths(0, 10), "Test 6: 0xN");
        assertEquals(0, gridUniquePaths.countUniquePaths(10, 0), "Test 7: Mx0");
    }
}
