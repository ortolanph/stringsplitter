package org.pho.splitter.core.splits.primitives;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

/**
 * Converts a String split into a <strong>Long</strong>.
 *
 * @author Paulo Henrique Ortolan
 */
public final class LongSplit extends AbstractSplitter<Long> {

    private String[] specialCharacters;

    private LongSplit(int start, int end, String... specialCharacters) {
        super(start, end, specialCharacters);
    }

    /**
     * Adds a String conversion into a Long.
     *
     * @param start             start where the split starts
     * @param end               end end where the split ends
     * @param specialCharacters special characters to be removed
     * @return an instance of LongSplit
     */
    public static LongSplit newLongSplit(int start, int end, String... specialCharacters) {
        return new LongSplit(start, end, specialCharacters);
    }

    /**
     * Adds a String conversion into a Long.
     *
     * @param start             start where the split starts
     * @param specialCharacters special characters to be removed
     * @return an instance of LongSplit
     */
    public static LongSplit newLongSplit(int start, String... specialCharacters) {
        return new LongSplit(start, END_OF_LINE, specialCharacters);
    }

    /**
     * Splits the String source into a long.
     *
     * @param source the String source
     * @return a Long converted from a String
     * @throws SplitterException when the conversion goes wrong
     */
    @Override
    public Long split(String source) throws SplitterException {
        String result = removeSpecialCharactersAndSplit(source);

        try {
            return Long.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }

}
