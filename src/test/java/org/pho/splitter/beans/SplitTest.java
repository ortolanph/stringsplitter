package org.pho.splitter.beans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Split Test") class SplitTest {

    @Test
    @DisplayName("Create a Split with start and end")
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
    @DisplayName("Create a Split with start only")
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
