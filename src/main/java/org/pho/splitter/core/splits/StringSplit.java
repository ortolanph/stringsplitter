package org.pho.splitter.core.splits;

/**
 * Converts a String split into a <strong>String</strong>.
 *
 * @author Paulo Henrique Ortolan
 */
public class StringSplit extends AbstractSplitter<String> {

    private WordCase wordCase;

    private boolean trimmed;

    private StringSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        super(start, end);
        this.wordCase = wordCase;
        this.trimmed = trimmed;
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @param end where the split ends
     * @param wordCase the WordCase
     * @param trimmed trim or not trim the final String
     * @return an instance of StringSplit
     * @see WordCase
     */
    public static StringSplit newSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        return new StringSplit(start, end, wordCase, trimmed);
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @param end where the split ends
     * @param wordCase the WordCase
     * @return an instance of StringSplit
     */
    public static StringSplit newSplit(int start, int end, WordCase wordCase) {
        return new StringSplit(start, end, wordCase, false);
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @param end where the split ends
     * @param trimmed trim or not trim the final String
     * @return an instance of StringSplit
     */
    public static StringSplit newSplit(int start, int end, boolean trimmed) {
        return new StringSplit(start, end, WordCase.NO_CASE, trimmed);
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @param end where the split ends
     * @return an instance of StringSplit
     */
    public static StringSplit newSplit(int start, int end) {
        return new StringSplit(start, end, WordCase.NO_CASE, false);
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @param wordCase the WordCase
     * @param trimmed trim or not trim the final String
     * @return an instance of StringSplit
     * @see WordCase
     */
    public static StringSplit newSplit(int start, WordCase wordCase, boolean trimmed) {
        return new StringSplit(start, END_OF_LINE, wordCase, trimmed);
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @param wordCase the WordCase
     * @return an instance of StringSplit
     * @see WordCase
     */
    public static StringSplit newSplit(int start, WordCase wordCase) {
        return new StringSplit(start, END_OF_LINE, wordCase, false);
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @param trimmed trim or not trim the final String
     * @return an instance of StringSplit
     */
    public static StringSplit newSplit(int start, boolean trimmed) {
        return new StringSplit(start, END_OF_LINE, WordCase.NO_CASE, trimmed);
    }

    /**
     * Adds a String conversion into a String.
     *
     * @param start where the split starts
     * @return an instance of StringSplit
     */
    public static StringSplit newSplit(int start) {
        return new StringSplit(start, END_OF_LINE, WordCase.NO_CASE, false);
    }

    /**
     * Splits the string String source into a String.
     *
     * @param source the String source
     * @return a String extracted from the source String
     */
    @Override public String split(String source) {
        String result = (hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart());
        result = (trimmed) ? result.trim() : result;
        return wordCase.apply(result);
    }
}
