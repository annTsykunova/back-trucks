package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.importing.converter.CountryImportConverter;
import by.baranavichy.backtrucks.importing.model.CountryImportTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Vanya on 28.04.2019.
 */

@Component
public class CountryImportConverterImpl
        extends ImportConverterImpl<CountryTO, CountryImportTO>
        implements CountryImportConverter {

    @Override
    protected Supplier<CountryTO> getTOSupplier() {
        return CountryTO::new;
    }

    @Override
    public Collection<GetterSetterPair<CountryTO, CountryImportTO, ?>> getImportTOGettersAndTOSetters() {
        return List.of(
                GetterSetterPair.of(CountryImportTO::getName, CountryTO::setName),
                GetterSetterPair.of(CountryImportTO::getCode, CountryTO::setCode)
        );
    }
}