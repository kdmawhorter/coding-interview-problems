package interview_11APR22;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitIndexComparisonsTest {

    BitIndexComparisons bic;

    static int[] NEG_ONE_PARSE_TEST = {-1, 1, 32};
    static int[] POS_ONE_PARSE_TEST = {1, 1, 32};
    static int[] ZERO_PARSE_TEST = {0, 0, 0};

    @BeforeEach
    void initialize() {
        bic = new BitIndexComparisons();
    }

    @Test
    @DisplayName("Testing parseBitPositionsLine")
    void parseBitPositionsLine() {
        assertArrayEquals(NEG_ONE_PARSE_TEST, bic.parseBitPositionsLine("-1,1,32"),
                "Test 1 - Negative One Parse Test");
        assertArrayEquals(POS_ONE_PARSE_TEST, bic.parseBitPositionsLine("1,1,32"),
                "Test 2 - Positive One Parse Test");
        assertArrayEquals(ZERO_PARSE_TEST, bic.parseBitPositionsLine("1,32"),
                "Test 3 - Too Few Parse Test");
        assertArrayEquals(ZERO_PARSE_TEST, bic.parseBitPositionsLine("1,1,32,32"),
                "Test 4 - Too Many Parse Test");
    }

    @Test
    @DisplayName("Testing getBitOneIndexed functionality")
    void getBitOneIndexed() {
        // 0, 1, 32, and 33 bits of -1 (0x0000)
        assertEquals(0, bic.getBitOneIndexed(0, 0), "Test 1 - 0th Index of 0");
        assertEquals(0, bic.getBitOneIndexed(0, 1), "Test 2 - 1st Index of 0");
        assertEquals(0, bic.getBitOneIndexed(0, 32), "Test 3 - 32nd Index of 0");
        assertEquals(0, bic.getBitOneIndexed(0, 33), "Test 4 - 33rd Index of 0");

        // 0, 1, 32, and 33 bits of -1 (0xFFFF)
        assertEquals(0, bic.getBitOneIndexed(-1, 0), "Test 5 - 0th Index of 1");
        assertEquals(1, bic.getBitOneIndexed(-1, 1), "Test 6 - 1st Index of 1");
        assertEquals(1, bic.getBitOneIndexed(-1, 32), "Test 7 - 32nd Index of 1");
        assertEquals(0, bic.getBitOneIndexed(-1, 33), "Test 8 - 33rd Index of 1");
    }

    @Test
    @DisplayName("Testing ")
    void compareBitPositions() {
        assertTrue(bic.compareBitPositions("-1,1,32"), "Test 1 - 1th and 32th of 0xFFFF");
        assertFalse(bic.compareBitPositions("1,1,32"), "Test 2 - 1th and 32th of 0X0001");
        assertTrue(bic.compareBitPositions("17,1,5"), "Test 3 - 1th and 5th of 0x0011");
        assertFalse(bic.compareBitPositions("17,1,4"), "Test 4 - 1th and 4th of 0x0011");
    }

}
