package org.pho.splitter.core.splits;

/**
 *
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
     *
     * @param start
     * @param end
     * @param wordCase
     * @param trimmed
     * @return
     */
    public static StringSplit newSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        return new StringSplit(start, end, wordCase, trimmed);
    }

    /**
     *
     * @param start
     * @param end
     * @param wordCase
     * @return
     */
    public static StringSplit newSplit(int start, int end, WordCase wordCase) {
        return new StringSplit(start, end, wordCase, false);
    }

    /**
     *
     * @param start
     * @param end
     * @param trimmed
     * @return
     */
    public static StringSplit newSplit(int start, int end, boolean trimmed) {
        return new StringSplit(start, end, WordCase.NO_CASE, trimmed);
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public static StringSplit newSplit(int start, int end) {
        return new StringSplit(start, end, WordCase.NO_CASE, false);
    }

    /**
     *
     * @param start
     * @param wordCase
     * @param trimmed
     * @return
     */
    public static StringSplit newSplit(int start, WordCase wordCase, boolean trimmed) {
        return new StringSplit(start, END_OF_LINE, wordCase, trimmed);
    }

    /**
     *
     * @param start
     * @param wordCase
     * @return
     */
    public static StringSplit newSplit(int start, WordCase wordCase) {
        return new StringSplit(start, END_OF_LINE, wordCase, false);
    }

    /**
     *
     * @param start
     * @param trimmed
     * @return
     */
    public static StringSplit newSplit(int start, boolean trimmed) {
        return new StringSplit(start, END_OF_LINE, WordCase.NO_CASE, trimmed);
    }

    /**
     *
     * @param start
     * @return
     */
    public static StringSplit newSplit(int start) {
        return new StringSplit(start, END_OF_LINE, WordCase.NO_CASE, false);
    }

    /**
     *
     * @param source
     * @return
     */
    @Override public String split(String source) {
        String result = (hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart());
        result = (trimmed) ? result.trim() : result;
        return wordCase.apply(result);
    }
}
