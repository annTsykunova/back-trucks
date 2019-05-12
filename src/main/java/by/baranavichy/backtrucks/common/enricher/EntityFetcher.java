package by.baranavichy.backtrucks.common.enricher;

import by.baranavichy.backtrucks.persistence.model.AbstractEntity;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

/**
 * Created by Vanya on 10.05.2019.
 */

@Slf4j
public abstract class EntityFetcher<E extends AbstractEntity> {

    @Transactional(Transactional.TxType.MANDATORY)
    public E fetch(E entity) {
        log.debug(String.format("Enriching entity %s", entity));
        return fetchEntity(entity);
    }

    protected E fetchEntity(E entityToEnrich) {
        return entityToEnrich;
    }

}
