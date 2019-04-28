package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.Action;
import by.baranavichy.backtrucks.importing.model.ImportTO;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.service.ImportService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Vanya on 28.04.2019.
 */
public abstract class ImportServiceImpl<T, I extends ImportTO> implements ImportService<T, I> {

    @Override
    public void importData(MultipartFile file) {
        try {
            Collection<I> importTOS = getParser().parse(file);
            Map<Action, List<I>> importTOsByAction = importTOS.stream()
                    .collect(Collectors.groupingBy(ImportTO::getAction));
            importTOsByAction.getOrDefault(Action.UPDATE, Collections.emptyList()).stream()
                    .map(getImportConverter()::toTo)
                    .forEach(getEntityService()::save);
            importTOsByAction.getOrDefault(Action.DELETE, Collections.emptyList()).stream()
                    .map(getImportConverter()::toTo)
                    .forEach(getEntityService()::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract ImportParser<I> getParser();

    protected abstract EntityService<T> getEntityService();

    protected abstract ImportConverter<T, I> getImportConverter();

}
