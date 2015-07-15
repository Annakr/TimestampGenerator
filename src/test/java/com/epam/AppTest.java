package com.epam;

import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.epam.TestUtils.getFormattedValue;

public class AppTest {

    public static final String PATH_TO_FILE = "D:\\timestamp.txt";

    @After
    public void deleteFile() {
        new File(PATH_TO_FILE).delete();
    }

    @Test
    public void test() throws IOException {

        int numberOfCommits = 168;

        for (int i = 0; i < numberOfCommits; i++) {
            App.main(PATH_TO_FILE);

            long timestamp = App.readPreviousValueFromFile(PATH_TO_FILE);
            System.out.println(getFormattedValue(timestamp));
        }


    }

}
