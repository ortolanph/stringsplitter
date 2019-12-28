package org.pho.splitter.core.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Functional interface test")
class SplitFunctionTest {

    @Test
    @DisplayName("Basic test")
    public void shouldCapitalizaStringSource() throws SplitterException {
        SplitFunction<String> function = (String source) -> source.toUpperCase();

        String actual = function.split("abcde");
        String expected = "ABCDE";

        assertEquals(expected, actual);
    }


}