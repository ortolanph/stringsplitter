package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

/**
 * Converts a String split into a <strong>Byte</strong>.
 */
public class ByteSplit extends AbstractSplitter<Byte> {

    private ByteSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into a Byte.
     *
     * @param start where the split starts
     * @param end where the split ends
     * @return an instance of ByteSplit
     */
    public static ByteSplit newByteSplit(int start, int end) {
        return new ByteSplit(start, end);
    }

    /**
     * Adds a String conversion into a Byte.
     *
     * @param start where the split starts
     * @return an instance of ByteSplit
     */
    public static ByteSplit newByteSplit(int start) {
        return new ByteSplit(start, END_OF_LINE);
    }

    /**
     * Splits the String source into a byte.
     *
     * @param source the String source
     * @return a Byte converted from a String
     */
    @Override public Byte split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();

        try {
            return Byte.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
