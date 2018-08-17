package org.pho.splitter.core.splits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StringSplit Test") class StringSplitTest {

    @Test
    @DisplayName("Create a StringSplit with start and end")
    public void shouldCreateASplitStartEnd() {
        final StringSplit stringSplit = StringSplit.newSplit(0, 10);

        final int expectedStart = 0;
        final int expectedEnd = 10;
        final boolean expectedHasEnd = true;

        assertAll(
            () -> assertEquals(expectedStart, stringSplit.getStart()),
            () -> assertEquals(expectedEnd, stringSplit.getEnd()),
            () -> assertEquals(expectedHasEnd, stringSplit.hasEnd()));
    }

    @Test
    @DisplayName("Create a StringSplit with start only")
    public void shouldCreateASplitStart() {
        final StringSplit stringSplit = StringSplit.newSplit(0);

        final int expectedStart = 0;
        final int expectedEnd = 0;
        final boolean expectedHasEnd = false;

        assertAll(
            () -> assertEquals(expectedStart, stringSplit.getStart()),
            () -> assertEquals(expectedEnd, stringSplit.getEnd()),
            () -> assertEquals(expectedHasEnd, stringSplit.hasEnd()));

    }
}
