package interviewbit_greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubarrayQuestionsTest {
    
    private SubarrayQuestions subarrayQuestions;

    private final int[] LONG_SEQ_TEST_1_BASE = {1, 1, 3, 2, 6, 7, 1};
    private final int[] LONG_SEQ_TEST_2_EMPTY = {};
    private final int[] LONG_SEQ_TEST_3_ONE_ELM = {1};
    private final int[] LONG_SEQ_TEST_4_INTERLEAVE = {1, 1, 13, 2, 4, 5, 16, 18, 11};
    private final int[] LONG_SEQ_TEST_5_NEGATIVE = {3, 6, 1, 4, -2, 8};
    private final int[] LONG_SEQ_TEST_6_DBL_NEG = {3, 6, 1, 4, -2, 8, -4};
    private final int[] LONG_SEQ_TEST_7_ZERO = {0, 3, 6, -1, 4, 0, 8, -4};
    private final int[] LONG_SEQ_TEST_8_NOT_FIRST_INDEX = {100, 3, 6, -1, 4, 0, 8, -4};


    @BeforeEach
    void init() {
        subarrayQuestions = new SubarrayQuestions();
    }
    
    @Test
    void longestSubsequenceDeterminationTest() {
        assertEquals(5, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_1_BASE),
                "Test 1 - Base");
        assertEquals(0, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_2_EMPTY),
                "Test 2 - Empty");
        assertEquals(1, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_3_ONE_ELM),
                "Test 3 - One Element");
        assertEquals(7, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_4_INTERLEAVE),
                "Test 4 - Interleaved");
        assertEquals(3, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_5_NEGATIVE),
                "Test 5 - Negative");
        assertEquals(3, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_6_DBL_NEG),
                "Test 6 - Double Negative");
        assertEquals(4, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_7_ZERO),
                "Test 7 - Zeroes");
        assertEquals(3, subarrayQuestions.longestSubsequenceDetermination(LONG_SEQ_TEST_8_NOT_FIRST_INDEX), 
                "Test 8 - Not First Index");
    }
    
    @Test
    void findMaxProductTest() {
        assertEquals(252, subarrayQuestions.findMaxProduct(LONG_SEQ_TEST_1_BASE),
                "Test 1 - Base");
        assertEquals(0, subarrayQuestions.findMaxProduct(LONG_SEQ_TEST_2_EMPTY), 
                "Test 2 - Empty");
        assertEquals(1, subarrayQuestions.findMaxProduct(LONG_SEQ_TEST_3_ONE_ELM), 
                "Test 3 - One Element");
        assertEquals(1_647_360, subarrayQuestions.findMaxProduct(LONG_SEQ_TEST_4_INTERLEAVE), 
                "Test 4 - Interleaved");
        assertEquals(72, subarrayQuestions.findMaxProduct(LONG_SEQ_TEST_5_NEGATIVE), 
                "Test 5 - Negative");
        assertEquals(4608, subarrayQuestions.findMaxProduct(LONG_SEQ_TEST_6_DBL_NEG), 
                "Test 6 - Double Negative");
        assertEquals(18, subarrayQuestions.findMaxProduct(LONG_SEQ_TEST_7_ZERO), 
                "Test 7 - Zeros");
    }
}
