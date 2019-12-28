package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.function.SplitFunction;

/**
 * Abstract class to save basic information for specilized split.
 *
 * @param <T> The base type to be returned
 * @author Paulo Henrique Ortolan
 */
public abstract class AbstractSplitter<T> implements SplitFunction<T> {

    /**
     * Means to the end of the line.
     */
    protected static final int END_OF_LINE = -1;

    private static final String NOTHING = "";

    private final String[] specialCharacters;

    private final int start;

    private final int end;

    /**
     * Creates a new AbstractSplitter.
     *
     * @param start             where the split starts
     * @param end               where the split ends
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
     * Returns all the special characters.
     *
     * @return the special characters.
     */
    public String[] getSpecialCharacters() {
        return specialCharacters;
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
    public String removeSpecialCharactersAndSplit(String source) throws SplitterException {
        String result = "";
        try {
            result = simpleSplit(source);
        } catch (SplitterException exception) {
            throw new SplitterException(exception.getMessage(), exception);
        }

        if (getSpecialCharacters() != null) {
            for (String specialCharacter : getSpecialCharacters()) {
                result = result.replaceAll(specialCharacter, NOTHING);
            }
        }

        return result;
    }

    public String simpleSplit(String source) throws SplitterException {
        try {
            return ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        } catch (Exception exception) {
            throw new SplitterException(exception.getMessage(), exception);
        }
    }

}
