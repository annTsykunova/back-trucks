package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.Action;
import by.baranavichy.backtrucks.importing.model.ImportTO;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.service.ImportService;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Stream;

/**
 * Created by Vanya on 28.04.2019.
 */
public abstract class ImportServiceImpl<T, I extends ImportTO> implements ImportService<T, I> {

    @Override
    public void importData(MultipartFile file) {
        Stream<I> importTOS = getParser().parse(file);
        importTOS.map(this::toActionToPair)
                .forEach(this::processImportTo);
    }

    protected abstract ImportParser<I, ? extends Enum<?>> getParser();

    protected abstract EntityService<T> getEntityService();

    protected abstract ImportConverter<T, I> getImportConverter();

    private ActionToPair toActionToPair(I importTo) {
        Action action = importTo.getAction();
        T to = getImportConverter().toTo(importTo);
        return new ActionToPair(action, to);
    }

    private void processImportTo(ActionToPair actionToPair) {
        switch (actionToPair.action) {
            case UPDATE:
                getEntityService().save(actionToPair.to);
                break;
            case DELETE:
                getEntityService().delete(actionToPair.to);
                break;
            default:
                throw new IllegalArgumentException(String.format("No action %s", actionToPair.action));
        }
    }

    @AllArgsConstructor
    private class ActionToPair {

        private Action action;
        private T to;

    }

}
