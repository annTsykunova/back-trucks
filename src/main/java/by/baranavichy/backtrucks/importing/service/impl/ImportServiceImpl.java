package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.service.ImportService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Vanya on 28.04.2019.
 */
public abstract class ImportServiceImpl<T, I> implements ImportService<T, I> {


    @Override
    public void importData(MultipartFile file) {
        try {
            Collection<I> importTOS = getParser().parse(file);
            importTOS.stream()
                    .map(getImportConverter()::toTo)
                    .forEach(getEntityService()::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract ImportParser<I> getParser();

    protected abstract EntityService<T> getEntityService();

    protected abstract ImportConverter<T, I> getImportConverter();

}
