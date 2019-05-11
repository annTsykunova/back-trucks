package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.model.to.DetailTO;
import by.baranavichy.backtrucks.common.service.DetailService;
import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.converter.impl.DetailImportConverter;
import by.baranavichy.backtrucks.importing.model.DetailImportTO;
import by.baranavichy.backtrucks.importing.parser.DetailImportParser;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.service.DetailImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Vanya on 10.05.2019.
 */

@Service
@RequiredArgsConstructor
public class DetailImportServiceImpl
        extends ImportServiceImpl<DetailTO, DetailImportTO>
        implements DetailImportService {

    private final DetailImportParser detailImportParser;
    private final DetailService detailService;
    private final DetailImportConverter detailImportConverter;

    @Override
    protected ImportParser<DetailImportTO, ? extends Enum<?>> getParser() {
        return this.detailImportParser;
    }

    @Override
    protected EntityService<DetailTO, ?> getEntityService() {
        return this.detailService;
    }

    @Override
    protected ImportConverter<DetailTO, DetailImportTO> getImportConverter() {
        return this.detailImportConverter;
    }
}
