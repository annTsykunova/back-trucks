package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.importing.model.Action;
import by.baranavichy.backtrucks.importing.model.ModelImportTO;
import by.baranavichy.backtrucks.importing.model.column.ModelColumn;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Vanya on 05.05.2019.
 */

@Component
public class ModelImportParser extends ImportParser<ModelImportTO, ModelColumn> {

    public ModelImportParser() {
        super(ModelColumn.values());
    }

    @Override
    protected Collection<GetterSetterPair<ModelImportTO, CSVRecord, ?>> getGettersAndSetters() {
        return List.of(
                GetterSetterPair.of(record -> {
                    String actionString = record.get(ModelColumn.ACTION);
                    return Action.findByValueIgnoreCase(actionString).orElse(null);
                }, ModelImportTO::setAction),
                GetterSetterPair.of(record -> record.get(ModelColumn.NAME), ModelImportTO::setName),
                GetterSetterPair.of(record -> record.get(ModelColumn.MANUFACTURER), ModelImportTO::setManufacturerName),
                GetterSetterPair.of(record -> record.get(ModelColumn.ENGINE), ModelImportTO::setEngineName),
                GetterSetterPair.of(record -> record.get(ModelColumn.YEAR_START), ModelImportTO::setProductionDateStart),
                GetterSetterPair.of(record -> record.get(ModelColumn.YEAR_END), ModelImportTO::setProductionDateEnd)
        );
    }

    @Override
    protected Supplier<ModelImportTO> getNewImportTO() {
        return ModelImportTO::new;
    }
}
