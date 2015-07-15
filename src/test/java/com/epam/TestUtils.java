package com.epam;

import java.text.SimpleDateFormat;

public class TestUtils {

    public static String getFormattedValue(long timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return simpleDateFormat.format(timestamp);
    }

}
