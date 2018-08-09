package org.pho.splitter.core;

import org.pho.splitter.beans.Split;

public class StringSplitterBuilder {

    private static final StringSplitterBuilder INSTANCE = new StringSplitterBuilder();

    private StringSplitter splitter;

    private StringSplitterBuilder() {
        splitter = new StringSplitter();
    }

    public static StringSplitterBuilder newSplitter() {
        return INSTANCE;
    }

    public StringSplitterBuilder addSplit(int start, int end) {
        splitter.addSplit(Split.newSplit(start, end));
        return this;
    }

    public StringSplitterBuilder addSplit(int start) {
        splitter.addSplit(Split.newSplit(start));
        return this;
    }

    public StringSplitter build() {
        return splitter;
    }
}
