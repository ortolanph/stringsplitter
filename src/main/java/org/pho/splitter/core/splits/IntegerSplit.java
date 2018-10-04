package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

/**
 * Converts a String split into an <strong>Integer</strong>.
 *
 * @author Paulo Henrique Ortolan
 */
public class IntegerSplit extends AbstractSplitter<Integer> {

    private IntegerSplit(int start, int end, String... specialCharacters) {
        super(start, end, specialCharacters);
    }

    /**
     * Adds a String conversion into an Integer.
     *
     * @param start start where the split starts
     * @param end end end where the split ends
     * @param specialCharacters special characters to be removed
     * @return an instance of IntegerSplit
     */
    public static IntegerSplit newIntegerSplit(int start, int end, String... specialCharacters) {
        return new IntegerSplit(start, end, specialCharacters);
    }

    /**
     * Adds a String conversion into an Integer.
     *
     * @param start start where the split starts
     * @param specialCharacters special characters to be removed
     * @return an instance of IntegerSplit
     */
    public static IntegerSplit newIntegerSplit(int start, String... specialCharacters) {
        return new IntegerSplit(start, END_OF_LINE, specialCharacters);
    }

    /**
     * Splits the String source into an integer.
     *
     * @param source the String source
     * @return an Integer converted from a String
     * @throws SplitterException an Integer converted from a String
     */
    @Override public Integer split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        try {
            return Integer.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
