package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class CalendarSplitTest {

    @Test
    @Disabled
    @DisplayName("Dummy test")
    public void dummyTest() throws ParseException {
        Calendar calendar = new GregorianCalendar();

        System.out.println(calendar.getTime().toString());
        System.out.println(calendar.getTimeInMillis());

        Calendar calendar0 = Calendar.getInstance();
        calendar0.setTimeInMillis(1573742407197L);
        System.out.println(calendar0.getTime().toString());

        String myDate = "14/11/2019 14:24:17";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = sdf.parse(myDate);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        System.out.println(calendar1.getTime().toString());
    }
}
