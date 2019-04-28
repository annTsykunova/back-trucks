package by.baranavichy.backtrucks.common.model;

import lombok.Data;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by Vanya on 28.04.2019.
 */

@Data
public class GetterSetterPair<T1, T2, P> {

    private Function<T2, P> getter;
    private BiConsumer<T1, P> setter;

    public static <T1, T2, P> GetterSetterPair<T1, T2, P> of(Function<T2, P> getter, BiConsumer<T1, P> setter) {
        GetterSetterPair<T1, T2, P> getterSetterPair = new GetterSetterPair<>();
        getterSetterPair.setGetter(getter);
        getterSetterPair.setSetter(setter);
        return getterSetterPair;
    }

}
