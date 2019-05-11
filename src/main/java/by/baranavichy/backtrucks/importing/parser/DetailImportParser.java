package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.importing.model.Action;
import by.baranavichy.backtrucks.importing.model.DetailImportTO;
import by.baranavichy.backtrucks.importing.model.column.DetailColumn;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
public class DetailImportParser extends ImportParser<DetailImportTO, DetailColumn> {

    public DetailImportParser() {
        super(DetailColumn.values());
    }

    @Override
    protected Collection<GetterSetterPair<DetailImportTO, CSVRecord, ?>> getGettersAndSetters() {
        return List.of(
                GetterSetterPair.of(record -> {
                    String actionString = record.get(DetailColumn.ACTION);
                    return Action.findByValueIgnoreCase(actionString).orElse(null);
                }, DetailImportTO::setAction),
                GetterSetterPair.of(record -> record.get(DetailColumn.NAME), DetailImportTO::setName)
        );
    }

    @Override
    protected Supplier<DetailImportTO> getNewImportTO() {
        return DetailImportTO::new;
    }
}
