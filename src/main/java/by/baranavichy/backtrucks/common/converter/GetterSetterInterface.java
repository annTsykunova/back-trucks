package by.baranavichy.backtrucks.common.converter;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * T1 - type of object to set
 * T2 - type of object to get
 * <p>
 * Created by Vanya on 28.04.2019.
 */
public interface GetterSetterInterface<T1, T2> {

    Collection<GetterSetterPair<T1, T2, ?>> getImportTOGettersAndTOSetters();

    default <P> void convertProperty(T1 to, T2 importTo, GetterSetterPair<T1, T2, P> getterSetterPair) {
        Function<T2, P> getter = getterSetterPair.getGetter();
        P property = getter.apply(importTo);

        BiConsumer<T1, P> setter = getterSetterPair.getSetter();
        setter.accept(to, property);
    }

}
