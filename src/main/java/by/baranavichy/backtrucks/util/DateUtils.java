package by.baranavichy.backtrucks.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Vanya on 06.05.2019.
 */

public class DateUtils {

    private DateUtils() {
    }

    public static LocalDate importStringToLocalDate(String importString) {
        if (importString.matches("\\d{4}")) {
            return LocalDate.parse(importString, DateTimeFormatter.ofPattern("yyyy"));
        }
        throw new IllegalArgumentException(String.format("%s cannot be parsd to date", importString));
    }

}
