package by.baranavichy.backtrucks.common.converter.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.model.to.DetailTO;
import by.baranavichy.backtrucks.persistence.model.Detail;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
public class DetailConverter implements EntityTOConverter<Detail, DetailTO> {

    @Override
    public Detail convertToEntity(DetailTO to) {
        Detail detail = new Detail();
        detail.setId(to.getId());
        detail.setName(to.getName());
        return detail;
    }

    @Override
    public DetailTO convertToTO(Detail entity) {
        DetailTO detail = new DetailTO();
        detail.setId(entity.getId());
        detail.setName(entity.getName());
        return detail;
    }
}
