package org.pho.splitter.core.splits;

public class StringSplit extends AbstractSplitter<String> {

    private WordCase wordCase;

    private boolean trimmed;

    private StringSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        setStart(start);
        setEnd(end);
        this.wordCase = wordCase;
        this.trimmed = trimmed;
    }

    public static StringSplit newSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        return new StringSplit(start, end, wordCase, trimmed);
    }

    public static StringSplit newSplit(int start, int end, WordCase wordCase) {
        return new StringSplit(start, end, wordCase, false);
    }

    public static StringSplit newSplit(int start, int end, boolean trimmed) {
        return new StringSplit(start, end, WordCase.NO_CASE, trimmed);
    }

    public static StringSplit newSplit(int start, int end) {
        return new StringSplit(start, end, WordCase.NO_CASE, false);
    }

    public static StringSplit newSplit(int start, WordCase wordCase, boolean trimmed) {
        return new StringSplit(start, END_OF_LINE, wordCase, trimmed);
    }

    public static StringSplit newSplit(int start, WordCase wordCase) {
        return new StringSplit(start, END_OF_LINE, wordCase, false);
    }

    public static StringSplit newSplit(int start, boolean trimmed) {
        return new StringSplit(start, END_OF_LINE, WordCase.NO_CASE, trimmed);
    }

    public static StringSplit newSplit(int start) {
        return new StringSplit(start, END_OF_LINE, WordCase.NO_CASE, false);
    }

    @Override public String split(String source) {
        String result = (hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart());
        result = (trimmed) ? result.trim() : result;
        return wordCase.apply(result);
    }
}
