package by.baranavichy.backtrucks.util;

import java.time.LocalDate;

/**
 * Created by Vanya on 06.05.2019.
 */

public class DateUtils {

    private DateUtils() {
    }

    public static LocalDate importStringToLocalDate(String importString) {
        String[] tokens;
        if (importString.matches("\\d{4}")) {
            return LocalDate.of(Integer.valueOf(importString), 1, 1);
//            return LocalDate.ofYearDay(importString, DateTimeFormatter.ofPattern("yyyy"));
        } else if (importString.matches("\\d{4}-\\d{2}")) {
            tokens = importString.split("-");
            return LocalDate.of(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]), 1);
        } else if (importString.matches("\\d{4}-\\d{2}-\\d{2}")) {
            tokens = importString.split("-");
            return LocalDate.of(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
        }
        throw new IllegalArgumentException(String.format("%s cannot be parsd to date", importString));
    }

}
