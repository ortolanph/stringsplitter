package org.pho.splitter.core.splits;

import org.pho.splitter.core.function.SplitFunction;

/**
 * Abstract class to save basic information for specilized split.
 *
 * @param <T> The base type to be returned
 */
public abstract class AbstractSplitter<T> implements SplitFunction<T> {

    /**
     * Means to the end of the line.
     */
    protected static final int END_OF_LINE = 0;

    private static final String NOTHING = "";

    private String[] specialCharacters;

    private int start;

    private int end;

    /**
     * Creates a new AbstractSplitter.
     *
     * @param start where the split starts
     * @param end where the split ends
     * @param specialCharacters the special character to be removed
     */
    public AbstractSplitter(int start, int end, String... specialCharacters) {
        this.start = start;
        this.end = end;
        this.specialCharacters = specialCharacters;
    }

    /**
     * Returns the starting split point.
     *
     * @return the starting split point
     */
    public int getStart() {
        return start;
    }

    /**
     * Returns the ending split point.
     *
     * @return the ending split point
     */
    public int getEnd() {
        return end;
    }

    /**
     * Checks whether the split has an ending point or not.
     *
     * @return <code>true</code> if the split has end and <code>false</code> if not
     */
    protected boolean hasEnd() {
        return end != END_OF_LINE;
    }

    /**
     * Removes special characters stored in the <code>specialCharacter</code> array.
     *
     * @param source the String source
     * @return the String source without the special characters
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
