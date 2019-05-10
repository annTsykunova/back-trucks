package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.converter.impl.EngineConverter;
import by.baranavichy.backtrucks.common.converter.impl.ManufacturerConverter;
import by.baranavichy.backtrucks.common.enricher.ToEnricher;
import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.persistence.model.Engine;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
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
public class ModelEnricher extends ToEnricher<ModelTO> {

    private final ManufacturerRepository manufacturerRepository;
    private final EngineRepository engineRepository;
    private final ManufacturerConverter manufacturerConverter;
    private final EngineConverter engineConverter;

    @Override
    protected ModelTO enrichTo(ModelTO toToEnrich) {
        Optional<Manufacturer> maybeManufacturer =
                manufacturerRepository.findByNameIgnoreCase(toToEnrich.getManufacturer().getName());

        maybeManufacturer.map(manufacturerConverter::convertToTO)
                .ifPresent((toToEnrich::setManufacturer));

        Stream<Optional<Engine>> maybeEngines =
                toToEnrich.getEnginesCopy().stream()
                        .map(engineTO -> engineRepository.findByNameIgnoreCase(engineTO.getName()));
        maybeEngines
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(engineConverter::convertToTO)
                .forEach(toToEnrich::addEngine);

        return toToEnrich;
    }
}
