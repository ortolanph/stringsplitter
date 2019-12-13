package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CharactgerSplit Test")
class CharacterSplitTest {

    private static final String DATA = "A\u0000\uffff";

    @Test
    @DisplayName("Character split test")
    public void splitTest() {
        char actual = CharacterSplit.newCharacterSplit(0).split(DATA);
        char expected = 'A';
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Character split test max")
    public void maximumCharacter() {
        char actual = CharacterSplit.newCharacterSplit(1).split(DATA);
        char expected = '\u0000';
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Character split test min")
    public void minimumCharacter() {
        char actual = CharacterSplit.newCharacterSplit(2).split(DATA);
        char expected = '\uffff';
        assertEquals(expected, actual);
    }

}
