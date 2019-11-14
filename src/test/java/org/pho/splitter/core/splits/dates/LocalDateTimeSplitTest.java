package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

@DisplayName("LocalDateTimeSplit Test")
class LocalDateTimeSplitTest {

    private static final String DATA_1 = "2019-11-14T11:17:39.049Thursday, 14 November 2019, 11:49";

    private static final String DATA_2 = "Thursday, 14 November 2019, 11:492019-11-14T11:17:39.049";

    private static final DateTimeFormatter OTHER_FORMAT = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm");

    @Test
    @DisplayName("LocalDateTime simple split")
    public void shouldSplitSimpleLocalDateTime() {

    }

    @Test
    @DisplayName("LocalDateTime simple split at end")
    public void shouldSplitSimpleLocalDateTimeAtEnd() {}

    @Test
    @DisplayName("LocalDateTime custom split")
    public void shouldSplitCustomLocalDateTime() {

    }

    @Test
    @DisplayName("LocalDateTime custom split at end")
    public void shouldSplitCustomLocalDateTimeAtEnd() {

    }
}
