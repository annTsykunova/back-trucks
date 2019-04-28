package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.importing.model.CountryImportTO;
import by.baranavichy.backtrucks.importing.model.column.CountryColumn;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Vanya on 28.04.2019.
 */

@Component
public class CountryImportParser
        extends ImportParser<CountryImportTO> {

    public CountryImportParser() {
        super(CountryColumn.class);
    }

    @Override
    protected Supplier<CountryImportTO> getNewImportTO() {
        return CountryImportTO::new;
    }

    @Override
    public Collection<GetterSetterPair<CountryImportTO, CSVRecord, ?>> getImportTOGettersAndTOSetters() {
        return List.of(
                GetterSetterPair.of(record -> record.get(CountryColumn.NAME), CountryImportTO::setName),
                GetterSetterPair.of(record -> record.get(CountryColumn.CODE), CountryImportTO::setCode)
        );
    }
}
