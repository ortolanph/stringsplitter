package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

public class ShortSplit extends AbstractSplitter<Short> {

    private String[] specialCharacters;

    private static final String NOTHING = "";

    private ShortSplit(int start, int end, String... specialCharacters) {
        super(start, end, specialCharacters);
    }

    public static ShortSplit newShortSplit(int start, int end) {
        return new ShortSplit(start, end);
    }

    public static ShortSplit newShortSplit(int start) {
        return new ShortSplit(start, END_OF_LINE);
    }

    public static ShortSplit newShortSplit(int start, int end, String... specialCharacters) {
        return new ShortSplit(start, end, specialCharacters);
    }

    public static ShortSplit newShortSplit(int start, String... specialCharacters) {
        return new ShortSplit(start, END_OF_LINE, specialCharacters);
    }

    @Override public Short split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        try {
            return Short.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }

}
