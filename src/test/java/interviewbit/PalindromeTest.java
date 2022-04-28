package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    private static final String TEST_1_EMPTY = "";
    private static final String TEST_2_ONE_CHAR = "a";
    private static final String TEST_3_INTERNET_I = "aba";
    private static final String TEST_4_INTERNET_II = "aab";
    private static final String TEST_5_FULL_TEST = "adbbdaabbaad";


    private Palindrome palindrome;

    @BeforeEach
    void init() {
        palindrome = new Palindrome();
    }

    @Test
    void minCutsPalindromePartitionTest() {
        assertEquals(0, palindrome.minCutsPalindromePartition(TEST_1_EMPTY),"Test 2: Empty");
        assertEquals(0, palindrome.minCutsPalindromePartition(TEST_2_ONE_CHAR),"Test 3: One Char");
        assertEquals(0, palindrome.minCutsPalindromePartition(TEST_3_INTERNET_I),"Test 4: Internet 1");
        assertEquals(1, palindrome.minCutsPalindromePartition(TEST_4_INTERNET_II),"Test 5: Internet 2");
        assertEquals(3, palindrome.minCutsPalindromePartition(TEST_5_FULL_TEST),"Test 6: Full");
    }
}
