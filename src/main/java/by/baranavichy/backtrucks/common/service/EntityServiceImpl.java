package by.baranavichy.backtrucks.common.service;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.enricher.ToEnricher;
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
public abstract class EntityServiceImpl<E extends AbstractEntity, T, ID> implements EntityService<T> {

    private final EntityTOConverter<E, T> converter;
    private final JpaRepository<E, ID> jpaRepository;
    private final ToEnricher<T> toEnricher;

    @Override
    public Collection<T> getAll() {
        Collection<E> entities = jpaRepository.findAll();
        return converter.convertToTos(entities);
    }

    @Override
    @Transactional
    public T save(T to) {
        T enrichedTo = toEnricher.enrich(to);
        E entityToSave = converter.convertToEntity(enrichedTo);
        Optional<E> maybeExistingEntity = getExistingEntity(entityToSave);

        maybeExistingEntity.ifPresent(existingEntity -> entityToSave.setId(existingEntity.getId()));
        E savedEntity = jpaRepository.save(entityToSave);

        return converter.convertToTO(savedEntity);
    }

    @Override
    public void delete(T to) {
        E entityToDelete = converter.convertToEntity(to);
        Optional<E> maybeExistingEntity = getExistingEntity(entityToDelete);
        maybeExistingEntity.ifPresent(jpaRepository::delete);
    }

    protected abstract Optional<E> getExistingEntity(E entityToSave);

}
