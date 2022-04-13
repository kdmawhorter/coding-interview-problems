package interview_11APR22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VowelRemoverTest {

    VowelRemover vr;

    @BeforeEach
    void initializer() { vr = new VowelRemover(); }

    @Test
    @DisplayName("Testing removeVowels functionality.")
    void removeVowelsTest() {
        String test = "TestConfigurationPush";
        assertEquals("ct", vr.removeVowels("cat"), "Test 1: Cat");
        assertEquals("bcdfghjklmnpqrstvwxyz", vr.removeVowels("abcdefghjklmnpqrstvwxyz"),
                "Test 2: Lower Case Alphabet");
        assertEquals("BCDFGHJKLMNPQRSTVWXYZ", vr.removeVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
                "Test 3: Upper Case Alphabet");
        assertEquals("", vr.removeVowels(""), "Test 3: Empty String");
        assertEquals("", vr.removeVowels("aeiou"), "Test 4: All Vowels");
    }


}
