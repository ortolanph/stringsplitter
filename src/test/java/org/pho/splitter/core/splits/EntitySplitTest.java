package org.pho.splitter.core.splits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.builders.EntityBuilder;
import org.pho.splitter.core.exception.SplitterException;

import static org.junit.jupiter.api.Assertions.*;

class EntitySplitTest {

    private static final String DATA = "  2  0  0";

    @Test
    @DisplayName("Entity Split test")
    public void splitTest() throws SplitterException {
        EntityBuilder builder =
                EntityBuilder
                        .newEntityBuilder()
                        .forClass(Version.class)
                        .intField("major", IntegerSplit.newIntegerSplit(0, 3))
                        .intField("minor", IntegerSplit.newIntegerSplit(3, 6))
                        .intField("bugfix", IntegerSplit.newIntegerSplit(6, 9));

        EntitySplit split = new EntitySplit(builder);

        Version actual = (Version)split.split(DATA);

        Version expected = new Version();
        expected.setMajor(2);
        expected.setMinor(0);
        expected.setBugfix(0);

        assertAll(
                () -> assertEquals(expected.getMajor(), actual.getMajor()),
                () -> assertEquals(expected.getMinor(), actual.getMinor()),
                () -> assertEquals(expected.getBugfix(), actual.getBugfix())
        );
    }

}