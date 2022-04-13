package interviewbit_greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MajorityElementTest {
    
    MajorityElement me;
    
    static int[] TEST_1_EMPTY= {};
    static int[] TEST_2_SINGLE_ELEMENT= {1};
    static int[] TEST_3_SIMPLE_MAJORITY= {1, 1, 1, 1, 2, 2, 2};
    static int[] TEST_4_DISPERSED_MAJORITY= {1, 2, 1, 3, 4, 1, 5, 1, 1, 6};
    static int[] TEST_5_NO_MAJORITY= {1, 2, 1, 3, 4, 1, 5, 1, 6};
        
    @BeforeEach
    void init() {
        me = new MajorityElement();
    }
    
    @Test
    void findMajorityElementTest() {
        assertEquals(0, me.findMajorityElement(TEST_1_EMPTY), "Test 1: Empty Array");
        assertEquals(1, me.findMajorityElement(TEST_2_SINGLE_ELEMENT), "Test 2: Single Element");
        assertEquals(1, me.findMajorityElement(TEST_3_SIMPLE_MAJORITY), "Test 3: Simple Majority");
        assertEquals(1, me.findMajorityElement(TEST_4_DISPERSED_MAJORITY),
                "Test 4: Dispersed/Even Majority");
        assertEquals(0, me.findMajorityElement(TEST_5_NO_MAJORITY), "Test 5: No Majority");
    }
}
