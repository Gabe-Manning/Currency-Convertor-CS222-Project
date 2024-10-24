package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentDateGetterTest {
    @Test
    public void getCurrentDateTest() {
        CurrentDateGetter currentDateGetter = new CurrentDateGetter();
        String currentDate = currentDateGetter.getCurrentDate();
        Assertions.assertNotEquals(currentDate, "2024-10-23");
    }
}
