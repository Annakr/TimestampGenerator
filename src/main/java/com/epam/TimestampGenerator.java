package com.epam;

import java.util.Random;

public class TimestampGenerator {
    
    private static final int ONE_MINUTE_IN_MILLIS = 60000;
    private static final int RANGE_IN_MILLIS = 200000;

    private Random random = new Random(System.currentTimeMillis());

    public long nextValue(long previousValue) {
        int randomTimeInterval = ONE_MINUTE_IN_MILLIS + random.nextInt(RANGE_IN_MILLIS);
        return previousValue + randomTimeInterval;
    }

}
