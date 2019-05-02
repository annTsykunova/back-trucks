package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.importing.model.Action;
import by.baranavichy.backtrucks.importing.model.EngineImportTO;
import by.baranavichy.backtrucks.importing.model.column.EngineColumn;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Vanya on 29.04.2019.
 */

@Component
public class EngineImportParser extends ImportParser<EngineImportTO> {

    public EngineImportParser() {
        super(EngineColumn.class);
    }

    @Override
    protected Collection<GetterSetterPair<EngineImportTO, CSVRecord, ?>> getGettersAndSetters() {
        return List.of(
                GetterSetterPair.of(record -> {
                    String actionString = record.get(EngineColumn.ACTION);
                    return Action.findByValueIgnoreCase(actionString).orElse(null);
                }, EngineImportTO::setAction),
                GetterSetterPair.of(record -> record.get(EngineColumn.NAME), EngineImportTO::setName),
                GetterSetterPair.of(record -> Short.valueOf(record.get(EngineColumn.DISPLACEMENT)), EngineImportTO::setDisplacement),
                GetterSetterPair.of(record -> record.get(EngineColumn.MANUFACTURER_NAME), EngineImportTO::setManufacturerName)
        );
    }

    @Override
    protected Supplier<EngineImportTO> getNewImportTO() {
        return EngineImportTO::new;
    }
}
