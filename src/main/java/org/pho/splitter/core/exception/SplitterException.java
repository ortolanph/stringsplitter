package org.pho.splitter.core.exception;

/**
 * Exception to be thrown when there's an error splitting strings.
 */
public class SplitterException extends Exception {

    /**
     * Creates an exception.
     *
     * @param message exception message
     * @param exception exception thrown
     */
    public SplitterException(String message, Exception exception) {
        super(message, exception);
    }

}
