package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.ModelConverter;
import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.common.service.EntityServiceImpl;
import by.baranavichy.backtrucks.common.service.ModelService;
import by.baranavichy.backtrucks.persistence.model.Engine;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.model.Model;
import by.baranavichy.backtrucks.persistence.repository.EngineRepository;
import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
import by.baranavichy.backtrucks.persistence.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Vanya on 05.05.2019.
 */

@Service
public class ModelServiceImpl
        extends EntityServiceImpl<Model, ModelTO, Long>
        implements ModelService {

    private final ModelRepository modelRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final EngineRepository engineRepository;
    private final ModelConverter modelConverter;

    public ModelServiceImpl(ModelConverter modelConverter, ModelRepository modelRepository,
                            ManufacturerRepository manufacturerRepository, EngineRepository engineRepository) {
        super(modelConverter, modelRepository);
        this.modelRepository = modelRepository;
        this.modelConverter = modelConverter;
        this.manufacturerRepository = manufacturerRepository;
        this.engineRepository = engineRepository;
    }

    @Override
    protected Optional<Model> getExistingEntity(Model entityToSave) {
        return modelRepository.findByNameIgnoreCase(entityToSave.getName());
    }

    @Override
    protected Model convertToEntity(ModelTO toToSave) {
        Model model = modelConverter.convertToEntity(toToSave);

        Optional<Manufacturer> maybeManufacturer =
                manufacturerRepository.findByNameIgnoreCase(toToSave.getManufacturer().getName());

        maybeManufacturer.ifPresent(model::setManufacturer);

        Stream<Optional<Engine>> maybeEngines =
                toToSave.getEnginesCopy().stream()
                        .map(engineTO -> engineRepository.findByNameIgnoreCase(engineTO.getName()));
        maybeEngines
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(model::addEngine);

        return model;
    }

}
