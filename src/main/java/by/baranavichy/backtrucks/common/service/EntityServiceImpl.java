package by.baranavichy.backtrucks.common.service;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.enricher.EntityFetcher;
import by.baranavichy.backtrucks.common.exception.ResourceNotFoundException;
import by.baranavichy.backtrucks.common.model.to.AbstractTO;
import by.baranavichy.backtrucks.persistence.model.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Vanya on 27.04.2019.
 */
@RequiredArgsConstructor
public abstract class EntityServiceImpl<E extends AbstractEntity<ID>, T extends AbstractTO<ID>, ID> implements EntityService<T, ID> {

    private final EntityTOConverter<E, T> converter;
    private final JpaRepository<E, ID> jpaRepository;
    private final EntityFetcher<E> entityFetcher;

    @Override
    public T getOne(ID id) {
        return jpaRepository.findById(id)
                .map(converter::convertToTO)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Reource with if:%s not found", id)));
    }

    @Override
    public Collection<T> getAll() {
        Collection<E> entities = jpaRepository.findAll();
        return converter.convertToTos(entities);
    }

    @Override
    @Transactional
    public T save(T to) {
        E entityToFetch = converter.convertToEntity(to);
        E fetchedEntity = entityFetcher.fetch(entityToFetch);
        Optional<ID> maybeExistingEntityId = getExistingEntityId(fetchedEntity);

        maybeExistingEntityId.ifPresent(fetchedEntity::setId);
        E savedEntity = jpaRepository.save(fetchedEntity);

        return converter.convertToTO(savedEntity);
    }

    @Override
    public void delete(T to) {
        E entityToDelete = converter.convertToEntity(to);
        Optional<ID> maybeExistingEntityId = getExistingEntityId(entityToDelete);
        maybeExistingEntityId.ifPresent(jpaRepository::deleteById);
    }

    protected abstract Optional<ID> getExistingEntityId(E entityToSave);

}
