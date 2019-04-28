package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.converter.GetterSetterInterface;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;

import java.util.function.Supplier;

/**
 * T - to type
 * I - importTO type
 * P - property type
 * <p>
 * Created by Vanya on 28.04.2019.
 */
public abstract class ImportConverterImpl<T, I>
        implements ImportConverter<T, I>, GetterSetterInterface<T, I> {

    @Override
    public T toTo(I importTo) {
        T to = getTOSupplier().get();
        getImportTOGettersAndTOSetters().forEach(getterSetterPair -> {
            convertProperty(to, importTo, getterSetterPair);
        });
        return to;
    }

    protected abstract Supplier<T> getTOSupplier();


}
