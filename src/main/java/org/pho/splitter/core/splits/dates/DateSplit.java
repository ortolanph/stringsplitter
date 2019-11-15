package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSplit extends AbstractSplitter<Date> {

    private SimpleDateFormat format;

    private DateSplit(int start, int end) {
        super(start, end);
    }

    public static DateSplit fromFormatted(int start, int end, SimpleDateFormat format) {
        DateSplit dateSplit = new DateSplit(start, end);
        dateSplit.format = format;
        return dateSplit;
    }

    public static DateSplit fromFormatted(int start, SimpleDateFormat format) {
        return fromFormatted(start, END_OF_LINE, format);
    }

    public static DateSplit fromLong(int start, int end) {
        return new DateSplit(start, end);
    }

    public static DateSplit fromLong(int start) {
        return new DateSplit(start, END_OF_LINE);
    }


    @Override
    public Date split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);
        Date splitted = null;

        try {
            splitted = (format == null) ?
                    new Date(Long.valueOf(result)):
                    format.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return splitted;
    }
}
