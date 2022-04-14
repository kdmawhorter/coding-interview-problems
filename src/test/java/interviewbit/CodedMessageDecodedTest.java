package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodedMessageDecodedTest {

    private CodedMessageDecoded codedMessageDecoded;

    private static final String DECODE_TEST_0 = null;
    private static final String DECODE_TEST_1 = "117";
    private static final String DECODE_TEST_2 = "8117";
    private static final String DECODE_TEST_3 = "18117";
    private static final String DECODE_TEST_4 = "118117";
    private static final String DECODE_TEST_5_ZERO = "0";
    private static final String DECODE_TEST_6_EMPTY = "";
    private static final String DECODE_TEST_7_SINGLE = "8";
    private static final String DECODE_TEST_8_IMPOSSIBLE = "1100117";
    private static final String DECODE_TEST_9_ENDS_IN_VALID_ZERO = "11011710";

    @BeforeEach
    void init() {
        codedMessageDecoded = new CodedMessageDecoded();
    }

    @Test
    void waysToDecodeTest() {
        assertEquals(0, codedMessageDecoded.waysToDecode(DECODE_TEST_0), 
                "Test 0 - Null Check");
        assertEquals(3, codedMessageDecoded.waysToDecode(DECODE_TEST_1),
                "Test 1 - 117");
        assertEquals(3, codedMessageDecoded.waysToDecode(DECODE_TEST_2),
                "Test 2 - 8117");
        assertEquals(6, codedMessageDecoded.waysToDecode(DECODE_TEST_3),
                "Test 3 - 18117");
        assertEquals(9, codedMessageDecoded.waysToDecode(DECODE_TEST_4),
                "Test 4 - 118117");
        assertEquals(0, codedMessageDecoded.waysToDecode(DECODE_TEST_5_ZERO),
                "Test 5 - Zero");
        assertEquals(0, codedMessageDecoded.waysToDecode(DECODE_TEST_6_EMPTY),
                "Test 6 - Empty");
        assertEquals(1, codedMessageDecoded.waysToDecode(DECODE_TEST_7_SINGLE),
                "Test 7 - Single");
        assertEquals(0, codedMessageDecoded.waysToDecode(DECODE_TEST_8_IMPOSSIBLE),
                "Test 8 - Impossible Decoding");
        assertEquals(3, codedMessageDecoded.waysToDecode(DECODE_TEST_9_ENDS_IN_VALID_ZERO),
                "Test 9 - Ends in Valid Zero");
    }
}
