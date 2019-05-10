package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.converter.impl.ManufacturerConverter;
import by.baranavichy.backtrucks.common.enricher.ToEnricher;
import by.baranavichy.backtrucks.common.model.to.EngineTO;
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
public class EngineEnricher extends ToEnricher<EngineTO> {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerConverter manufacturerConverter;

    @Override
    protected EngineTO enrichTo(EngineTO toToEnrich) {
        Optional<Manufacturer> maybeManufacturer =
                manufacturerRepository.findByNameIgnoreCase(toToEnrich.getManufacturer().getName());
        maybeManufacturer.map(manufacturerConverter::convertToTO)
                .ifPresent(toToEnrich::setManufacturer);
        return toToEnrich;
    }
}
