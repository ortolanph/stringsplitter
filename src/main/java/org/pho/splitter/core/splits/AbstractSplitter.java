package org.pho.splitter.core.splits;

import org.pho.splitter.core.function.SplitFunction;

/**
 *
 * @param <T>
 */
public abstract class AbstractSplitter<T> implements SplitFunction<T> {

    protected static final int END_OF_LINE = 0;

    private static final String NOTHING = "";

    private String[] specialCharacters;

    private int start;

    private int end;

    /**
     *
     * @param start
     * @param end
     * @param specialCharacters
     */
    public AbstractSplitter(int start, int end, String... specialCharacters) {
        this.start = start;
        this.end = end;
        this.specialCharacters = specialCharacters;
    }

    /**
     *
     * @return
     */
    public int getStart() {
        return start;
    }

    /**
     *
     * @return
     */
    public int getEnd() {
        return end;
    }

    /**
     *
     * @return
     */
    protected boolean hasEnd() {
        return end != END_OF_LINE;
    }

    /**
     *
     * @param source
     * @return
     */
    public String removeSpecialCharacters(String source) {
        String result = source;

        if(specialCharacters != null) {
            for (String specialCharacter : specialCharacters) {
                result = result.replaceAll(specialCharacter, NOTHING);
            }
        }

        return result;
    }
}
