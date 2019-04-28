package by.baranavichy.backtrucks.common.converter;

import by.baranavichy.backtrucks.persistence.model.AbstractEntity;

/**
 * Created by Vanya on 27.04.2019.
 */
public interface EntityTOConverter<E extends AbstractEntity, T> {

    E convertToEntity(T to);

    T convertToTO(E entity);

}
