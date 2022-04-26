package interview_11APR22;

/**
 * Problem #2 from Interview on 11APR22.<br>
 * <br>
 * A class designed to provide functionality to remove vowels from a string using {@link #removeVowels(String)}
 */
public class VowelRemover {

    /**
     * Returns a String with all uppercase and lowercase vowels removed (a, e, i, o, u).
     * @param inputString An input string.
     * @return The input string with all uppercase and lowercase vowels removed.
     */
    public String removeVowels(String inputString) {
        return inputString.replaceAll("[aeiouAEIOU]", "");
    }
}
