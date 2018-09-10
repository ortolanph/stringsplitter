package org.pho.splitter.core.splits;

import org.pho.splitter.core.function.SplitFunction;

public abstract class AbstractSplitter<T> implements SplitFunction<T> {

    protected static final int END_OF_LINE = 0;

    private static final String NOTHING = "";

    private String[] specialCharacters;

    private int start;

    private int end;

    public AbstractSplitter(int start, int end, String... specialCharacters) {
        this.start = start;
        this.end = end;
        this.specialCharacters = specialCharacters;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    protected boolean hasEnd() {
        return end != END_OF_LINE;
    }

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
