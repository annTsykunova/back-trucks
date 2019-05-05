package by.baranavichy.backtrucks.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Vanya on 05.05.2019.
 */

public class WordUtils {

    private WordUtils() {
    }

    public static String capitalizeEachWord(String stringToCapitalize) {
        return Arrays.stream(stringToCapitalize.split(" "))
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(" "));
    }

}
