package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.importing.model.Action;
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
public class CountryImportParser extends ImportParser<CountryImportTO> {

    public CountryImportParser() {
        super(CountryColumn.class);
    }

    @Override
    protected Collection<GetterSetterPair<CountryImportTO, CSVRecord, ?>> getGettersAndSetters() {
        return List.of(
                GetterSetterPair.of(record -> {
                    String actionString = record.get(CountryColumn.ACTION);
                    return Action.findByValueIgnoreCase(actionString).orElse(null);
                }, CountryImportTO::setAction),
                GetterSetterPair.of(record -> record.get(CountryColumn.NAME), CountryImportTO::setName),
                GetterSetterPair.of(record -> record.get(CountryColumn.CODE), CountryImportTO::setCode)
        );
    }

    @Override
    protected Supplier<CountryImportTO> getNewImportTO() {
        return CountryImportTO::new;
    }

}
