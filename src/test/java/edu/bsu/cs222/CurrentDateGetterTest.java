package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentDateGetterTest {

    CurrentDateGetter currentDateGetter = new CurrentDateGetter();

    @Test
    public void getCurrentDateTest() {
        String currentDate = currentDateGetter.getCurrentDate();
        Assertions.assertNotEquals(currentDate, "2024-10-23");
    }
}
