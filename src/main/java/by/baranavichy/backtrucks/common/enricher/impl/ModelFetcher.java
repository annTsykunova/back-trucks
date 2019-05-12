package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.enricher.EntityFetcher;
import by.baranavichy.backtrucks.persistence.model.Engine;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.model.Model;
import by.baranavichy.backtrucks.persistence.repository.EngineRepository;
import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
@RequiredArgsConstructor
public class ModelFetcher extends EntityFetcher<Model> {

    private final ManufacturerRepository manufacturerRepository;
    private final EngineRepository engineRepository;

    @Override
    protected Model fetchEntity(Model model) {
        Optional<Manufacturer> maybeManufacturer =
                manufacturerRepository.findByNameIgnoreCase(model.getManufacturer().getName());

        maybeManufacturer.ifPresent(model::setManufacturer);

        Stream<Optional<Engine>> maybeEngines =
                model.getEnginesCopy().stream()
                        .map(engineTO -> engineRepository.findByNameIgnoreCase(engineTO.getName()));
        //TODO delete all engines
        maybeEngines
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(model::addEngine);

        return model;
    }
}
