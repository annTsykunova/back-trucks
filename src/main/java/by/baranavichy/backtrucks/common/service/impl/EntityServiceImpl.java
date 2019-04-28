package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.persistence.model.AbstractEntity;
import by.baranavichy.backtrucks.persistence.repository.EntityRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

/**
 * Created by Vanya on 27.04.2019.
 */
@RequiredArgsConstructor
public abstract class EntityServiceImpl<E extends AbstractEntity, T, ID> implements EntityService<T> {

    private final EntityTOConverter<E, T> converter;
    private final EntityRepository<E, ID> repository;

    @Override
    @Transactional
    public T save(T to) {
        E entityToSave = converter.convertToEntity(to);
        E savedEntity = repository.save(entityToSave);
        return converter.convertToTO(savedEntity);
    }
}
