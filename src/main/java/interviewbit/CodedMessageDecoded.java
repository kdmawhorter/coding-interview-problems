package interviewbit;

import org.jetbrains.annotations.NotNull;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems
 * <a href="https://www.interviewbit.com/problems/ways-to-decode/">Ways to Decode</a>.
 */
public class CodedMessageDecoded {

    /**
     * Given an input string representing a coded message where all letters are encoded as digits (i.e. A=1, B=2, ...
     * Z=26), returns the total number of possible messages the string could represent.
     *
     * @param message A string representing a digit encoded message
     * @return The number of possible ways to decode codedMessage.
     */
    public int waysToDecode(String message) {

        if (message!=null && message.length()>1) {
            int[] waysDecode = new int[message.length()+1];

            waysDecode[waysDecode.length-1] = 1;

            for (int i = message.length() - 1; i >= 0; i--) {
                if (canDecode(message, i,i+1) && canDecode(message, i, i+2)) {
                    waysDecode[i] = waysDecode[i+1] + waysDecode[i+2];
                }
                else if (canDecode(message, i, i+1)) {
                    waysDecode[i] = waysDecode[i+1];
                }
                else if (canDecode(message, i, i+2)) {
                    waysDecode[i] = waysDecode[i+2];
                } else if (!canDecode(message, i-1, i+1)) {
                    return 0;
                }
            }
            return waysDecode[0];
        } else if(message!=null && message.length()==1) {
            return canDecode(message, 0, 1) ? 1 : 0;
        }
        return 0;
    }

    /**
     * Determines whether a requested slice of an input string is a valid code, from the coding paradigm specified
     * with {@link #waysToDecode(String)}. Namely, if the substring is a single element within the
     * inputString then it must not be zero. Else if the substring is a two element string within input string, it must
     * not begin with a 0 and must be 'less' than "27". Anything else is a fail.
     *
     * @param input The string to be sliced.
     * @param startIdx The start index of the slice.
     * @param endIdx The end index of the slice.
     * @return A boolean representing whether the slice would yield a valid code.
     */
    private boolean canDecode(@NotNull String input, int startIdx, int endIdx) {
        try {
            return (startIdx>=0 && endIdx<= input.length() &&
                    input.charAt(startIdx) != '0' &&
                    (endIdx-startIdx==1 || (endIdx-startIdx==2 && Integer.parseInt(input.substring(startIdx, endIdx))<27)));
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
