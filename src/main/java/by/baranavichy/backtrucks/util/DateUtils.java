package by.baranavichy.backtrucks.util;

import java.time.LocalDate;

/**
 * Created by Vanya on 06.05.2019.
 */

public class DateUtils {

    private DateUtils() {
    }

    public static LocalDate importStringToLocalDate(String importString) {
        if (importString.matches("\\d{4}")) {
            return LocalDate.ofYearDay(Integer.valueOf(importString), 1);
//            return LocalDate.ofYearDay(importString, DateTimeFormatter.ofPattern("yyyy"));
        }
        throw new IllegalArgumentException(String.format("%s cannot be parsd to date", importString));
    }

}
