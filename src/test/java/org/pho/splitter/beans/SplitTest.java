package org.pho.splitter.beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitTest {

    @Test
    public void shouldCreateASplitStartEnd() {
        final Split split = Split.newSplit(0, 10);

        final int expectedStart = 0;
        final int expectedEnd = 10;
        final boolean expectedHasEnd = true;

        assertAll(
            () -> assertEquals(expectedStart, split.getStart()),
            () -> assertEquals(expectedEnd, split.getEnd()),
            () -> assertEquals(expectedHasEnd, split.hasEnd()));
    }

    @Test
    public void shouldCreateASplitStart() {
        final Split split = Split.newSplit(0);

        final int expectedStart = 0;
        final int expectedEnd = 0;
        final boolean expectedHasEnd = false;

        assertAll(
            () -> assertEquals(expectedStart, split.getStart()),
            () -> assertEquals(expectedEnd, split.getEnd()),
            () -> assertEquals(expectedHasEnd, split.hasEnd()));

    }
}
