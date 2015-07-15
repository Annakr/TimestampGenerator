package com.epam;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;

import java.io.*;
import java.util.List;

public class App {

    public static final long BEGINNING_OF_THIS_DAY = new DateTime().withTimeAtStartOfDay().withHourOfDay(10).getMillis();
    public static final long LUNCH_TIME_BEGINNING = new DateTime().withTimeAtStartOfDay().withHourOfDay(14).getMillis();
    public static final long LUNCH_TIME_END = new DateTime().withTimeAtStartOfDay().withHourOfDay(15).getMillis();

    /**
     * @param args first argument - path to file
     */
    public static void main(String... args) throws IOException {
        String filePath = getPathToFile(args);
        long previousValue = readPreviousValueFromFile(filePath);
        long newValue = generateNewValue(previousValue);
        writeToFile(filePath, newValue);
    }

    private static String getPathToFile(String[] args) {
        try {
            return args[0];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Path to file should be specified");
        }
    }

    public static long readPreviousValueFromFile(String filePath) throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            List lines = IOUtils.readLines(fis);
            String firstLine = (String) lines.get(0);
            return Long.valueOf(firstLine);
        } catch (Exception e) {
            return BEGINNING_OF_THIS_DAY;
        }
    }

    private static long generateNewValue(Long previousValue) {
        long newValue = new TimestampGenerator().nextValue(previousValue);
        if (isLunchTime(newValue))
            return new TimestampGenerator().nextValue(LUNCH_TIME_END);
        else return newValue;
    }

    private static boolean isLunchTime(long newValue) {
        return newValue > LUNCH_TIME_BEGINNING && newValue < LUNCH_TIME_END;
    }

    private static void writeToFile(String filePath, long newValue) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            IOUtils.write(String.valueOf(newValue), fos);
        }
    }

}
