package interviewbit_greedy;

public class EditDistance {

    /**
     * Computes the <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein Distance</a> for two
     * input strings using a <a href="https://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm">Wagner
     * Fischer Matrix</a> implementation.
     *
     * @param a - The first string to compare
     * @param b - The second string to compare
     * @return The Levenshtein distance of the strings
     */
    public int editDistance(String a, String b) {
        int[][] fischerWagnerMatrix = new int[a.length()+1][b.length()+1];

        for (int aIdx=0; aIdx<=a.length(); aIdx++) { fischerWagnerMatrix[aIdx][0] = aIdx; }
        for (int bIdx=0; bIdx<=b.length(); bIdx++) { fischerWagnerMatrix[0][bIdx] = bIdx; }

        for (int bScan=0; bScan<b.length(); bScan++) {
            for (int aScan=0; aScan<a.length(); aScan++) {
                if (a.charAt(aScan) == b.charAt(bScan)) {
                    fischerWagnerMatrix[aScan+1][bScan+1] = fischerWagnerMatrix[aScan][bScan];
                } else {
                    fischerWagnerMatrix[aScan+1][bScan+1] = 1 + Math.min(Math.min(fischerWagnerMatrix[aScan][bScan],
                            fischerWagnerMatrix[aScan+1][bScan]), fischerWagnerMatrix[aScan][bScan+1]);
                }

            }
        }

        return fischerWagnerMatrix[a.length()][b.length()];
    }
}
