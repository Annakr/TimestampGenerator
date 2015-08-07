package com.epam;

import java.util.Random;

public class TimestampGenerator {
    
    private static final int ONE_MINUTE_IN_MILLIS = 60000;
    private int rangeInMillis;

    public TimestampGenerator(int rangeInMillis) {
        this.rangeInMillis = rangeInMillis;
    }

    private Random random = new Random(System.currentTimeMillis());

    public long nextValue(long previousValue) {
        int randomTimeInterval = ONE_MINUTE_IN_MILLIS + random.nextInt(rangeInMillis);
        return previousValue + randomTimeInterval;
    }

}
