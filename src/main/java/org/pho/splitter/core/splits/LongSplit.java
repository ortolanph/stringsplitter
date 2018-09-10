package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

/**
 *
 */
public class LongSplit extends AbstractSplitter<Long> {

    private String[] specialCharacters;

    private LongSplit(int start, int end, String... specialCharacters) {
        super(start, end, specialCharacters);
    }

    /**
     *
     * @param start
     * @param end
     * @param specialCharacters
     * @return
     */
    public static LongSplit newLongSplit(int start, int end, String... specialCharacters) {
        return new LongSplit(start, end, specialCharacters);
    }

    /**
     *
     * @param start
     * @param specialCharacters
     * @return
     */
    public static LongSplit newLongSplit(int start, String... specialCharacters) {
        return new LongSplit(start, END_OF_LINE, specialCharacters);
    }

    /**
     *
     * @param source
     * @return
     * @throws SplitterException
     */
    @Override public Long split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        try {
            return Long.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }

}
