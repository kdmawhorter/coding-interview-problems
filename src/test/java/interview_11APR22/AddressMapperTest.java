package interview_11APR22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressMapperTest {

    AddressMapper am;

    static String[] START_END_PAIR = {"START", "END"};

    @BeforeEach
    void initialize() {
        am = new AddressMapper();
    }

    @Test
    @DisplayName("Testing parseLine functionality")
    void parseLineTest() {
        assertArrayEquals(START_END_PAIR, am.parseLine("START-END"), "Test 1: Proper Format");
        assertNull(am.parseLine("START-END-ANOTHER_END"), "Test 2: Too Many Inputs");
        assertNull(am.parseLine("START_END"), "Test 3: Too Few Inputs");
    }

    @Test
    @DisplayName("Testing addAddress functionality")
    void addAddressTest() {
        assertNull(am.getMapping("START"), "Test 1: Proper Initialization Mapping");

        am.addAddress("START");
        assertNull(am.getMapping("START"), "Test 2: Proper Invalid Mapping");

        am.addAddress("START-1");
        assertEquals("1", am.getMapping("START"), "Test 3: Proper Standard Mapping");

        am.addAddress("START-END");
        assertEquals("1", am.getMapping("START"), "Test 4: Proper Duplicate Mapping");
    }

    @Test
    @DisplayName("Testing hasValidStartEndPath functionality")
    void hasValidStartEndPath() {
        am.addAddress("START-END");
        assertTrue(am.hasValidStartEndPath(), "Test 1: One Step Valid Path");
        am.resetMapping();

        am.addAddress("1-END");
        assertFalse(am.hasValidStartEndPath(), "Test 2: No Start Node Invalid ");
        am.resetMapping();

        am.addAddress("START-1");
        am.addAddress("1-2");
        am.addAddress("2-3");
        am.addAddress("3-4");
        am.addAddress("4-END");
        assertTrue(am.hasValidStartEndPath(), "Test 3: Full Valid Path");
        am.resetMapping();

        am.addAddress("START-1");
        am.addAddress("1-2");
        am.addAddress("2-3");
        am.addAddress("4-END");
        assertFalse(am.hasValidStartEndPath(), "Test 4: Missing Step Invalid");
        am.resetMapping();

        am.addAddress("START-1");
        am.addAddress("1-2");
        am.addAddress("2-3");
        am.addAddress("3-1");
        am.addAddress("4-END");
        assertFalse(am.hasValidStartEndPath(), "Test 5: Loop Invalid");

        am.addAddress("START-1");
        am.addAddress("1-6");
        am.addAddress("2-3");
        am.addAddress("3-1");
        am.addAddress("4-END");
        assertFalse(am.hasValidStartEndPath(), "Test 6: Unknown Destination");
    }
}
