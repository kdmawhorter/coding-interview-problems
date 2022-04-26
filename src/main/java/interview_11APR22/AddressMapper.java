package interview_11APR22;

import java.util.HashMap;

/**
 * Problem #3 from Interview on 11APR22. A class designed to answer whether a start can be connected with an end.
 * AddressMapper can be fed lines by calling {@link #addAddress(String)} with a "SRC-DEST" string. After all addresses
 * have been added, {@link #hasValidStartEndPath()} can be called to return whether there is a valid connection from
 * the {@link #STARTING_NODE_ADDRESS start address} to the {@link #ENDING_NODE_ADDRESS end address}.
 */
public class AddressMapper {

    /**
     * The String representation of the starting address.
     */
    private static final String STARTING_NODE_ADDRESS = "START";

    /**
     * The String representation of the ending address.
     */
    private static final String ENDING_NODE_ADDRESS = "END";

    private final HashMap<String, String> addressMap;

    public AddressMapper() {
        addressMap = new HashMap<>();
    }

    /**
     * Parses a string representing an input line. If the string is properly formatted, meaning it contains a string
     * which can be split into two strings based on the '-' character, then the String array of those two strings is
     * returned, else null is returned.
     *
     * @param inputLine - A string representing an address mapping
     *
     * @return A string array with the address and mapping, or null as above
     */
    public String[] parseLine(String inputLine) {
        String[] returnStringArray = inputLine.split("-");

        return (returnStringArray.length==2) ? returnStringArray : null;
    }

    /**
     * Adds an input address to the mapped address data structure if the input address is not already mapped.
     *
     * @param inputLine - A string representing the input address mapping, in format SRC-DEST
     */
    public void addAddress(String inputLine) {
        addAddress(parseLine(inputLine));
    }

    private void addAddress(String[] parsedAddress) {
        if (parsedAddress!= null) {
            addressMap.putIfAbsent(parsedAddress[0], parsedAddress[1]);
        }
    }

    /**
     * Maps the input address if it is present in the address mapping.
     *
     * @param address - A string representing the address to be mapped
     *
     * @return A string representing the mapping of that address or null if it is not mapped
     */
    public String getMapping(String address) {
        return addressMap.get(address);
    }

    /**
     * Returns whether a valid connecting path exists between the starting and ending address of the address mapping.
     *
     * @return a boolean representing if a valid path exists
     */
    public boolean hasValidStartEndPath() {
        HashMap<String, Boolean> visitedNodes = new HashMap<>();

        String currentNode = getMapping(STARTING_NODE_ADDRESS);

        while (currentNode != null && !visitedNodes.containsKey(currentNode)) {
            if (currentNode.equals(ENDING_NODE_ADDRESS)) { return true; }

            visitedNodes.put(currentNode, true);
            currentNode = addressMap.get(currentNode);
        }
        return false;
    }

    /**
     * Clears all address mappings from this object.
     */
    public void resetMapping() {
        addressMap.clear();
    }

}
