package by.baranavichy.backtrucks.util;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vanya on 05.05.2019.
 */

public class ListUtils {

    private ListUtils() {
    }

    public static <T> List<T> copyList(List<T> from) {
        return Collections.unmodifiableList(from);
//        List<T> to = new ArrayList<>(from.size());
//        Collections.copy(to, from);
//        return to;
    }
}
