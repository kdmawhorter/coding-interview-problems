package interview_11APR22;

public class VowelRemover {
    public String removeVowels(String inputString) {
        return inputString.replaceAll("[aeiouAEIOU]", "");
    }
}
