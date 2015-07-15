package com.epam;

import org.joda.time.DateTime;
import org.junit.Test;

import static com.epam.TestUtils.getFormattedValue;


public class TimestampGeneratorTest {

    private TimestampGenerator timestampGenerator = new TimestampGenerator();

    @Test
    public void test() {
        DateTime dateTime = new DateTime(2015, 7, 15, 10, 0, 0, 0);
        long previousTimestamp = dateTime.getMillis();
        int numberOfCommits = 168;
        for (int i = 0; i < numberOfCommits; i++) {
            System.out.println(getFormattedValue(previousTimestamp));
            previousTimestamp = timestampGenerator.nextValue(previousTimestamp);
        }
    }

    @Test
    public void testBeginningOfDay() {
        DateTime dateTime = new DateTime().withTimeAtStartOfDay().withHourOfDay(10);
        System.out.println(getFormattedValue(dateTime.getMillis()));
    }



}
