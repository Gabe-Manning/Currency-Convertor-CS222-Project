package edu.bsu.cs222;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CurrentDateGetter {

    public String getCurrentDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime currentDate = LocalDateTime.now();
        String formatted = dateTimeFormatter.format(currentDate);
        return formatted.replace("/", "-");
    }
}
