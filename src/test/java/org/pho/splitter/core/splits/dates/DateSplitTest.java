package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateSplitTest {

    @Test
    @Disabled
    @DisplayName("Dummy Test")
    public void dummyTest() throws ParseException {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        Date date0 = new Date(1573741446848L);
        System.out.println(date0.toString());

        String myDate = "14/11/2019 14:24:17";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = sdf.parse(myDate);
        System.out.println(date1.toString());
    }
}
