package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BooleanSplitTest {

    private static final String TRUE_FALSE_DATA = "truefalse";

    private static final String FALSE_TRUE_DATA = "falsetrue";

    private static final String ONE_ZERO_DATA = "10";

    private static final String VERDADEIRO_FALSO_DATA = "verdadeirofalso";

    private static final Function<String, Boolean> TRUE_FALSE_FUNCTION =
            source -> (source.trim().toLowerCase().equals("true")) ? Boolean.TRUE : Boolean.FALSE;

    private static final Function<String, Boolean> ONE_ZERO_FUNCTION =
            source -> (source.equals("1")) ? Boolean.TRUE : Boolean.FALSE;

    private static final Function<String, Boolean> VERDADEIRO_FALSO_FUNCTION =
            source -> (source.trim().toLowerCase().equals("verdadeiro")) ? Boolean.TRUE : Boolean.FALSE;

    @Test
    @DisplayName("Boolean split true test")
    public void shouldReturnTrue() {
        Boolean condition = BooleanSplit.newBooleanSplit(0, 4, TRUE_FALSE_FUNCTION).split(TRUE_FALSE_DATA);
        assertTrue(condition);
    }

    @Test
    @DisplayName("Boolean split false test")
    public void shouldReturnFalse() {
        Boolean condition = BooleanSplit.newBooleanSplit(0, 5, TRUE_FALSE_FUNCTION).split(FALSE_TRUE_DATA);
        assertFalse(condition);
    }

    @Test
    @DisplayName("No limit boolean split true test")
    public void noLimitShouldReturnTrue() {
        Boolean condition = BooleanSplit.newBooleanSplit(5, TRUE_FALSE_FUNCTION).split(FALSE_TRUE_DATA);
        assertTrue(condition);
    }

    @Test
    @DisplayName("No limit boolean split false test")
    public void noLimitShouldReturnFalse() {
        Boolean condition = BooleanSplit.newBooleanSplit(4, TRUE_FALSE_FUNCTION).split(FALSE_TRUE_DATA);
        assertFalse(condition);
    }

    @Test
    @DisplayName("Boolean split 1/0 true test")
    public void oneZeroTrueTest() {
        Boolean condition = BooleanSplit.newBooleanSplit(0, 1, ONE_ZERO_FUNCTION).split(ONE_ZERO_DATA);
        assertTrue(condition);
    }

    @Test
    @DisplayName("Boolean split 1/0 false test")
    public void oneZeroFalseTest() {
        Boolean condition = BooleanSplit.newBooleanSplit(1, ONE_ZERO_FUNCTION).split(ONE_ZERO_DATA);
        assertFalse(condition);
    }

    @Test
    @DisplayName("Boolean split verdadeiro/falso true test")
    public void verdadeiroFalsoTrueTest() {
        Boolean condition = BooleanSplit.newBooleanSplit(0, 10, VERDADEIRO_FALSO_FUNCTION).split(VERDADEIRO_FALSO_DATA);
        assertTrue(condition);
    }

    @Test
    @DisplayName("Boolean split verdadeiro/falso false test")
    public void verdadeiroFalsoFalseTest() {
        Boolean condition = BooleanSplit.newBooleanSplit(10, VERDADEIRO_FALSO_FUNCTION).split(VERDADEIRO_FALSO_DATA);
        assertFalse(condition);
    }

}
