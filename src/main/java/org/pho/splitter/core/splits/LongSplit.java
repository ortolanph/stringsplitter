package org.pho.splitter.core.splits;

public class LongSplit extends AbstractSplitter<Long> {

    private String[] specialCharacters;

    private LongSplit(int start, int end, String... specialCharacters) {
        setStart(start);
        setEnd(end);
    }

    public static LongSplit newLongSplit(int start, int end, String... specialCharacters) {
        return new LongSplit(start, end, specialCharacters);
    }

    public static LongSplit newLongSplit(int start, String... specialCharacters) {
        return new LongSplit(start, END_OF_LINE, specialCharacters);
    }

    @Override public Long split(String source) {
        return null;
    }
}