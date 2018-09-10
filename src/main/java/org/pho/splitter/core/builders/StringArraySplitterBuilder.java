package org.pho.splitter.core.builders;

import org.pho.splitter.core.splits.StringArraySplit;
import org.pho.splitter.core.splits.StringSplit;
import org.pho.splitter.core.splits.WordCase;

/**
 * Builder to create String Array Splitter.
 */
public class StringArraySplitterBuilder {

    private static final StringArraySplitterBuilder INSTANCE = new StringArraySplitterBuilder();

    private static StringArraySplit splitter;

    private StringArraySplitterBuilder() {
    }

    /**
     * Creates a new StringArraySplitterBuilder.
     *
     * @return a builder instance
     */
    public static StringArraySplitterBuilder newSplitter() {
        splitter = new StringArraySplit();
        return INSTANCE;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @param end where the split ends
     * @param wordCase the word case
     * @param trimmed if it's needed to remove blank spaces
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start, int end, WordCase wordCase, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, end, wordCase, trimmed));
        return this;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @param end where the split ends
     * @param trimmed if it's needed to remove blank spaces
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start, int end, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, end, trimmed));
        return this;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @param end where the split ends
     * @param wordCase the word case
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start, int end, WordCase wordCase) {
        splitter.addSplit(StringSplit.newSplit(start, end, wordCase));
        return this;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @param end where the split ends
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start, int end) {
        splitter.addSplit(StringSplit.newSplit(start, end));
        return this;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @param wordCase the word case
     * @param trimmed if it's needed to remove blank spaces
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start, WordCase wordCase, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, wordCase, trimmed));
        return this;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @param wordCase the word case
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start, WordCase wordCase) {
        splitter.addSplit(StringSplit.newSplit(start, wordCase));
        return this;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @param trimmed if it's needed to remove blank spaces
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start, boolean trimmed) {
        splitter.addSplit(StringSplit.newSplit(start, trimmed));
        return this;
    }

    /**
     * Adds a StringSplit with a start, an end, word cased and trimmed.
     *
     * @param start where the split begins
     * @return a builder instance
     */
    public StringArraySplitterBuilder addStringSplit(int start) {
        splitter.addSplit(StringSplit.newSplit(start));
        return this;
    }

    /**
     * Builds a StringArraySplit.
     *
     * @return a StringArraySplit
     */
    public StringArraySplit build() {
        return splitter;
    }
}
