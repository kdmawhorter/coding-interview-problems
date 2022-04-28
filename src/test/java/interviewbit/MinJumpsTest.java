package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinJumpsTest {

    private static final int[] TEST_0_NULL = null;
    private static final int[] TEST_1_EMPTY = {};
    private static final int[] TEST_2_ONE_ELEM = {10};
    private static final int[] TEST_3_INTERNET_I = {2, 1, 1};
    private static final int[] TEST_4_INTERNET_II = {2, 3, 1, 1, 4};
    private static final int[] TEST_5_ONE_JUMP = {10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static final int[] TEST_6_ALL_ONES = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static final int[] TEST_7_FULL_TEST = {3, 1, 6, 1, 1, 1, 1, 1, 2, 1, 1};
    private static final int[] TEST_8_NO_PATH = {0, 1, 6, 1, 1, 1, 1, 1, 2, 1, 1};
    private static final int[] TEST_9_MISSING_STEPS = {3, 1, 6, 1, 0, 0, 1, 1, 2, 1, 1};

    private MinJumps minJumps;

    @BeforeEach
    void init() {
        minJumps = new MinJumps();
    }

    @Test
    void minJumpsArrayTest() {
        assertEquals(0, minJumps.minJumpsArray(TEST_0_NULL),"Test 0: Null");
        assertEquals(0, minJumps.minJumpsArray(TEST_1_EMPTY),"Test 1: Empty");
        assertEquals(0, minJumps.minJumpsArray(TEST_2_ONE_ELEM),"Test 2: One Elem");
        assertEquals(1, minJumps.minJumpsArray(TEST_3_INTERNET_I),"Test 3: Internet I");
        assertEquals(2, minJumps.minJumpsArray(TEST_4_INTERNET_II),"Test 4: Internet II");
        assertEquals(1, minJumps.minJumpsArray(TEST_5_ONE_JUMP),"Test 5: One Jump");
        assertEquals(10, minJumps.minJumpsArray(TEST_6_ALL_ONES),"Test 6: All Ones");
        assertEquals(3, minJumps.minJumpsArray(TEST_7_FULL_TEST),"Test 7: Full");
        assertEquals(-1, minJumps.minJumpsArray(TEST_8_NO_PATH),"Test 8: No Path");
        assertEquals(3, minJumps.minJumpsArray(TEST_9_MISSING_STEPS),"Test 9: Missing Steps");

    }
}
