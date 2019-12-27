package org.pho.splitter.core.splits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Abstract Splitter Test")
class AbstractSplitterTest {

    private static final String DATA="A@B#C@D&E@FGHIJ";
    private static final int END_OF_LINE = -1;
    private static final int START = 0;
    private static final int END = 10;
    private static final String[] SPECIAL_CHARACTERS = {"@", "#", "&"};

    @Test
    @DisplayName("Simple data test")
    public void shouldRetrieveInputData() {
        AbstractSplitterMock mock = new AbstractSplitterMock(START, END, SPECIAL_CHARACTERS);

        assertAll(
                () -> assertEquals(START, mock.getStart()),
                () -> assertEquals(END, mock.getEnd()),
                () -> assertArrayEquals(SPECIAL_CHARACTERS, mock.getSpecialCharacters())
        );
    }

    @Test
    @DisplayName("To the end of the String data test")
    public void shouldRetrieveInputDataToTheEndOfTheString() {
        AbstractSplitterMock mock = new AbstractSplitterMock(START, AbstractSplitter.END_OF_LINE, SPECIAL_CHARACTERS);

        assertAll(
                () -> assertEquals(START, mock.getStart()),
                () -> assertEquals(END_OF_LINE, mock.getEnd()),
                () -> assertArrayEquals(SPECIAL_CHARACTERS, mock.getSpecialCharacters())
        );
    }

    @Test
    @DisplayName("Split test")
    public void shouldSplitString() throws SplitterException {
        AbstractSplitterMock mock = new AbstractSplitterMock(START, END, SPECIAL_CHARACTERS);

        String actual = mock.split(DATA);
        String expected = "ABCDE";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Failed Split test")
    public void shouldNotSplitString() throws SplitterException {
        AbstractSplitterMock mock = new AbstractSplitterMock(1, 0, SPECIAL_CHARACTERS);

        assertThrows(SplitterException.class, () -> mock.split(DATA));
    }

    class AbstractSplitterMock extends AbstractSplitter<String> {

        public AbstractSplitterMock(int start, int end, String... specialCharacters) {
            super(start, end, specialCharacters);
        }

        @Override
        public String split(String source) throws SplitterException {
            return super.removeSpecialCharactersAndSplit(source);
        }
    }
}