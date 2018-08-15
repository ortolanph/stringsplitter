package org.pho.splitter.core.builders;

import org.pho.splitter.beans.StringSplit;
import org.pho.splitter.beans.WordCase;
import org.pho.splitter.core.splitters.StringSplitter;

public class StringSplitterBuilder {

    private static final StringSplitterBuilder INSTANCE = new StringSplitterBuilder();

    private static StringSplitter splitter;

    private StringSplitterBuilder() { }

    public static StringSplitterBuilder newSplitter() {
        splitter = new StringSplitter();
        return INSTANCE;
    }

    public StringSplitterBuilder addStringSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, end, wordCase, trimmed));
        return this;
    }

    public StringSplitterBuilder addStringSplit(int start, int end, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, end, trimmed));
        return this;
    }

    public StringSplitterBuilder addStringSplit(int start, int end, WordCase wordCase) {
        splitter.addSplit(StringSplit.newSplit(start, end, wordCase));
        return this;
    }

    public StringSplitterBuilder addStringSplit(int start, int end) {
        splitter.addSplit(StringSplit.newSplit(start, end));
        return this;
    }

    public StringSplitterBuilder addStringSplit(int start, WordCase wordCase, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, wordCase, trimmed));
        return this;
    }

    public StringSplitterBuilder addStringSplit(int start, WordCase wordCase) {
        splitter.addSplit(StringSplit.newSplit(start, wordCase));
        return this;
    }

    public StringSplitterBuilder addStringSplit(int start, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, trimmed));
        return this;
    }

    public StringSplitterBuilder addStringSplit(int start) {
        splitter.addSplit(StringSplit.newSplit(start));
        return this;
    }

    public StringSplitter build() {
        return splitter;
    }
}
