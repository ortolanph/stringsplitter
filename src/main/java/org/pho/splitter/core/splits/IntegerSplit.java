package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

public class IntegerSplit extends AbstractSplitter<Integer> {

    private String[] specialCharacters;

    private static final String NOTHING = "";

    private IntegerSplit(int start, int end) {
        setStart(start);
        setEnd(end);
    }

    private IntegerSplit(int start, int end, String... specialCharacters) {
        setStart(start);
        setEnd(end);
        this.specialCharacters = specialCharacters;
    }

    public static IntegerSplit newIntegerSplit(int start, int end) {
        return new IntegerSplit(start, end);
    }

    public static IntegerSplit newIntegerSplit(int start) {
        return new IntegerSplit(start, END_OF_LINE);
    }

    public static IntegerSplit newIntegerSplit(int start, int end, String... specialCharacters) {
        return new IntegerSplit(start, end, specialCharacters);
    }

    public static IntegerSplit newIntegerSplit(int start, String... specialCharacters) {
        return new IntegerSplit(start, END_OF_LINE, specialCharacters);
    }

    @Override public Integer split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        try {
            return Integer.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }

    private String removeSpecialCharacters(String source) {
        String result = source;

        if(specialCharacters != null) {
            for (String specialCharacter : specialCharacters) {
                result = result.replaceAll(specialCharacter, NOTHING);
            }
        }

        return result;
    }
}
