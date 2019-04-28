package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.importing.converter.ManufacturerImportConverter;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
public class ManufacturerImportConverterTO
        extends ImportConverterImpl<ManufacturerTO, ManufacturerImportTO>
        implements ManufacturerImportConverter {

    @Override
    protected Supplier<ManufacturerTO> getTOSupplier() {
        return ManufacturerTO::new;
    }

    @Override
    public Collection<GetterSetterPair<ManufacturerTO, ManufacturerImportTO, ?>> getImportTOGettersAndTOSetters() {
        return List.of(
                GetterSetterPair.of(ManufacturerImportTO::getName, ManufacturerTO::setName)
        );
    }


}
