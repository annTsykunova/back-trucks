package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.Action;
import by.baranavichy.backtrucks.importing.model.ImportTO;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.service.ImportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Stream;

/**
 * Created by Vanya on 28.04.2019.
 */

@Slf4j
public abstract class ImportServiceImpl<T, I extends ImportTO> implements ImportService<T, I> {

    @Override
    public void importData(MultipartFile file) {
        Stream<I> importTOS = getParser().parse(file);
        importTOS.forEach(this::processImportTo);
    }

    protected abstract ImportParser<I, ? extends Enum<?>> getParser();

    protected abstract EntityService<T, ?> getEntityService();

    protected abstract ImportConverter<T, I> getImportConverter();

    private void processImportTo(I importTo) {
        try {
            Action action = importTo.getAction();
            T to = getImportConverter().toTo(importTo);
            switch (action) {
                case UPDATE:
                    getEntityService().save(to);
                    break;
                case DELETE:
                    getEntityService().delete(to);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("No action %s", action));
            }
        } catch (Exception e) {
            log.error("Error import line", e);
        }
    }

}
