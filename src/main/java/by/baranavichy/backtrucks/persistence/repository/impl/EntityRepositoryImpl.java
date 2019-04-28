package by.baranavichy.backtrucks.persistence.repository.impl;

import by.baranavichy.backtrucks.persistence.model.AbstractEntity;
import by.baranavichy.backtrucks.persistence.repository.EntityRepository;
import lombok.RequiredArgsConstructor;

/**
 * Created by Vanya on 28.04.2019.
 */

@RequiredArgsConstructor
public class EntityRepositoryImpl<E extends AbstractEntity> implements EntityRepository<E> {

}
