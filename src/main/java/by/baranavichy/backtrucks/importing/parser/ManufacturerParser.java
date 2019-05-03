package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.importing.model.Action;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import by.baranavichy.backtrucks.importing.model.column.ManufacturerColumn;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
public class ManufacturerParser extends ImportParser<ManufacturerImportTO, ManufacturerColumn> {

    public ManufacturerParser() {
        super(ManufacturerColumn.values());
    }

    @Override
    protected Collection<GetterSetterPair<ManufacturerImportTO, CSVRecord, ?>> getGettersAndSetters() {
        return List.of(
                GetterSetterPair.of(record -> {
                    String actionString = record.get(ManufacturerColumn.ACTION);
                    return Action.findByValueIgnoreCase(actionString).orElse(null);
                }, ManufacturerImportTO::setAction),
                GetterSetterPair.of(record -> record.get(ManufacturerColumn.NAME), ManufacturerImportTO::setName),
                GetterSetterPair.of(record -> record.get(ManufacturerColumn.COUNTRY), ManufacturerImportTO::setCountryCode)
        );
    }

    @Override
    protected Supplier<ManufacturerImportTO> getNewImportTO() {
        return ManufacturerImportTO::new;
    }

}
