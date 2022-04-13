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

    }
}
