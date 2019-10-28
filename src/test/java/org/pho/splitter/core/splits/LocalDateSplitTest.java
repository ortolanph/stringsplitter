package org.pho.splitter.core.splits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.time.LocalDate;

@DisplayName("DateSplit Test") public class LocalDateSplitTest {

    private static final String DATA = "1977-14-1214/12/1977";

    @Test
    @DisplayName("Simple split")
    public void localDateSimpleDateSplit() throws SplitterException {
        LocalDate actual = LocalDateSplit.newLocalDateSplit(0, 10).split(DATA);
    }

}