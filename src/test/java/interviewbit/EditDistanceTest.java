package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EditDistanceTest {

    EditDistance ed;

    @BeforeEach
    void init() {
        ed = new EditDistance();
    }

    @Test
    void editDistanceTest() {
        assertEquals(1, ed.editDistance("abad", "abac"), "Test 1");
        assertEquals(2, ed.editDistance("Anshuman", "Antihuman"), "Test 2");
        assertEquals(3, ed.editDistance("Saturday", "Sunday"), "Test 3");
    }

}

