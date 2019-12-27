package org.pho.splitter.core.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Exception test")
class SplitterExceptionTest {

    @Test
    @DisplayName("Exception test")
    public void shouldThrowException() {
        try {
            testMethod();
        } catch (SplitterException e) {
            assertEquals("Throwing Exception", e.getMessage());
            assertEquals(NullPointerException.class, e.getCause().getClass());
        }
    }

    @Test
    @DisplayName("Throws test")
    public void shouldThrwowSplitterException() {
        assertThrows(SplitterException.class, () -> testMethod());
    }

    public void testMethod() throws SplitterException {
        throw new SplitterException("Throwing Exception", new NullPointerException());
    }

}