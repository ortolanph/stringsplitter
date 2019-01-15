package org.pho.splitter.core.splits;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.splits.features.WordCase;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldSplitTest {

    private static final String DATA = "NONONOSPLIT THIS TEXTNONONO";

    @Test
    public void using() {
        FieldSplit<String> stringFieldSplit =
            FieldSplit.newFieldSplit("field", StringSplit.newSplit(6, 21, WordCase.LOWER_CASE));

        assertAll(
            () -> assertEquals("field", stringFieldSplit.getFieldName()),
            () -> assertEquals("split this text", stringFieldSplit.split(DATA))
        );
    }
}
