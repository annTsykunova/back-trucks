package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.enricher.EntityFetcher;
import by.baranavichy.backtrucks.persistence.model.Engine;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
@RequiredArgsConstructor
public class EngineFetcher extends EntityFetcher<Engine> {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    protected Engine fetchEntity(Engine engine) {
        Optional<Manufacturer> maybeManufacturer =
                manufacturerRepository.findByNameIgnoreCase(engine.getManufacturer().getName());
        maybeManufacturer.ifPresent(engine::setManufacturer);
        return engine;
    }
}
