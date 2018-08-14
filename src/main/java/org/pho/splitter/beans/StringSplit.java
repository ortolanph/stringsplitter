package org.pho.splitter.beans;

import org.pho.splitter.function.SplitFunction;

import java.util.Objects;

public class StringSplit implements SplitFunction<String> {

    private static final int END_OF_LINE = 0;

    private int start;

    private int end;

    private WordCase wordCase;

    private boolean trimmed;

    private StringSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        this.start = start;
        this.end = end;
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

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public WordCase getWordCase() {
        return wordCase;
    }

    public boolean isTrimmed() {
        return trimmed;
    }

    public boolean hasEnd() {
        return end != END_OF_LINE;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StringSplit stringSplit = (StringSplit) o;
        return start == stringSplit.start &&
            end == stringSplit.end;
    }

    @Override public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override public String split(String source) {
        String result = (hasEnd())? source.substring(start, end) : source.substring(start);
        result = (trimmed)? result.trim() : result;
        return wordCase.apply(result);
    }
}
