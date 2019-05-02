package by.baranavichy.backtrucks.common.converter;

import by.baranavichy.backtrucks.persistence.model.AbstractEntity;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Vanya on 27.04.2019.
 */
public interface EntityTOConverter<E extends AbstractEntity, T> {

    E convertToEntity(T to);

    T convertToTO(E entity);

    default Collection<T> convertToTos(Collection<E> entities) {
        return entities.stream()
                .map(this::convertToTO)
                .collect(Collectors.toList());
    }

}
