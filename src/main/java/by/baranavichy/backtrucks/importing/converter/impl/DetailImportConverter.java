package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.DetailTO;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.DetailImportTO;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
public class DetailImportConverter implements ImportConverter<DetailTO, DetailImportTO> {

    @Override
    public DetailTO toTo(DetailImportTO importTo) {
        DetailTO detailTO = new DetailTO();
        detailTO.setName(importTo.getName());

        return detailTO;
    }
}
