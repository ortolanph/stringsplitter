package org.pho.splitter.core.builders;

import org.pho.splitter.beans.StringSplit;
import org.pho.splitter.beans.WordCase;
import org.pho.splitter.core.splitters.StringArraySplitter;

public class StringArraySplitterBuilder {

    private static final StringArraySplitterBuilder INSTANCE = new StringArraySplitterBuilder();

    private static StringArraySplitter splitter;

    private StringArraySplitterBuilder() { }

    public static StringArraySplitterBuilder newSplitter() {
        splitter = new StringArraySplitter();
        return INSTANCE;
    }

    public StringArraySplitterBuilder addStringSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, end, wordCase, trimmed));
        return this;
    }

    public StringArraySplitterBuilder addStringSplit(int start, int end, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, end, trimmed));
        return this;
    }

    public StringArraySplitterBuilder addStringSplit(int start, int end, WordCase wordCase) {
        splitter.addSplit(StringSplit.newSplit(start, end, wordCase));
        return this;
    }

    public StringArraySplitterBuilder addStringSplit(int start, int end) {
        splitter.addSplit(StringSplit.newSplit(start, end));
        return this;
    }

    public StringArraySplitterBuilder addStringSplit(int start, WordCase wordCase, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, wordCase, trimmed));
        return this;
    }

    public StringArraySplitterBuilder addStringSplit(int start, WordCase wordCase) {
        splitter.addSplit(StringSplit.newSplit(start, wordCase));
        return this;
    }

    public StringArraySplitterBuilder addStringSplit(int start, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, trimmed));
        return this;
    }

    public StringArraySplitterBuilder addStringSplit(int start) {
        splitter.addSplit(StringSplit.newSplit(start));
        return this;
    }

    public StringArraySplitter build() {
        return splitter;
    }
}
